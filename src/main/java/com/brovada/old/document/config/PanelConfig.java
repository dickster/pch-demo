package com.brovada.old.document.config;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class PanelConfig implements ComponentConfig, HasChildren, HasValidation {

    protected String label;
    protected List<String> validators;
    protected List<String> asyncValidators;
    protected List<? extends ComponentConfig> children;

    @Id
    public String id;

    @Override
    public ComponentType getType() {
        return ComponentType.PANEL;
    }

    @Override
    public List<? extends ComponentConfig> getChildren() {
        return children;
    }

    public <T extends PanelConfig> T withChildren(List<? extends ComponentConfig> children) {
        this.children = children;
        return (T) this;
    }

    public <T extends PanelConfig> T withValidators(List<String> validators) {
        this.validators = validators;
        return (T) this;
    }

    public <T extends PanelConfig> T withAsyncValidators(List<String> asyncValidators) {
        this.asyncValidators = asyncValidators;
        return (T) this;
    }

    public <T extends PanelConfig> T withLabel(String label) {
        this.label = label;
        return (T) this;
    }

    public String getLabel() {
        return label;
    }

    public List<String> getValidators() {
        return validators;
    }

    public List<String> getAsyncValidators() {
        return asyncValidators;
    }
}
