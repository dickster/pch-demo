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
 * The type Person name.
 */
@Document
public class PersonName {

    /**
     * The Surname.
     */
    private String surname;

    /**
     * The Giving name.
     */
    private String givenName;

    /**
     * Instantiates a new Person name.
     *
     * @param surname   the surname
     * @param givenName the given name
     */
    public PersonName(String surname, String givenName) {
        this.surname = surname;
        this.givenName = givenName;
    }

    /**
     * Instantiates a new Person name.
     */
    public PersonName() {
    }

    /**
     * Gets surname.
     *
     * @return the surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Sets surname.
     *
     * @param surname the surname
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Gets giving name.
     *
     * @return the giving name
     */
    public String getGivenName() {
        return givenName;
    }

    /**
     * Sets giving name.
     *
     * @param givenName the giving name
     */
    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }
}
