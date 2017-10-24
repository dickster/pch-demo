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
import com.brovada.policychange.service.validation.ValidationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

/**
 * The type Policy controller.
 */
@RestController
@RequestMapping("/validation")
public class ValidationController {

    @Inject
    private ValidationService validationService;


    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity<?> doValidation(@PathVariable("type") String validationType, @RequestBody AutoPolicy autoPolicy) {
        Enum result = validationService.validate(validationType, autoPolicy);
        return ResponseEntity.ok(result);
    }


}
