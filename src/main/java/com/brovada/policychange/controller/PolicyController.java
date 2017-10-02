/*
 * Copyright (c) brovada Technologies, Inc. All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * brovada Technologies, Inc. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with brovada.
 */
package com.brovada.policychange.controller;

import com.brovada.policychange.model.AutoPolicy;
import com.brovada.policychange.model.comparitor.PchJsonManifest;
import com.brovada.policychange.repository.AutoPolicyRepository;
import com.brovada.policychange.service.comparitor.PchComparitorService;
import com.brovada.policychange.service.remarkgenerator.RemarkGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.net.URI;
import java.util.Collection;

/**
 * The type Policy controller.
 */
@RestController
@RequestMapping("/policies")
public class PolicyController {

    /**
     * The Repository.
     */
    private final AutoPolicyRepository repository;

    /**
     * The Comparitor service.
     */
    private final PchComparitorService comparitorService;

    /**
     * The Remark generator service.
     */
    private final RemarkGeneratorService remarkGeneratorService;

    /**
     * Instantiates a new Policy controller.
     *
     * @param repository             the repository
     * @param comparitorService      the comparitor service
     * @param remarkGeneratorService the remark generator service
     */
    @Autowired
    PolicyController(AutoPolicyRepository repository,
                     PchComparitorService comparitorService,
                     RemarkGeneratorService remarkGeneratorService) {
        this.repository = repository;
        this.comparitorService = comparitorService;
        this.remarkGeneratorService = remarkGeneratorService;
    }

    /**
     * Gets all.
     *
     * @return the all
     */
    @RequestMapping(method = RequestMethod.GET)
    Collection<AutoPolicy> getAll() {
        return this.repository.findAll();
    }

    /**
     * Save response entity.
     *
     * @param autoPolicy the auto policy
     *
     * @return the response entity
     */
    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity<?> save(@RequestBody AutoPolicy autoPolicy) {
        AutoPolicy saved = this.repository.save(autoPolicy);

        if (saved != null) {
            URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                                                      .path("/{policyNumber}")
                                                      .buildAndExpand(saved.getPolicyNumber())
                                                      .toUri();
            return ResponseEntity.ok(location);
        }
        else {
            return ResponseEntity.noContent().build();
        }
    }

    /**
     * Gets by policy number.
     *
     * @param policyNumber the policy number
     *
     * @return the by policy number
     */
    @RequestMapping(method = RequestMethod.GET, path = "/{policyNumber}")
    AutoPolicy getByPolicyNumber(@PathVariable("policyNumber") String policyNumber) {
        return this.repository.findOne(policyNumber);
    }

    /**
     * Update policy response entity.
     *
     * @param policyNumber the policy number
     * @param policy       the policy
     *
     * @return the response entity
     */
    @RequestMapping(method = RequestMethod.PUT, path = "/{policyNumber}")
    ResponseEntity<?> updatePolicy(@PathVariable("policyNumber") String policyNumber, @RequestBody AutoPolicy policy) {

        if (!this.repository.exists(policyNumber)) {
            return ResponseEntity.notFound().build();
        }
        else {
            AutoPolicy old = this.repository.findOne(policyNumber);
            old.setDrivers(policy.getDrivers());
            old.setInsureds(policy.getInsureds());
            old.setLocations(policy.getLocations());
            old.setPolicyEffectiveDate(policy.getPolicyEffectiveDate());
            old.setVehicles(policy.getVehicles());
            return ResponseEntity.ok(this.repository.save(old));
        }
    }

    /**
     * Delete policy response entity.
     *
     * @param policyNumber the policy number
     *
     * @return the response entity
     */
    @RequestMapping(method = RequestMethod.DELETE, path = "/{policyNumber}")
    ResponseEntity<?> deletePolicy(@PathVariable("policyNumber") String policyNumber) {
        if (this.repository.exists(policyNumber)) {
            this.repository.delete(policyNumber);
            return ResponseEntity.noContent().build();
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Compare newPolicy response entity.
     *
     * @param policyNumber the newPolicy number
     * @param newPolicy    the newPolicy
     *
     * @return the response entity
     */
    @RequestMapping(method = RequestMethod.POST, path = "/{policyNumber}/compare")
    ResponseEntity<?> comparePolicy(@PathVariable("policyNumber") String policyNumber,
                                    @RequestBody AutoPolicy newPolicy) {
        AutoPolicy oldPolicy = repository.findOne(policyNumber);

        if (oldPolicy != null) {
            String newXml;
            String oldXml;
            StringWriter sw = new StringWriter();
            try {
                JAXBContext context = JAXBContext.newInstance("com.brovada.policychange.model");
                Marshaller marshaller = context.createMarshaller();
                marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
                marshaller.marshal(oldPolicy, sw);

                oldXml = sw.toString();

                sw = new StringWriter();

                marshaller.marshal(newPolicy, sw);
                newXml = sw.toString();
            }
            catch (JAXBException e) {
                e.printStackTrace();
                return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
            }
            PchJsonManifest manifest = comparitorService.compare(oldXml, newXml);
            return ResponseEntity.ok(manifest);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

}
