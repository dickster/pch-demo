/*
 * Copyright (c) brovada Technologies, Inc. All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * brovada Technologies, Inc. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with brovada.
 */

package com.brovada.policychange.service.validation;

import com.brovada.policychange.model.AutoPolicy;
import org.springframework.stereotype.Service;

@Service
public class AutoValidationService {

    public ValidationResult validateCmf(AutoPolicy autoPolicy) {
        return ValidationResult.SUCCESS;
    }
}
