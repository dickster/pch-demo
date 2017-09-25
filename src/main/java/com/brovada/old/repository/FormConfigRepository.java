package com.brovada.old.repository;

import com.brovada.old.document.DocReference;
import com.brovada.old.document.config.FormConfig;
import com.brovada.old.document.config.QFormConfig;
import com.brovada.old.document.config.Version;
import com.google.common.collect.Lists;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import javax.annotation.Nonnull;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public interface FormConfigRepository extends DocRepository<FormConfig>, QueryDslPredicateExecutor<FormConfig> {

    public FormConfig findById(String id);

    default public @Nonnull FormConfig findLatestById(String id) {
        QFormConfig form= new QFormConfig("qf");

        FormConfig latest = null;
        BigDecimal v = new BigDecimal(Integer.MIN_VALUE);

        Iterable<FormConfig> result = findAll(form.id.eq(id));

        // TODO : change this to do a "max version #" query instead of looping through.
        Lists.newArrayList(result).stream().sorted().collect(Collectors.toList());
        for (FormConfig fc:result) {
            Version version = fc.getVersion();
            if (version.compareTo(v)>0) {
                latest = fc;
            }
        }
        if (latest!=null) {
            return resolve(latest);
        }
        throw new IllegalStateException("can't find any forms with id " + id);
    }

    default FormConfig resolve(FormConfig formConfig) {
        if (formConfig.getParent().isPresent()) {
            DocReference<FormConfig> ref = formConfig.getParent().get();
            FormConfig parent = findReferencedDoc(ref);
            return parent.merge(formConfig);
        }
        return formConfig;
    }


    // note : for development, you don't want caching but in production you do.
    // use spring.cache.type=NONE in application-dev.properties to turn it off.
    @Cacheable(value="form", key = "#name")
    // example of a refactor safe, coded query (as opposed to automatically generated ones above).
    default public List<FormConfig> find(String name) {
        QFormConfig form = new QFormConfig("qf");

        Iterable<FormConfig> result = findAll(
                form.id.containsIgnoreCase(name).
                        or(form.label.containsIgnoreCase(name))
        );
        return Lists.newArrayList(result);
    }


}