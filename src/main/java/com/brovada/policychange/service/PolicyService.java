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
import com.brovada.policychange.model.QAutoPolicy;
import com.brovada.policychange.repository.AutoPolicyRepository;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type Policy service.
 */
@Service
public class PolicyService {

    /**
     * The Repository.
     */
    @Autowired
    AutoPolicyRepository repository;

    /**
     * Find policy by last name list.
     *
     * @param lastName the last name
     *
     * @return the list
     */
    public List<AutoPolicy> findPolicyByLastName(String lastName) {
        return this.repository.findAllByInsuredsNameInfoPersonNameSurname(lastName);
    }

    /**
     * Find policy by given name list.
     *
     * @param givenName the given name
     *
     * @return the list
     */
    public List<AutoPolicy> findPolicyByGivenName(String givenName) {
        return this.repository.findAllByInsuredsNameInfoPersonNameSurname(givenName);
    }

    /**
     * Save auto policy auto policy.
     *
     * @param policy the policy
     *
     * @return the auto policy
     */
    public AutoPolicy saveAutoPolicy(AutoPolicy policy) {
        return this.repository.save(policy);
    }

    /**
     * Delete auto policy by policy number.
     *
     * @param policyNumber the policy number
     */
    public void deleteAutoPolicyByPolicyNumber(String policyNumber) {
        this.repository.delete(policyNumber);
    }

    public Iterable<AutoPolicy> findPoliciesBySimpleName(String name) {
        QAutoPolicy q = new QAutoPolicy("autoPolicy");
        Predicate commercialName = q.insureds.any().nameInfo.commercialName.commercialName.equalsIgnoreCase(name);
        Predicate givenName = q.insureds.any().nameInfo.personName.givenName.equalsIgnoreCase(name);
        Predicate lastName = q.insureds.any().nameInfo.personName.surname.equalsIgnoreCase(name);
        BooleanBuilder builder = new BooleanBuilder();
        Predicate predicate = builder.or(commercialName).or(givenName).or(lastName);
        return this.repository.findAll(predicate);
    }

    public Iterable<AutoPolicy> findPoliciesContainName(String name) {
        QAutoPolicy q = new QAutoPolicy("autoPolicy");
        Predicate commercialName = q.insureds.any().nameInfo.commercialName.commercialName.containsIgnoreCase(name);
        Predicate givenName = q.insureds.any().nameInfo.personName.givenName.containsIgnoreCase(name);
        Predicate lastName = q.insureds.any().nameInfo.personName.surname.containsIgnoreCase(name);
        BooleanBuilder builder = new BooleanBuilder();
        Predicate predicate = builder.or(commercialName).or(givenName).or(lastName);
        return this.repository.findAll(predicate);
    }

}
