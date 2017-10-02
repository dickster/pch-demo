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

import org.apache.commons.lang3.StringUtils;
import org.xmlunit.diff.ElementSelector;
import org.xmlunit.diff.ElementSelectors;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to encapsulate a simple selector for XmlUnit.
 */
public class SimpleXmlUnitSelector {
    private final String nodeName;
    private final ElementSelector selector;
    private final List<ElementSelector> keyFields = new ArrayList<>();

    /**
     * Public constructor.
     *
     * @param pNodeName  The name of the parent node to compare.
     * @param attributes The list of attribute as key fields.
     * @param xpaths     The basic xpaths to reach the key field.  Supports multiple key fields.
     */
    public SimpleXmlUnitSelector(String pNodeName,
                                 List<String> attributes,
                                 List<String> xpaths) {
        this.nodeName = pNodeName;

        appendAttributeSelector(attributes);
        appendXpathSelector(xpaths);
        ElementSelector[] array = new ElementSelector[keyFields.size()];

        this.selector = keyFields.size() == 1 ? keyFields.get(0) : ElementSelectors.and(keyFields.toArray(array));
    }

    /**
     * Append xpath selector into the list.
     *
     * @param xpaths list of xpath.
     */
    private void appendXpathSelector(List<String> xpaths) {
        for (String xpath : xpaths) {
            StringBuilder xmlUnitXpath = new StringBuilder();
            String[] tokens = StringUtils.split(xpath, "/");

            for (int xpathTokenCount = 0; xpathTokenCount < tokens.length; xpathTokenCount++) {
                if (xpathTokenCount == 0) {
                    xmlUnitXpath.append(".");
                }

                xmlUnitXpath.append("/*[local-name()='").append(tokens[xpathTokenCount]).append("']");
            }

            keyFields.add(ElementSelectors.byXPath(xmlUnitXpath.toString(), ElementSelectors.byNameAndText));
        }
    }

    /**
     * Append attribute selector into the list.
     *
     * @param attributes the list of attributes.
     */
    private void appendAttributeSelector(List<String> attributes) {
        for (String attribute : attributes) {
            keyFields.add(ElementSelectors.byNameAndAttributes(attribute));
        }
    }

    /**
     * Get the node name.
     *
     * @return The node name.
     */
    public String getNodeName() {
        return this.nodeName;
    }

    /**
     * Get the selector.
     *
     * @return The selector.
     */
    public ElementSelector getSelector() {
        return this.selector;
    }
}
