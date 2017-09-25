package com.brovada.old.validation;

import javax.annotation.Nonnull;
import java.util.Map;

// server side validation factory.
// note that these are the things that are (typically) called by angular 2 asyncValidators.
//  angular 2 non-asyncValidators are all on the client side and have nothing to do with these.
public interface ValidatorFactory {

    public @Nonnull Validator create(String name, Map<String,String> params);

}
