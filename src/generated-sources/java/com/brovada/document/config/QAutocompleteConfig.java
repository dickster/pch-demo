package com.brovada.document.config;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QAutocompleteConfig is a Querydsl query type for AutocompleteConfig
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAutocompleteConfig extends EntityPathBase<AutocompleteConfig<?>> {

    private static final long serialVersionUID = 978767703L;

    public static final QAutocompleteConfig autocompleteConfig = new QAutocompleteConfig("autocompleteConfig");

    public final QInputConfig _super = new QInputConfig(this);

    // custom
    public final QChoiceProvider choiceProvider = new QChoiceProvider(forProperty("choiceProvider"));

    //inherited
    public final StringPath formControlName = _super.formControlName;

    //inherited
    public final SimplePath<java.util.Optional<InputType>> inputType = _super.inputType;

    //inherited
    public final SimplePath<java.util.Optional<String>> label = _super.label;

    public final BooleanPath remote = createBoolean("remote");

    //inherited
    public final BooleanPath required = _super.required;

    //inherited
    public final EnumPath<ComponentType> type = _super.type;

    @SuppressWarnings({"all", "rawtypes", "unchecked"})
    public QAutocompleteConfig(String variable) {
        super((Class) AutocompleteConfig.class, forVariable(variable));
    }

    @SuppressWarnings({"all", "rawtypes", "unchecked"})
    public QAutocompleteConfig(Path<? extends AutocompleteConfig> path) {
        super((Class) path.getType(), path.getMetadata());
    }

    @SuppressWarnings({"all", "rawtypes", "unchecked"})
    public QAutocompleteConfig(PathMetadata metadata) {
        super((Class) AutocompleteConfig.class, metadata);
    }

}

