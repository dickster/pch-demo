/*
 * Copyright (c) brovada Technologies, Inc. All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * brovada Technologies, Inc. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with brovada.
 */

package com.brovada.policychange.service.remarkgenerator;

import com.brovada.policychange.model.comparitor.Changes;
import com.brovada.policychange.model.comparitor.PchJsonManifest;
import com.brovada.policychange.model.comparitor.PchJsonManifestItem;
import com.brovada.policychange.model.remarkgenerator.PchRemarkItem;
import com.brovada.policychange.service.remarkgenerator.utils.DictionaryUtils;
import com.brovada.policychange.service.remarkgenerator.utils.RemarkUtils;
import com.brovada.policychange.service.remarkgenerator.utils.SensitiveUtils;
import com.brovada.policychange.service.remarkgenerator.utils.XmlUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPathExpressionException;
import java.io.ByteArrayInputStream;
import java.text.MessageFormat;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * The type Remark generator service.
 */
@Service
public class RemarkGeneratorService {

    /**
     * The constant ADD.
     */
    private static final String ADD = "ADD";

    /**
     * The constant DELETE.
     */
    private static final String DELETE = "DELETE";

    /**
     * The constant CHANGE.
     */
    private static final String CHANGE = "CHANGE";

    /**
     * The constant PCH_MANIFEST.
     */
    private static final String PCH_MANIFEST = "PCH_MANIFEST";

    /**
     * The constant PCH_OLD.
     */
    private static final String PCH_OLD = "PCH_OLD";

    /**
     * The constant PCH_NEW.
     */
    private static final String PCH_NEW = "PCH_NEW";

    /**
     * The constant PCH_SUMMARY_REMARKS.
     */
    private static final String PCH_SUMMARY_REMARKS = "PCH_SUMMARY_REMARKS";

    /**
     * The Added list.
     */
    private List<PchJsonManifestItem> addedList;

    /**
     * The Changed list.
     */
    private List<PchJsonManifestItem> changedList;

    /**
     * The Deleted list.
     */
    private List<PchJsonManifestItem> deletedList;

    /**
     * The Root.
     */
    private PchRemarkItem root;

    /**
     * The Old document.
     */
    private Document oldDocument;

    /**
     * The New document.
     */
    private Document newDocument;

    /**
     * Generate.
     *
     * @param manifest the manifest
     * @param oldXml   the old xml
     * @param newXml   the new xml
     */
    public void generate(PchJsonManifest manifest, final String oldXml, final String newXml) {
        init(manifest, oldXml, newXml);
        analystManifest();
        String remarks = generateRemarks();
    }

