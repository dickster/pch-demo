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

import java.math.BigDecimal;

/**
 * The type Coverage.
 */
public class Coverage {

    /**
     * The Coverage cd.
     */
    private String coverageCd;

    /**
     * The Limit.
     */
    private BigDecimal limit;

    /**
     * The Deductible.
     */
    private BigDecimal deductible;

    /**
     * Gets coverage cd.
     *
     * @return the coverage cd
     */
    public String getCoverageCd() {
        return coverageCd;
    }

    /**
     * Sets coverage cd.
     *
     * @param coverageCd the coverage cd
     */
    public void setCoverageCd(String coverageCd) {
        this.coverageCd = coverageCd;
    }

    /**
     * Gets limit.
     *
     * @return the limit
     */
    public BigDecimal getLimit() {
        return limit;
    }

    /**
     * Sets limit.
     *
     * @param limit the limit
     */
    public void setLimit(BigDecimal limit) {
        this.limit = limit;
    }

    /**
     * Gets deductible.
     *
     * @return the deductible
     */
    public BigDecimal getDeductible() {
        return deductible;
    }

    /**
     * Sets deductible.
     *
     * @param deductible the deductible
     */
    public void setDeductible(BigDecimal deductible) {
        this.deductible = deductible;
    }

    /**
     * Instantiates a new Coverage.
     */
    public Coverage() {

    }
}
