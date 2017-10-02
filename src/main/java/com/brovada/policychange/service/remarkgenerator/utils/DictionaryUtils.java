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

import org.w3c.dom.Node;

import javax.xml.xpath.XPathExpressionException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * The type Dictionary utils.
 */
public final class DictionaryUtils {

    /**
     * The constant DEPENDS.
     */
    private static final String DEPENDS = ".depends";

    /**
     * The constant MAP_TO.
     */
    private static final String MAP_TO = ".mapto";

    /**
     * The constant dictionaryProperties.
     */
    private static Properties dictionaryProperties;

    /**
     * Instantiates a new Dictionary utils.
     */
    private DictionaryUtils() {

    }

    static {
        dictionaryProperties = new Properties();
        String configurationFolder = "config/remarkgenerator/dictionary.properties";
        try {
            FileInputStream dictionaryFio = new FileInputStream(new File(configurationFolder
                                                                         + "dictionary.properties"));
            dictionaryProperties.load(dictionaryFio);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Gets mapped content.
     *
     * @param localName the local name
     * @param code      the code
     * @param node      the node
     *
     * @return the mapped content
     */
    public static String getMappedContent(final String localName, final String code, final Node node) {
        if (code == null || code.isEmpty()) {
            return "";
        }

        String mapped = null;
        String dependXpath = dictionaryProperties.getProperty(localName + DEPENDS);
        if (dependXpath != null) {
            try {
                Node dependent = XmlUtils.getNodeByXPath(dependXpath, node);
                if (dependent != null) {
                    String dependValue = dependent.getTextContent();
                    mapped = dictionaryProperties.getProperty(localName + "." + code + "." + dependValue + MAP_TO);
                }
            }
            catch (XPathExpressionException e) {
                e.printStackTrace();
            }
        }
        else {
            mapped = dictionaryProperties.getProperty(localName + "." + code + MAP_TO);
        }
        if (mapped == null) {
            return code;
        }
        else {
            return mapped;
        }
    }

}
