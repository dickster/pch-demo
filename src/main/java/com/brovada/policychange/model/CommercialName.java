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
 * The type Commercial name.
 */
@Document
public class CommercialName {

    /**
     * The Commercial name.
     */
    private String commercialName;

    /**
     * Instantiates a new Commercial name.
     *
     * @param commercialName the commercial name
     */
    public CommercialName(String commercialName) {
        this.commercialName = commercialName;
    }

    /**
     * Instantiates a new Commercial name.
     */
    public CommercialName() {
    }

    /**
     * Gets commercial name.
     *
     * @return the commercial name
     */
    public String getCommercialName() {
        return commercialName;
    }

    /**
     * Sets commercial name.
     *
     * @param commercialName the commercial name
     */
    public void setCommercialName(String commercialName) {
        this.commercialName = commercialName;
    }
}
