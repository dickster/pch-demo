package com.brovada.document.config;

import com.google.common.collect.Lists;

import java.util.List;

public interface HasValidation {

    default List<String> getValidators() { return Lists.newArrayList(); };
    default List<String> getAsyncValidators() { return Lists.newArrayList(); };

}
