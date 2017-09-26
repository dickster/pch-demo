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
 * The type Insured.
 */
public class Insured {

    /**
     * The Name info.
     */
    private NameInfo nameInfo;

    /**
     * The Addr.
     */
    private Addr addr;

    /**
     * The Phone infos.
     */
    private List<PhoneInfo> phoneInfos;

    /**
     * Instantiates a new Insured.
     *
     * @param givenName the given name
     * @param surname   the surname
     */
    public Insured(String givenName, String surname) {
        this.nameInfo = new NameInfo(givenName, surname);
    }

    /**
     * Instantiates a new Insured.
     *
     * @param commercialName the commercial name
     */
    public Insured(String commercialName) {
        this.nameInfo = new NameInfo(commercialName);
    }

    /**
     * Instantiates a new Insured.
     */
    public Insured() {
    }

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
     * Gets addr.
     *
     * @return the addr
     */
    public Addr getAddr() {
        return addr;
    }

    /**
     * Sets addr.
     *
     * @param addr the addr
     */
    public void setAddr(Addr addr) {
        this.addr = addr;
    }

    /**
     * Gets phone infos.
     *
     * @return the phone infos
     */
    public List<PhoneInfo> getPhoneInfos() {
        return phoneInfos;
    }

    /**
     * Sets phone infos.
     *
     * @param phoneInfos the phone infos
     */
    public void setPhoneInfos(List<PhoneInfo> phoneInfos) {
        this.phoneInfos = phoneInfos;
    }
}