    /**
     * Init.
     *
     * @param manifest the manifest
     * @param oldXml   the old xml
     * @param newXml   the new xml
     */
    private void init(PchJsonManifest manifest, String oldXml, String newXml) {

        try {
            String oldXmlNoNs = removeXmlStringNamespaceAndPreamble(oldXml);
            String newXmlNoNs = removeXmlStringNamespaceAndPreamble(newXml);

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(false);
            DocumentBuilder builder = factory.newDocumentBuilder();

            oldDocument = builder.parse(new ByteArrayInputStream(oldXmlNoNs.getBytes()));
            oldDocument.getDocumentElement().normalize();
            newDocument = builder.parse(new ByteArrayInputStream(newXmlNoNs.getBytes()));
            newDocument.getDocumentElement().normalize();

            addedList = manifest.getAddedList();
            changedList = manifest.getChangedList();
            deletedList = manifest.getDeletedList();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Remove xml string namespace and preamble string.
     *
     * @param xmlString the xml string
     *
     * @return the string
     */
    private String removeXmlStringNamespaceAndPreamble(final String xmlString) {
        return xmlString.replaceAll("(<\\?[^<]*\\?>)?", "")
                        .replaceAll("xmlns.*?(\"|\').*?(\"|\')", "")
                        .replaceAll("(<)(\\w+:)(.*?>)", "$1$3")
                        .replaceAll("(</)(\\w+:)(.*?>)", "$1$3");
    }

    /**
     * Generate remarks string.
     *
     * @return the string
     */
    private String generateRemarks() {
        StringBuilder stringBuilder = new StringBuilder();

        TreeMap<String, TreeSet<PchRemarkItem>> childMap = root.getChildMap();

        for (TreeSet<PchRemarkItem> remarkItem : childMap.values()) {
            for (PchRemarkItem pchRemarkItem : remarkItem) {
                stringBuilder.append(pchRemarkItem.toString());
            }
        }
        return stringBuilder.toString();
    }

    /**
     * Analyst manifest.
     */
    private void analystManifest() {
        root = new PchRemarkItem(0);

        processList(addedList);
        processList(deletedList);
        processList(changedList);
    }

    /**
     * Process list.
     *
     * @param list the list
     */
    private void processList(List<PchJsonManifestItem> list) {
        // iterate the list
        for (PchJsonManifestItem item : list) {
            Changes changes = item.getChanges();

            // get the xpath we want to analyze
            String changeType = changes.getChangeType();
            String xpathString = changeType.equals(DELETE) ? changes.getOldXpath() : changes.getNewXpath();

            // split the xpath by "/"
            String[] paths = xpathString.substring(1).split("/");

            // the current sensitive element
            PchRemarkItem currentSensitive = root;

            for (int i = 0; i < paths.length; i++) {

                String elementSegment = paths[i];
                String localName = elementSegment.split("\\[")[0];

                // if it's last one. always add a new remark item to the current map
                if (i == paths.length - 1) {
                    currentSensitive = currentSensitive.addChild(elementSegment,
                            new PchRemarkItem(getRemark(changes, localName), currentSensitive.getLevel() + 1));

                    List<String> childrenKeys = SensitiveUtils.getChildrenKeys(localName);
                    // If it's ADD or DELETE, check if we need to display more children info in the remark.
                    if ((changeType.equals(ADD) || changeType.equals(DELETE)) && !childrenKeys.isEmpty()) {
                        String template = RemarkUtils.getTemplate(changes.getChangeType());
                        Node lastParent;

                        try {

                            Node doc = changeType.equals(DELETE) ? oldDocument : newDocument;
                            lastParent = XmlUtils.getNodeByXPath(xpathString, doc);

                            for (String childKey : childrenKeys) {
                                // Children Key NodeList
                                NodeList children = ((Element) lastParent).getElementsByTagName(childKey);
                                if (children.getLength() > 0) {
                                    for (int index = 0; index < children.getLength(); index++) {
                                        String childContext = SensitiveUtils.getContext(children.item(index), childKey);
                                        String label = RemarkUtils.getLabel(childKey);
                                        String childRemark = MessageFormat.format(template, label, childContext);
                                        currentSensitive.addChild(childKey + "[" + index + "]",
                                                new PchRemarkItem(childRemark, currentSensitive.getLevel() + 1));
                                    }
                                }
                            }
                        }
                        catch (XPathExpressionException e) {
                            e.printStackTrace();
                        }
                    }
                    continue;
                }

                // if it's not last on xPath, check if it's sensitive.
                if (SensitiveUtils.isSensitive(localName)) {
                    try {
                        String targetPath = xpathString.substring(0,
                                xpathString.indexOf(elementSegment) + elementSegment.length());
                        Node doc = changeType.equals(DELETE) ? oldDocument : newDocument;
                        Node node = XmlUtils.getNodeByXPath(targetPath, doc);

                        String context = SensitiveUtils.getContext(node, localName);
                        if (StringUtils.isNotBlank(context)) {
                            currentSensitive = currentSensitive.addChild(elementSegment,
                                    new PchRemarkItem(context, currentSensitive.getLevel() + 1));
                        }
                    }
                    catch (XPathExpressionException e) {
                        e.printStackTrace();
                    }

                }
            }
        }
    }

    /**
     * Gets remark.
     *
     * @param item      the item
     * @param localName the local name
     *
     * @return the remark
     */
    private String getRemark(Changes item, String localName) {
        String label;
        String template = RemarkUtils.getTemplate(item.getChangeType());
        String remark = null;
        try {
            switch (item.getChangeType()) {
                case ADD: {
                    Node node = XmlUtils.getNodeByXPath(item.getNewXpath(), newDocument);
                    String newValue = item.getNewValue();
                    label = RemarkUtils.getLabel(newValue);
                    remark = MessageFormat.format(template, label, SensitiveUtils.getContext(node, localName));
                    break;
                }
                case DELETE: {
                    Node node = XmlUtils.getNodeByXPath(item.getOldXpath(), oldDocument);
                    label = RemarkUtils.getLabel(item.getOldValue());
                    remark = MessageFormat.format(template, label, SensitiveUtils.getContext(node, localName));
                    break;
                }
                case CHANGE: {
                    Node newNode = XmlUtils.getNodeByXPath(item.getNewXpath(), newDocument);
                    Node oldNode = XmlUtils.getNodeByXPath(item.getOldXpath(), oldDocument);
                    label = RemarkUtils.getLabel(localName);
                    remark = MessageFormat.format(template,
                            label,
                            DictionaryUtils.getMappedContent(localName, item.getOldValue(), oldNode),
                            DictionaryUtils.getMappedContent(localName, item.getNewValue(), newNode));
                    break;
                }
            }
        }
        catch (XPathExpressionException e) {
            e.printStackTrace();
        }
        return remark;
    }

}
