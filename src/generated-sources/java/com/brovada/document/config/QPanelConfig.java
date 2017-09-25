package com.brovada.old.document.config;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPanelConfig is a Querydsl query type for PanelConfig
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPanelConfig extends EntityPathBase<PanelConfig> {

    private static final long serialVersionUID = -78516999L;

    public static final QPanelConfig panelConfig = new QPanelConfig("panelConfig");

    public final ListPath<String, StringPath> asyncValidators = this.<String, StringPath>createList("asyncValidators", String.class, StringPath.class, PathInits.DIRECT2);

    public final ListPath<ComponentConfig, QComponentConfig> children = this.<ComponentConfig, QComponentConfig>createList("children", ComponentConfig.class, QComponentConfig.class, PathInits.DIRECT2);

    public final StringPath id = createString("id");

    public final StringPath label = createString("label");

    public final EnumPath<ComponentType> type = createEnum("type", ComponentType.class);

    public final ListPath<String, StringPath> validators = this.<String, StringPath>createList("validators", String.class, StringPath.class, PathInits.DIRECT2);

    public QPanelConfig(String variable) {
        super(PanelConfig.class, forVariable(variable));
    }

    public QPanelConfig(Path<? extends PanelConfig> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPanelConfig(PathMetadata metadata) {
        super(PanelConfig.class, metadata);
    }

}

