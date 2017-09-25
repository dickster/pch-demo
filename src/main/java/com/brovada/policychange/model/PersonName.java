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
 * The type Person name.
 */
public class PersonName {

    /**
     * The Surname.
     */
    private String surname;

    /**
     * The Giving name.
     */
    private String givingName;

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
    public String getGivingName() {
        return givingName;
    }

    /**
     * Sets giving name.
     *
     * @param givingName the giving name
     */
    public void setGivingName(String givingName) {
        this.givingName = givingName;
    }
}
