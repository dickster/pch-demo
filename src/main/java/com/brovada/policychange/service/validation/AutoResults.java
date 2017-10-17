package com.brovada.policychange.service.validation;


import java.util.EnumSet;
import java.util.Set;

public class AutoResults implements ResultSet<ValidationResult> {

    private static final EnumSet<ValidationResult> results = EnumSet.allOf(ValidationResult.class);

    @Override
    public Set<ValidationResult> getResultSet() {
        return results;
    }

    @Override
    public ValidationResult getDefaultResult() {
        return ValidationResult.SUCCESS;
    }

    @Override
    public ValidationResult getErrorResult() {
        return ValidationResult._500;
    }
}
