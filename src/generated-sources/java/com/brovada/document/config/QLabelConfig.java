package com.brovada.document.config;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QLabelConfig is a Querydsl query type for LabelConfig
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QLabelConfig extends EntityPathBase<LabelConfig> {

    private static final long serialVersionUID = -1266029079L;

    public static final QLabelConfig labelConfig = new QLabelConfig("labelConfig");

    public final StringPath key = createString("key");

    public final EnumPath<ComponentType> type = createEnum("type", ComponentType.class);

    public QLabelConfig(String variable) {
        super(LabelConfig.class, forVariable(variable));
    }

    public QLabelConfig(Path<? extends LabelConfig> path) {
        super(path.getType(), path.getMetadata());
    }

    public QLabelConfig(PathMetadata metadata) {
        super(LabelConfig.class, metadata);
    }

}

