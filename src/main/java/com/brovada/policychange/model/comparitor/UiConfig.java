/*
 * Copyright (c) brovada Technologies, Inc. All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * brovada Technologies, Inc. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with brovada.
 */
package com.brovada.policychange.model.comparitor;

import java.util.HashMap;
import java.util.Map;

/**
 * The type Ui config.
 */
public class UiConfig {

    /**
     * The Map.
     */
    Map<String, String> map = new HashMap<>();

    /**
     * Instantiates a new Ui config.
     */
    public UiConfig() {
    }

    /**
     * Gets map.
     *
     * @return the map
     */
    public Map<String, String> getMap() {
        return map;
    }

    /**
     * Sets map.
     *
     * @param map the map
     */
    public void setMap(Map<String, String> map) {
        this.map = map;
    }
}
