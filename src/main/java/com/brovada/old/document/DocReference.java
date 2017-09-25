package com.brovada.old.document;

import com.brovada.old.document.config.Version;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;




public class DocReference<T> {
    private @Nonnull String id;
    private @Nullable Version version;

    public DocReference(@Nonnull String id) {
        this.id = id;
    }

    public DocReference(@Nonnull String id, @Nullable Version version) {
        this.id = id;
        this.version = version;
    }


    @Nullable
    public T loadReferencedDoc(DocReference docRef) {
         //load all docs with exact or max major/minor/patch values.
        return null;
    }

    @Nonnull
    public String getId() {
        return id;
    }

    @Nullable
    public Version getVersion() {
        return version;
    }
}
