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

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CHARL228 on 21/02/2017.
 */
@JsonPropertyOrder({"addedList", "deletedList", "changedList"})
public class PchJsonManifest {

    /**
     * The Added list.
     */
    private final List<PchJsonManifestItem> addedList = new ArrayList<>();

    /**
     * The Deleted list.
     */
    private final List<PchJsonManifestItem> deletedList = new ArrayList<>();

    /**
     * The Changed list.
     */
    private final List<PchJsonManifestItem> changedList = new ArrayList<>();

    /**
     * Get the list of added item.
     *
     * @return list of added item.
     */
    public List<PchJsonManifestItem> getAddedList() {
        return addedList;
    }

    /**
     * Get the list of deleted item.
     *
     * @return deleted item.
     */
    public List<PchJsonManifestItem> getDeletedList() {
        return deletedList;
    }

    /**
     * Get the list of changed item.
     *
     * @return changed item.
     */
    public List<PchJsonManifestItem> getChangedList() {
        return changedList;
    }
}
