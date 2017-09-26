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

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * The type License.
 */
@Document
public class License {

    /**
     * The Licensed date.
     */
    private String licensedDate;

    /**
     * The License class.
     */
    private String licenseClass;

    /**
     * The License number.
     */
    private String licenseNumber;

    /**
     * The State prov.
     */
    private String stateProv;

    /**
     * Instantiates a new License.
     */
    public License() {
    }

    /**
     * Gets licensed date.
     *
     * @return the licensed date
     */
    public String getLicensedDate() {
        return licensedDate;
    }

    /**
     * Sets licensed date.
     *
     * @param licensedDate the licensed date
     */
    public void setLicensedDate(String licensedDate) {
        this.licensedDate = licensedDate;
    }

    /**
     * Gets license class.
     *
     * @return the license class
     */
    public String getLicenseClass() {
        return licenseClass;
    }

    /**
     * Sets license class.
     *
     * @param licenseClass the license class
     */
    public void setLicenseClass(String licenseClass) {
        this.licenseClass = licenseClass;
    }

    /**
     * Gets license number.
     *
     * @return the license number
     */
    public String getLicenseNumber() {
        return licenseNumber;
    }

    /**
     * Sets license number.
     *
     * @param licenseNumber the license number
     */
    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    /**
     * Gets state prov.
     *
     * @return the state prov
     */
    public String getStateProv() {
        return stateProv;
    }

    /**
     * Sets state prov.
     *
     * @param stateProv the state prov
     */
    public void setStateProv(String stateProv) {
        this.stateProv = stateProv;
    }
}
