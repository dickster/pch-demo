package com.brovada.document.config;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QFormConfig is a Querydsl query type for FormConfig
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QFormConfig extends EntityPathBase<FormConfig> {

    private static final long serialVersionUID = -2090847181L;

    public static final QFormConfig formConfig = new QFormConfig("formConfig");

    public final QPanelConfig _super = new QPanelConfig(this);

    //inherited
    public final ListPath<String, StringPath> asyncValidators = _super.asyncValidators;

    //inherited
    public final ListPath<ComponentConfig, QComponentConfig> children = _super.children;

    public final StringPath id = createString("id");

    public final SimplePath<java.util.Optional<String>> initialFocus = createSimple("initialFocus", java.util.Optional.class);

    //inherited
    public final StringPath label = _super.label;

    public final SimplePath<java.util.Optional<LayoutHint>> layoutHint = createSimple("layoutHint", java.util.Optional.class);

    public final SimplePath<java.util.Locale> locale = createSimple("locale", java.util.Locale.class);

    public final NumberPath<Long> majorVersion = createNumber("majorVersion", Long.class);

    public final NumberPath<Long> minorVersion = createNumber("minorVersion", Long.class);

    //inherited
    public final EnumPath<ComponentType> type = _super.type;

    //inherited
    public final ListPath<String, StringPath> validators = _super.validators;

    public final NumberPath<java.math.BigDecimal> version = createNumber("version", java.math.BigDecimal.class);

    public QFormConfig(String variable) {
        super(FormConfig.class, forVariable(variable));
    }

    public QFormConfig(Path<? extends FormConfig> path) {
        super(path.getType(), path.getMetadata());
    }

    public QFormConfig(PathMetadata metadata) {
        super(FormConfig.class, metadata);
    }

}

