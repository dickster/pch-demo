package com.brovada.old.document.config;

import java.util.Optional;

// for form <input> elements.   note that <textarea> & <select> are not part of this hierarchy.
public abstract class InputConfig<T> implements ComponentConfig {

    private final ComponentType type;
    private String label;
    private String formControlName;


    protected InputConfig(ComponentType type, String formControlName) {
        this.type = type;
        this.formControlName = formControlName;
    }

    protected <T extends InputConfig> T labelled(String label) {
        this.label = label;
        return (T) this;
    }

    @Override
    public ComponentType getType() {
        return type;
    }

    public String getFormControlName() {
        return formControlName;
    }

    Optional<String> getLabel()  { return Optional.of(""); }
    Optional<InputType> getInputType() { return Optional.of(InputType.TEXT); }
    boolean isRequired() { return true; }
    Optional<T> defaultValue() { return Optional.empty(); }
    Optional<T> order() { return Optional.empty(); }
    Optional<String> getHelpText() { return Optional.empty(); }
    Optional<String> getFeedback() { return Optional.empty(); }

}
