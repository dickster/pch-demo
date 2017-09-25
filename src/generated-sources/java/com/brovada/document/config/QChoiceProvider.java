package com.brovada.old.document.config;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QChoiceProvider is a Querydsl query type for ChoiceProvider
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QChoiceProvider extends BeanPath<ChoiceProvider<?>> {

    private static final long serialVersionUID = 894018367L;

    public static final QChoiceProvider choiceProvider = new QChoiceProvider("choiceProvider");

    @SuppressWarnings({"all", "rawtypes", "unchecked"})
    public QChoiceProvider(String variable) {
        super((Class) ChoiceProvider.class, forVariable(variable));
    }

    @SuppressWarnings({"all", "rawtypes", "unchecked"})
    public QChoiceProvider(Path<? extends ChoiceProvider> path) {
        super((Class) path.getType(), path.getMetadata());
    }

    @SuppressWarnings({"all", "rawtypes", "unchecked"})
    public QChoiceProvider(PathMetadata metadata) {
        super((Class) ChoiceProvider.class, metadata);
    }

}

