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

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * The type Remark utils.
 */
public final class RemarkUtils {
    /**
     * The Remark properties.
     */
    private static Properties remarkProperties;

    /**
     * The constant LABEL.
     */
    private static final String LABEL = ".label";

    /**
     * Instantiates a new Remark utils.
     */
    private RemarkUtils() {

    }

    static {
        remarkProperties = new Properties();
        String configurationFolder = "config/remarkgenerator/remarks.properties";
        try {
            FileInputStream remarkFio = new FileInputStream(new File(configurationFolder + "remarks.properties"));
            remarkProperties.load(remarkFio);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Gets template.
     *
     * @param changeType the change type
     *
     * @return the template
     */
    public static String getTemplate(String changeType) {
        return remarkProperties.getProperty(changeType);
    }

    /**
     * Gets label.
     *
     * @param key the key
     *
     * @return the label
     */
    public static String getLabel(String key) {
        return remarkProperties.getProperty(key + LABEL, key);
    }
}
