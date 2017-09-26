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

/**
 * The type Name info.
 */
public class NameInfo {

    /**
     * The Person name.
     */
    private PersonName personName;

    /**
     * The Commercial name.
     */
    private CommercialName commercialName;

    /**
     * Instantiates a new Name info.
     *
     * @param givenName the given name
     * @param surname   the surname
     */
    public NameInfo(String givenName, String surname) {
        this.personName = new PersonName(surname, givenName);
    }

    /**
     * Instantiates a new Name info.
     *
     * @param commercialName the commercial name
     */
    public NameInfo(String commercialName) {
        this.commercialName = new CommercialName(commercialName);
    }

    /**
     * Instantiates a new Name info.
     */
    public NameInfo() {
    }

    /**
     * Gets person name.
     *
     * @return the person name
     */
    public PersonName getPersonName() {
        return personName;
    }

    /**
     * Sets person name.
     *
     * @param personName the person name
     */
    public void setPersonName(PersonName personName) {
        this.personName = personName;
    }

    /**
     * Gets commercial name.
     *
     * @return the commercial name
     */
    public CommercialName getCommercialName() {
        return commercialName;
    }

    /**
     * Sets commercial name.
     *
     * @param commercialName the commercial name
     */
    public void setCommercialName(CommercialName commercialName) {
        this.commercialName = commercialName;
    }
}
