package com.brovada.old.document.config;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QDropDownConfig is a Querydsl query type for DropDownConfig
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QDropDownConfig extends EntityPathBase<DropDownConfig<?>> {

    private static final long serialVersionUID = 1686997856L;

    public static final QDropDownConfig dropDownConfig = new QDropDownConfig("dropDownConfig");

    public final QInputConfig _super = new QInputConfig(this);

    // custom
    public final QChoiceProvider choiceProvider = new QChoiceProvider(forProperty("choiceProvider"));

    //inherited
    public final StringPath formControlName = _super.formControlName;

    //inherited
    public final SimplePath<java.util.Optional<InputType>> inputType = _super.inputType;

    //inherited
    public final SimplePath<java.util.Optional<String>> label = _super.label;

    //inherited
    public final BooleanPath required = _super.required;

    //inherited
    public final EnumPath<ComponentType> type = _super.type;

    @SuppressWarnings({"all", "rawtypes", "unchecked"})
    public QDropDownConfig(String variable) {
        super((Class) DropDownConfig.class, forVariable(variable));
    }

    @SuppressWarnings({"all", "rawtypes", "unchecked"})
    public QDropDownConfig(Path<? extends DropDownConfig> path) {
        super((Class) path.getType(), path.getMetadata());
    }

    @SuppressWarnings({"all", "rawtypes", "unchecked"})
    public QDropDownConfig(PathMetadata metadata) {
        super((Class) DropDownConfig.class, metadata);
    }

}

