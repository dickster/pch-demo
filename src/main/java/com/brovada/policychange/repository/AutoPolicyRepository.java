/*
 * Copyright (c) brovada Technologies, Inc. All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * brovada Technologies, Inc. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with brovada.
 */
package com.brovada.policychange.repository;

import com.brovada.policychange.model.AutoPolicy;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import java.util.List;

public interface AutoPolicyRepository extends MongoRepository<AutoPolicy, String>, QueryDslPredicateExecutor<AutoPolicy> {

    AutoPolicy findAutoPolicyByPolicyNumber(String policyNumber);

    List<AutoPolicy> findAllByInsuredsNameInfoPersonNameSurname(String surname);

    List<AutoPolicy> findAllByInsuredsNameInfoPersonNameGivenName(String givenName);

    List<AutoPolicy> findAllByInsuredsNameInfoCommercialNameCommercialName(String commercialName);

}
