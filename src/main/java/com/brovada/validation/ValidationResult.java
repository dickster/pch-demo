package com.brovada.validation;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.annotation.Nonnull;
import java.util.HashMap;

@Document
public class ValidationResult extends HashMap<String, Object> {

    private static final String VALID_KEY = "isValid";

    private ValidationResult() {
    }

    public ValidationResult(@Nonnull String key, Object value) {
        put(key, value);
    }

    public static ValidationResult valid(boolean valid) {
        ValidationResult result = new ValidationResult();
        result.put(VALID_KEY, valid);
        return result;
    }

    public static ValidationResult valid() {
        return valid(true);
    }

    public static ValidationResult invalid() {
        return valid(false);
    }

    public ValidationResult withResult(@Nonnull String key, String value) {
        return withResult(key, (Object)value);
    }

    public ValidationResult withResult(@Nonnull String key) {
        return withResult(key, key);
    }

    public ValidationResult withResult(@Nonnull String key, Object value) {
        put(key, value);
        return this;
    }

    public ValidationResult withResult(@Nonnull Number code) {
        return withResult("code", code);
    }

    public ValidationResult withResult(@Nonnull Number code, String value) {
        return withResult(code+"", value);
    }

}
