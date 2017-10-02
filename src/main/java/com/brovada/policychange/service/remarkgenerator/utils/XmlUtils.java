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
import org.w3c.dom.NodeList;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

/**
 * The type Xml utils.
 */
public final class XmlUtils {

    /**
     * The constant xpath.
     */
    private static XPath xpath;

    /**
     * Instantiates a new Xml utils.
     */
    private XmlUtils() {

    }

    static {
        XPathFactory xpathFactory = XPathFactory.newInstance();
        xpath = xpathFactory.newXPath();
    }

    /**
     * Gets node by x path.
     *
     * @param path the sensitive path
     * @param node           the node
     *
     * @return the node by x path
     *
     * @throws XPathExpressionException the x path expression exception
     */
    public static Node getNodeByXPath(String path, Node node) throws XPathExpressionException {
        XPathExpression expr = xpath.compile(path);
        return (Node) expr.evaluate(node, XPathConstants.NODE);
    }

    /**
     * Gets node list by x path.
     *
     * @param path the path
     * @param node the node
     *
     * @return the node list by x path
     *
     * @throws XPathExpressionException the x path expression exception
     */
    public static NodeList getNodeListByXPath(String path, Node node) throws XPathExpressionException {
        XPathExpression expr = xpath.compile(path);
        return (NodeList) expr.evaluate(node, XPathConstants.NODESET);
    }
}
