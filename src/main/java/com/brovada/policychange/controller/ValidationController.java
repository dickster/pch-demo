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
import com.brovada.policychange.service.validation.AutoValidationService;
import com.brovada.policychange.service.validation.ValidationResult;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.lang.reflect.Method;
import java.util.List;

@RestController
@RequestMapping("/validate")
public class ValidationController {

    @Inject
    private AutoValidationService validationService;

    @RequestMapping(path="/cmf", method = RequestMethod.POST)
    ResponseEntity<ValidationResult> validate(@RequestBody AutoPolicy autoPolicy) {
        ValidationResult result = validationService.validateCmf(autoPolicy);
        return ResponseEntity.ok(result);
    }

    // TODO : put this in abstract controller.
    @RequestMapping(path="/query", method=RequestMethod.GET)
    ResponseEntity<List<String>> query() {
        List<String> result = Lists.newArrayList();
        for (Method method:this.getClass().getDeclaredMethods()) {
            RequestMapping mapping = method.getDeclaredAnnotation(RequestMapping.class);
            if (mapping!=null) {
                result.add(Joiner.on('/').join(mapping.path()) + " : " + Joiner.on(',').join(mapping.method()));
            }
        }
        return ResponseEntity.ok(result);
    }

}
