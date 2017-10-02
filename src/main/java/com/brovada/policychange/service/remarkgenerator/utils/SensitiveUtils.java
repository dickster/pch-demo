/*
 * Copyright (c) brovada Technologies, Inc. All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * brovada Technologies, Inc. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with brovada.
 */
package com.brovada.policychange.service.remarkgenerator.utils;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.xpath.XPathExpressionException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

/**
 * The type Sensitive utils.
 */
public final class SensitiveUtils {

    /**
     * The constant LOG.
     */
    private static final Logger LOG = LoggerFactory.getLogger(SensitiveUtils.class);

    /**
     * The constant REFERENCE.
     */
    private static final String REFERENCE = ".reference";

    /**
     * The constant PATH.
     */
    private static final String PATH = ".path";

    /**
     * The constant sensitiveProperties.
     */
    private static Properties sensitiveProperties;

    /**
     * The constant CONTEXT_KEYS.
     */
    private static final String CONTEXT_KEYS = ".keys";

    /**
     * The constant CONTEXT_CONTENT.
     */
    private static final String CONTEXT_CONTENT = ".content";

    /**
     * The constant SENSITIVE_LIST.
     */
    private static final String SENSITIVE_LIST = "sensitive.list";

    /**
     * The constant INDEX.
     */
    private static final String INDEX = "[INDEX]";

    /**
     * The constant CHILDREN_KEYS.
     */
    private static final String CHILDREN_KEYS = ".children.keys";

    /**
     * Instantiates a new Sensitive utils.
     */
    private SensitiveUtils() {

    }

    static {
        sensitiveProperties = new Properties();
        String configurationFolder = "config/remarkgenerator/sensitive.properties";
        try {
            FileInputStream sensitiveFio = new FileInputStream(new File(configurationFolder + "sensitive.properties"));
            sensitiveProperties.load(sensitiveFio);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets context.
     *
     * @param node      the node
     * @param localName the local name
     *
     * @return the context
     */
    public static String getContext(Node node, String localName) throws XPathExpressionException {

        String[] childNames = null;
        if (sensitiveProperties.getProperty(localName + CONTEXT_KEYS) != null) {
            childNames = sensitiveProperties.getProperty(localName + CONTEXT_KEYS).split("\\|");
        }

        ArrayList<String> keyValues = new ArrayList<>();

        if (childNames != null && childNames.length != 0) {

            for (String childName : childNames) {
                // child name is empty
                if (!StringUtils.isBlank(childName)) {
                    if (childName.equals(INDEX)) {
                        if (node != null) {
                            int index = 0;

                            while ((node = node.getPreviousSibling()) != null) {
                                if (node.getNodeName() != null && node.getNodeName().equals(localName)) {
                                    index++;
                                }
                            }

                            keyValues.add(String.valueOf(index + 1));
                        }

                    }
                    else if (childName.startsWith("p:")) {

                        String attributeName = childName.split(":")[1];
                        String attributeValue = null;
                        String label = null;

                        if (node instanceof Element) {
                            Element element = (Element) node;
                            attributeValue = element.getAttribute(attributeName);

                            String refNodeName = sensitiveProperties.getProperty(localName
                                                                                 + "."
                                                                                 + attributeName
                                                                                 + REFERENCE);
                            if (refNodeName != null) {
                                String refPath = sensitiveProperties.getProperty(localName
                                                                                 + "."
                                                                                 + attributeName
                                                                                 + REFERENCE
                                                                                 + PATH);
                                NodeList list = XmlUtils.getNodeListByXPath(refPath, node.getOwnerDocument());
                                for (int i = 0; i < list.getLength(); i++) {
                                    Node current = list.item(i);
                                    String attrValue = ((Element) current).getAttribute("id");
                                    if (attrValue.equals(attributeValue)) {
                                        label = SensitiveUtils.getContext(current, refNodeName);
                                        break;
                                    }
                                }
                            }
                            else {
                                label = sensitiveProperties.getProperty(localName
                                                                        + ".p."
                                                                        + attributeName
                                                                        + "."
                                                                        + attributeValue);
                            }
                        }

                        if (StringUtils.isNotEmpty(label)) {
                            keyValues.add(DictionaryUtils.getMappedContent(localName, label, node));
                        }
                        else {
                            keyValues.add(DictionaryUtils.getMappedContent(localName, attributeValue, node));
                        }
                    }
                    else {
                        // Get the node value
                        if (node instanceof Element) {
                            Element element = (Element) node;
                            Node child = element.getElementsByTagName(childName).item(0);

                            if (child != null) {
                                String nodeValue = child.getTextContent();
                                keyValues.add(DictionaryUtils.getMappedContent(localName, nodeValue, node));
                            }
                            else {
                                keyValues.add(DictionaryUtils.getMappedContent(localName, null, node));
                            }
                        }

                    }
                }
            }
        }
        else {
            // Get the node value
            if (node instanceof Element) {
                Element element = (Element) node;
                if (element.hasChildNodes() && element.getFirstChild().getNodeType() == Node.TEXT_NODE) {
                    String textContent = element.getFirstChild().getTextContent();
                    return DictionaryUtils.getMappedContent(localName, StringUtils.trimToEmpty(textContent), node);
                }
            }
        }

        String contextString = sensitiveProperties.getProperty(localName + CONTEXT_CONTENT);
        if (contextString == null) {
            return "";
        }
        return MessageFormat.format(contextString, keyValues.toArray());
    }

    /**
     * Is sensitive boolean.
     *
     * @param localName the local name
     *
     * @return the boolean
     */
    public static boolean isSensitive(String localName) {
        String[] property = sensitiveProperties.getProperty(SENSITIVE_LIST).split("\\|");
        List<String> listSensitive = Arrays.asList(property);
        return listSensitive.contains(localName);
    }

    /**
     * Gets children keys.
     *
     * @param localName the local name
     *
     * @return the children keys
     */
    public static List<String> getChildrenKeys(String localName) {
        try {
            String[] property = sensitiveProperties.getProperty(localName + CHILDREN_KEYS).split("\\|");
            return Arrays.asList(property);
        }
        catch (Exception e) {
            LOG.warn("No children keys found by given local name:" + localName);
        }
        return Collections.emptyList();
    }
}
