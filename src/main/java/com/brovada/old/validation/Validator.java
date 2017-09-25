package com.brovada.old.validation;

import javax.annotation.Nonnull;
import java.security.InvalidParameterException;
import java.util.Map;

public interface Validator {

    @Nonnull ValidationResult validate(Map<String,String> params);

    default void verifyParams(Map<String, String> params) {
        ValidationParams vp = getClass().getAnnotation(ValidationParams.class);
        if (vp!=null) {
            for (ValidationParam param:vp.value()) {
                String key = param.value();
                if (params.get(key)==null) {
                    throw new InvalidParameterException("expecting parameter " + key + " but not found");
                }
                //try to convert type??
    //            ignore  this for now..
            }
        }
    }
}
