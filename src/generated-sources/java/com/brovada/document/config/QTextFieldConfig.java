package com.brovada.document.config;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QTextFieldConfig is a Querydsl query type for TextFieldConfig
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QTextFieldConfig extends EntityPathBase<TextFieldConfig> {

    private static final long serialVersionUID = -1910389118L;

    public static final QTextFieldConfig textFieldConfig = new QTextFieldConfig("textFieldConfig");

    public final QInputConfig _super = new QInputConfig(this);

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

    public QTextFieldConfig(String variable) {
        super(TextFieldConfig.class, forVariable(variable));
    }

    public QTextFieldConfig(Path<? extends TextFieldConfig> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTextFieldConfig(PathMetadata metadata) {
        super(TextFieldConfig.class, metadata);
    }

}

