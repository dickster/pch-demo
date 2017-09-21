package com.brovada.document.config;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.annotation.Nonnull;

@Document
public class LabelConfig implements ComponentConfig {

    // how to display simple bound label/text.   like "hello {{name}}"

    private @Nonnull String key;

    public LabelConfig(String key) {
        withKey(key);
    }

    private LabelConfig withKey(String key) {
        this.key = key;
        return this;
    }

    @Override
    public ComponentType getType() {
        return ComponentType.LABEL;
    }

    @Override
    public String toString() {
        return "Label{" +
                "key='" + key + '\'' +
                '}';
    }

    //    { type:  label:  order:  required: id:  dropdownvalues:  defaultValue? validators:["required"] ,asyncValidator:[]  css: },
//    { type:  label:  order:  required: id:  dropdownvalues:
//    dependents :  [{ type: label: order : required: id:  when:[valueA,valueB,valueF] },
//        { type: label: order : required: id:  when:"valueB" }]
//        //any level of dependents...
//    }
//    { type:  label:  order:  required: id:  defaultValue:  autocompleteRestUrl:  otherNg2CompleterAttributes },
//    { type:  label:  order:  required: id:  defaultValue: inputType /* html5 type */},

}
