/*
 * Copyright (c) brovada Technologies, Inc. All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * brovada Technologies, Inc. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with brovada.
 */
package com.brovada.policychange.service.comparitor;

import com.brovada.policychange.model.comparitor.PchJsonManifest;
import com.brovada.policychange.model.comparitor.PchJsonManifestItem;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xmlunit.builder.DiffBuilder;
import org.xmlunit.builder.Input;
import org.xmlunit.diff.Comparison;
import org.xmlunit.diff.ComparisonType;
import org.xmlunit.diff.DefaultNodeMatcher;
import org.xmlunit.diff.Diff;
import org.xmlunit.diff.Difference;
import org.xmlunit.diff.ElementSelector;
import org.xmlunit.diff.ElementSelectors;
import org.xmlunit.util.Nodes;
import org.xmlunit.util.Predicate;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Utilities for working with XmlUnit and policy change.
 */
public final class XmlUnitUtils {

    private static final String ENDS_WITH_TEXT_NODE_PATTERN = ".+(/text\\(\\))(\\[\\d+\\])?$";

    private static final String DELETE = "DELETE";

    private static final String ADD = "ADD";

    private static final String CHANGE = "CHANGE";

    private static final String TEXT = "#text";

    /**
     * Private constructor.  Prevent instantiation.
     */
    private XmlUnitUtils() {
    }

    /**
     * Build an entire document selector for use within XmlUnit comparisons.
     *
     * @param selectors The selectors.
     *
     * @return The aggregated selector for the entire document.
     */
    public static ElementSelector buildDocumentSelector(List<SimpleXmlUnitSelector> selectors) {
        ElementSelectors.ConditionalSelectorBuilder acordSelector = ElementSelectors.conditionalBuilder();

        for (SimpleXmlUnitSelector selector : selectors) {
            acordSelector.whenElementIsNamed(selector.getNodeName()).thenUse(selector.getSelector());
        }

        return acordSelector.elseUse(ElementSelectors.byName).build();
    }

    /**
     * Generate the JSON manifest file.
     *
     * @param myDiff        differences
     * @param ignoredXpaths the ignored xPaths
     *
     * @return JSON manifest string
     *
     * @throws JsonProcessingException JSON processing error
     */
    public static PchJsonManifest generateManifest(Diff myDiff,
                                                   Set<String> ignoredXpaths) throws JsonProcessingException {
        PchJsonManifest manifest = new PchJsonManifest();
        Iterator<Difference> itor = myDiff.getDifferences().iterator();
        if (myDiff.hasDifferences()) {
            while (itor.hasNext()) {
                Difference next = itor.next();
                ComparisonType comparisonType = next.getComparison().getType();
                // Added the ELEMENT_NUM_ATTRIBUTES, ELEMENT_TAG_NAME, ATTR_VALUE to the following 'ignore' list, by Victor @ May 05, 2017
                // TODO: it make sense in the future to make this list configurable so for different projects we could set it up in a different way
                if (comparisonType == ComparisonType.CHILD_NODELIST_LENGTH
                    || comparisonType == ComparisonType.CHILD_NODELIST_SEQUENCE
                    || comparisonType == ComparisonType.ATTR_NAME_LOOKUP
                    || comparisonType == ComparisonType.ELEMENT_NUM_ATTRIBUTES
                    || comparisonType == ComparisonType.ELEMENT_TAG_NAME
                    || comparisonType == ComparisonType.ATTR_VALUE
                    || comparisonType == ComparisonType.NAMESPACE_URI) {
                    continue;
                }
                Comparison.Detail newDetails = next.getComparison().getControlDetails();
                Comparison.Detail oldDetails = next.getComparison().getTestDetails();

                Object oldValue = oldDetails.getValue();
                Object newValue = newDetails.getValue();
                String oldXPath = oldDetails.getXPath();
                String newXPath = newDetails.getXPath();

                if (isIgnoredDiff(ignoredXpaths, oldXPath, newXPath)) {
                    continue;
                }

                // use the parent XPath if the 'new' XPath ends with "/text()[1]"
                if (newXPath != null && newXPath.matches(ENDS_WITH_TEXT_NODE_PATTERN)) {
                    newXPath = newDetails.getParentXPath();
                }
                // use the parent XPath if the 'old' XPath ends with "/text()[1]"
                if (oldXPath != null && oldXPath.matches(ENDS_WITH_TEXT_NODE_PATTERN)) {
                    oldXPath = oldDetails.getParentXPath();
                }

                // check the 'new' XPath first to catch the case when both XPaths may be missing (theoretically should never happen) to process it as "element was deleted".
                if (newXPath == null) {

                    String oldValueString;
                    if (Node.TEXT_NODE == oldDetails.getTarget().getNodeType()) {
                        oldValueString = oldDetails.getTarget().getParentNode().getLocalName();
                    }
                    else {
                        oldValueString = oldValue.toString().split("}")[1];
                    }

                    manifest.getDeletedList()
                            .add(new PchJsonManifestItem(DELETE, oldXPath, null, oldValueString, null, oldXPath));
                }
                else if (oldXPath == null) {

                    String newValueString;
                    if (Node.TEXT_NODE == newDetails.getTarget().getNodeType()) {
                        newValueString = newDetails.getTarget().getParentNode().getLocalName();
                    }
                    else {
                        newValueString = newValue.toString().split("}")[1];
                    }

                    manifest.getAddedList()
                            .add(new PchJsonManifestItem(ADD, newXPath, newValueString, null, newXPath, null));
                }
                else {

                    manifest.getChangedList()
                            .add(new PchJsonManifestItem(CHANGE,
                                    newXPath,
                                    newValue.toString(),
                                    oldValue.toString(),
                                    newXPath,
                                    oldXPath));
                }
            }

        }
        return manifest;
    }

