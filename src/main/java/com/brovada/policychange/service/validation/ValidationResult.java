package com.brovada.policychange.service.validation;

public enum ValidationResult {

    SUCCESS,
    _200,
    _201,
    _202,
    _203,
    _500;

    private int code = 0;

     ValidationResult() {
         if (this.name().startsWith("_")) {
             String rest = this.name().substring(1);
             try {
                 this.code = Integer.parseInt(rest);
             } catch (NumberFormatException e) {
                 this.code = ordinal();
             }
         }
    }

    ValidationResult(int code) {
        this.code = code;
    }


    public int getCode() {
        return code;
    }
}
