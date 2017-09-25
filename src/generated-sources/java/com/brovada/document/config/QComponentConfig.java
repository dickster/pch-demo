package com.brovada.old.document.config;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QComponentConfig is a Querydsl query type for ComponentConfig
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QComponentConfig extends BeanPath<ComponentConfig> {

    private static final long serialVersionUID = -955801678L;

    public static final QComponentConfig componentConfig = new QComponentConfig("componentConfig");

    public final SimplePath<java.util.Optional<String>> css = createSimple("css", java.util.Optional.class);

    public final EnumPath<ComponentType> type = createEnum("type", ComponentType.class);

    public QComponentConfig(String variable) {
        super(ComponentConfig.class, forVariable(variable));
    }

    public QComponentConfig(Path<? extends ComponentConfig> path) {
        super(path.getType(), path.getMetadata());
    }

    public QComponentConfig(PathMetadata metadata) {
        super(ComponentConfig.class, metadata);
    }

}

