package com.brovada.old.document.config;

import com.brovada.old.document.DocReference;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Locale;
import java.util.Optional;

@Document
public class FormConfig extends PanelConfig {

    private @Nonnull Version version = new Version(1);

    private @Nonnull Locale locale = Locale.getDefault();
    private @Nullable String title = null;

    private @Nullable String initialFocus = null;
    private @Nullable DocReference<FormConfig> parent = null;
    private @Nullable String comments = null;

    public FormConfig() {
    }

    public FormConfig withLocale(@Nonnull Locale locale) {
        this.locale = locale;
        return this;
    }

    public FormConfig withInitialFocus(@Nonnull String inputId) {
        this.initialFocus = inputId;
        return this;
    }

    public FormConfig withTitle(@Nonnull String title) {
        this.title = title;
        return this;
    }

    @Nonnull
    public Version getVersion() {
        return version;
    }

    @Nonnull
    public Locale getLocale() {
        return locale;
    }


    public Optional<String> getInitialFocus() {
        return Optional.ofNullable(initialFocus);
    }

    public @Nullable String getTitle() {
        return title;
    }

    public String getId() {
        return id;
    }


    public FormConfig merge(@Nonnull FormConfig formConfig) {
        // TODO : merge with formConfig. use JSON patch?
        // new Gson().toJson(this);
        // use this --> https://github.com/tananaev/json-patch
        return this;
    }

    @Override
    public String toString() {
        return "FormConfig{" +
                "title='" + title + '\'' +
                ", version=" + version +
                '}';
    }

    public Optional<DocReference<FormConfig>> getParent() {
        return Optional.of(parent);
    }
}
