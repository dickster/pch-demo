package com.brovada.validation;

import org.springframework.stereotype.Component;

import javax.annotation.Nonnull;
import javax.inject.Inject;
import java.util.Map;


@Component
public class SampleValidatorFactory implements ValidatorFactory {

    @Inject private EmailValidator emailValidator;

    public @Nonnull Validator create(String name, Map<String, String> params) {
        switch (name) {

            case "email":
                return emailValidator;

            // add other cases here...

            default:
//                return null;  this will yield a compiler error due to @Nonnull annotation on method.
                return parms -> ValidationResult.valid().withResult("msg", "hello world");
        }
    }


}
