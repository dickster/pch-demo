package com.brovada.policychange.service.validation;

public @interface ValidationSet {
    Class<? extends ResultSet> set();
}
