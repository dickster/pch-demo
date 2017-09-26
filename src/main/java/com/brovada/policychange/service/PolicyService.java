/*
 * Copyright (c) brovada Technologies, Inc. All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * brovada Technologies, Inc. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with brovada.
 */
package com.brovada.policychange.service;

import com.brovada.policychange.model.AutoPolicy;
import com.brovada.policychange.repository.AutoPolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PolicyService {

    @Autowired
    AutoPolicyRepository repository;


    public List<AutoPolicy> findPolicyByLastName(String lastName) {
        return this.repository.findAllByInsuredsNameInfoPersonNameSurname(lastName);
    }
}
