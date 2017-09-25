/*
 * Copyright (c) brovada Technologies, Inc. All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * brovada Technologies, Inc. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with brovada.
 */
package com.brovada.policychange.model;

import java.util.List;

/**
 * The type Driver.
 */
public class Driver {

    /**
     * The Name info.
     */
    private NameInfo nameInfo;

    /**
     * The Gender.
     */
    private String gender;

    /**
     * The Birthday.
     */
    private String birthday;

    /**
     * The Marital status.
     */
    private String maritalStatus;

    /**
     * The Licenses.
     */
    private List<License> licenses;

    /**
     * Gets name info.
     *
     * @return the name info
     */
    public NameInfo getNameInfo() {
        return nameInfo;
    }

    /**
     * Sets name info.
     *
     * @param nameInfo the name info
     */
    public void setNameInfo(NameInfo nameInfo) {
        this.nameInfo = nameInfo;
    }

    /**
     * Gets gender.
     *
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * Sets gender.
     *
     * @param gender the gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Gets birthday.
     *
     * @return the birthday
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * Sets birthday.
     *
     * @param birthday the birthday
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    /**
     * Gets marital status.
     *
     * @return the marital status
     */
    public String getMaritalStatus() {
        return maritalStatus;
    }

    /**
     * Sets marital status.
     *
     * @param maritalStatus the marital status
     */
    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    /**
     * Gets licenses.
     *
     * @return the licenses
     */
    public List<License> getLicenses() {
        return licenses;
    }

    /**
     * Sets licenses.
     *
     * @param licenses the licenses
     */
    public void setLicenses(List<License> licenses) {
        this.licenses = licenses;
    }

    /**
     * Instantiates a new Driver.
     */
    public Driver() {

    }
}
