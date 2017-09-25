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
 * The type Phone info.
 */
public class PhoneInfo {

    /**
     * The Phone type cd.
     */
    private String phoneTypeCd;

    /**
     * The Communication use cd.
     */
    private String communicationUseCd;

    /**
     * The Phone number.
     */
    private String phoneNumber;

    /**
     * Instantiates a new Phone info.
     */
    public PhoneInfo() {
    }

    /**
     * Gets phone type cd.
     *
     * @return the phone type cd
     */
    public String getPhoneTypeCd() {
        return phoneTypeCd;
    }

    /**
     * Sets phone type cd.
     *
     * @param phoneTypeCd the phone type cd
     */
    public void setPhoneTypeCd(String phoneTypeCd) {
        this.phoneTypeCd = phoneTypeCd;
    }

    /**
     * Gets communication use cd.
     *
     * @return the communication use cd
     */
    public String getCommunicationUseCd() {
        return communicationUseCd;
    }

    /**
     * Sets communication use cd.
     *
     * @param communicationUseCd the communication use cd
     */
    public void setCommunicationUseCd(String communicationUseCd) {
        this.communicationUseCd = communicationUseCd;
    }

    /**
     * Gets phone number.
     *
     * @return the phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets phone number.
     *
     * @param phoneNumber the phone number
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