    /**
     * Check if the diff should be ignored by checking ignore xpath lists.
     *
     * @param ignoreSet ignored xpath set
     * @param oldXpath  old xpath
     * @param newXpath  new xpath
     *
     * @return true if should be ignored
     */
    private static boolean isIgnoredDiff(Set<String> ignoreSet, String oldXpath, String newXpath) {

        for (String ignoredXpath : ignoreSet) {

            boolean isIgnored = false;

            if (oldXpath != null) {
                isIgnored = truncateXpathWithNoIndex(oldXpath).contains(ignoredXpath);
            }

            if (newXpath != null) {
                isIgnored = truncateXpathWithNoIndex(newXpath).contains(ignoredXpath);
            }

            if (isIgnored) {
                return true;
            }
        }
        return false;
    }

    /**
     * Utility method to truncate xpath with no index.
     *
     * @param xpath xpath
     *
     * @return xpath without index
     */
    private static String truncateXpathWithNoIndex(String xpath) {
        return xpath.replaceAll("\\[\\d+]", "");
    }

    /**
     * Add a node filter.
     *
     * @param blackList the black list.
     * @param whiteList the white list.
     *
     * @return a node filter
     */
    public static Predicate<Node> addNodeFilter(final Set<String> blackList, final Set<String> whiteList) {
        return new Predicate<Node>() {
            @Override
            public boolean test(Node toTest) {
                String localName = Nodes.getQName(toTest).getLocalPart();
                if (localName.equals(TEXT)) {
                    return true;
                }
                else {
                    boolean inBlack = blackList.contains(localName) && toTest instanceof Element;
                    boolean inWhite = whiteList.isEmpty() || whiteList.contains(localName) && toTest instanceof Element;
                    return !inBlack && inWhite;
                }
            }
        };
    }

    /**
     * Do the actual compare. Build the DiffBuilder with node filter and node matter with custom selectors.
     *
     * @param pchOld     old policy.
     * @param pchNew     new policy.
     * @param selector   custom selectors.
     * @param nodeFilter node filter
     *
     * @return a Diff - compare result
     */
    public static Diff doCompare(String pchOld, String pchNew, ElementSelector selector, Predicate<Node> nodeFilter) {

        return DiffBuilder.compare(Input.fromString(pchNew))
                          .withTest(Input.fromString(pchOld))
                          .withNodeMatcher(new DefaultNodeMatcher(selector))
                          .ignoreComments()
                          .ignoreWhitespace()
                          .normalizeWhitespace()
                          .withNodeFilter(nodeFilter)
                          .build();
    }
}
