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
 * The type Changes.
 */
public class Changes {

    /**
     * The Change type.
     */
    private String changeType;

    /**
     * The Selector.
     */
    private String uiSelector;

    /**
     * The New value.
     */
    private String newValue;

    /**
     * The Old value.
     */
    private String oldValue;

    /**
     * The New xpath.
     */
    private String newXpath;

    /**
     * The Old xpath.
     */
    private String oldXpath;

    /**
     * Instantiates a new Changes.
     *
     * @param changeType the change type
     * @param uiSelector the ui selector
     * @param newValue   the new value
     * @param oldValue   the old value
     * @param newXpath   the new xpath
     * @param oldXpath   the old xpath
     */
    public Changes(String changeType,
                   String uiSelector,
                   String newValue,
                   String oldValue,
                   String newXpath,
                   String oldXpath) {
        this.changeType = changeType;
        this.uiSelector = uiSelector;
        this.newValue = newValue;
        this.oldValue = oldValue;
        this.newXpath = newXpath;
        this.oldXpath = oldXpath;
    }

    /**
     * Gets change type.
     *
     * @return the change type
     */
    public String getChangeType() {
        return changeType;
    }

    /**
     * Sets change type.
     *
     * @param changeType the change type
     */
    public void setChangeType(String changeType) {
        this.changeType = changeType;
    }

    /**
     * Gets new value.
     *
     * @return the new value
     */
    public String getNewValue() {
        return newValue;
    }

    /**
     * Sets new value.
     *
     * @param newValue the new value
     */
    public void setNewValue(String newValue) {
        this.newValue = newValue;
    }

    /**
     * Gets old value.
     *
     * @return the old value
     */
    public String getOldValue() {
        return oldValue;
    }

    /**
     * Sets old value.
     *
     * @param oldValue the old value
     */
    public void setOldValue(String oldValue) {
        this.oldValue = oldValue;
    }

    /**
     * Gets ui selector.
     *
     * @return the ui selector
     */
    public String getUiSelector() {
        return uiSelector;
    }

    /**
     * Sets ui selector.
     *
     * @param uiSelector the ui selector
     */
    public void setUiSelector(String uiSelector) {
        this.uiSelector = uiSelector;
    }

    /**
     * Gets new xpath.
     *
     * @return the new xpath
     */
    public String getNewXpath() {
        return newXpath;
    }

    /**
     * Sets new xpath.
     *
     * @param newXpath the new xpath
     */
    public void setNewXpath(String newXpath) {
        this.newXpath = newXpath;
    }

    /**
     * Gets old xpath.
     *
     * @return the old xpath
     */
    public String getOldXpath() {
        return oldXpath;
    }

    /**
     * Sets old xpath.
     *
     * @param oldXpath the old xpath
     */
    public void setOldXpath(String oldXpath) {
        this.oldXpath = oldXpath;
    }
}
