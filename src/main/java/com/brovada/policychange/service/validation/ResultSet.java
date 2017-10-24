package com.brovada.policychange.service.validation;

import java.util.Set;

public interface ResultSet<T extends Enum<?>> {

    Set<T> getResultSet();

    T getDefaultResult();

    T getErrorResult();

}
