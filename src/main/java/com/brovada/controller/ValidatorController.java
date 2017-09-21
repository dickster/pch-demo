package com.brovada.controller;

import com.brovada.validation.ValidationResult;
import com.brovada.validation.Validator;
import com.brovada.validation.ValidatorFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.Map;

@RestController
@RequestMapping(value = "/validate")
public class ValidatorController {

    // typically used in conjunction with ng2 async validators.

    private @Inject ValidatorFactory validatorFactory;

    @RequestMapping(value = "/{validatorName}", method = RequestMethod.GET)
    ValidationResult validate( @PathVariable String validatorName, @RequestParam Map<String,String> params) {
        Validator validator = validatorFactory.create(validatorName, params);
        validator.verifyParams(params);
        ValidationResult result = validator.validate(params);
        return result;
    }

}



// each form has an endpoint. either local or remote.
// it returns a result {code:'', msg:''}

// components can have a validator. these are mapped to urls.
// min --> validator/min?parm1=foo&parm2=bar passes form value.
// .: don't need factory.  just a unit test to make sure that all validators are mapped to a REST service.
// local = method registered to angular 2 app.  (ValidatorFactory.create('name'))
// all validators should accept parameter "value='xyz'".
// group validators should take a PathVariable...a JSON<->Java object?

// how can i Genericize the parameters to a group validator?


// ng2Tab component is a GroupConfig...  .: each component needs to get the "root" object for its model.
// default components use form variable,
// policy.name.first.   policy is default root variable.
// policy.drivers[0]    policy.drivers[0] is root variable.

// how to give index to

