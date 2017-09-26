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
 * The type Addr.
 */
@Document
public class Addr {

    /**
     * The Addr 1.
     */
    private String addr1;

    /**
     * The Addr 2.
     */
    private String addr2;

    /**
     * The City.
     */
    private String city;

    /**
     * The Postal code.
     */
    private String postalCode;

    /**
     * The State prov.
     */
    private String stateProv;

    /**
     * The Country.
     */
    private String country;

    /**
     * Instantiates a new Addr.
     */
    public Addr() {
    }

    /**
     * Gets addr 1.
     *
     * @return the addr 1
     */
    public String getAddr1() {
        return addr1;
    }

    /**
     * Sets addr 1.
     *
     * @param addr1 the addr 1
     */
    public void setAddr1(String addr1) {
        this.addr1 = addr1;
    }

    /**
     * Gets addr 2.
     *
     * @return the addr 2
     */
    public String getAddr2() {
        return addr2;
    }

    /**
     * Sets addr 2.
     *
     * @param addr2 the addr 2
     */
    public void setAddr2(String addr2) {
        this.addr2 = addr2;
    }

    /**
     * Gets city.
     *
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets city.
     *
     * @param city the city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Gets postal code.
     *
     * @return the postal code
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * Sets postal code.
     *
     * @param postalCode the postal code
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
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

    /**
     * Gets country.
     *
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets country.
     *
     * @param country the country
     */
    public void setCountry(String country) {
        this.country = country;
    }
}
