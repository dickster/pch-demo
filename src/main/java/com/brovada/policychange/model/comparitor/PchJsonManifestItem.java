/*
 * Copyright (c) brovada Technologies, Inc. All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * brovada Technologies, Inc. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with brovada.
 */
package com.brovada.policychange.model.comparitor;

/**
 * The type Pch json manifest item.
 */
public class PchJsonManifestItem {

    /**
     * The Changes.
     */
    private Changes changes;

    /**
     * The Configs.
     */
    private UiConfig configs;

    /**
     * Instantiates a new Pch json manifest item.
     *
     * @param changeType the change type
     * @param uiSelector the ui selector
     * @param newValue   the new value
     * @param oldValue   the old value
     * @param newXPath   the new x path
     * @param oldXPath   the old x path
     */
    public PchJsonManifestItem(String changeType,
                               String uiSelector,
                               String newValue,
                               String oldValue,
                               String newXPath,
                               String oldXPath) {
        this.changes = new Changes(changeType, uiSelector, newValue, oldValue, newXPath, oldXPath);
    }

    /**
     * Gets changes.
     *
     * @return the changes
     */
    public Changes getChanges() {
        return changes;
    }

    /**
     * Sets changes.
     *
     * @param changes the changes
     */
    public void setChanges(Changes changes) {
        this.changes = changes;
    }

    /**
     * Gets configs.
     *
     * @return the configs
     */
    public UiConfig getConfigs() {
        return configs;
    }

    /**
     * Sets configs.
     *
     * @param configs the configs
     */
    public void setConfigs(UiConfig configs) {
        this.configs = configs;
    }
}
