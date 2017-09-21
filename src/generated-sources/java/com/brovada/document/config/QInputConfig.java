package com.brovada.document.config;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QInputConfig is a Querydsl query type for InputConfig
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QInputConfig extends BeanPath<InputConfig<?>> {

    private static final long serialVersionUID = -1634120129L;

    public static final QInputConfig inputConfig = new QInputConfig("inputConfig");

    public final StringPath formControlName = createString("formControlName");

    public final SimplePath<java.util.Optional<InputType>> inputType = createSimple("inputType", java.util.Optional.class);

    public final SimplePath<java.util.Optional<String>> label = createSimple("label", java.util.Optional.class);

    public final BooleanPath required = createBoolean("required");

    public final EnumPath<ComponentType> type = createEnum("type", ComponentType.class);

    @SuppressWarnings({"all", "rawtypes", "unchecked"})
    public QInputConfig(String variable) {
        super((Class) InputConfig.class, forVariable(variable));
    }

    @SuppressWarnings({"all", "rawtypes", "unchecked"})
    public QInputConfig(Path<? extends InputConfig> path) {
        super((Class) path.getType(), path.getMetadata());
    }

    @SuppressWarnings({"all", "rawtypes", "unchecked"})
    public QInputConfig(PathMetadata metadata) {
        super((Class) InputConfig.class, metadata);
    }

}

