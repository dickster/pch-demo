package com.brovada.validation;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QValidationResult is a Querydsl query type for ValidationResult
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QValidationResult extends EntityPathBase<ValidationResult> {

    private static final long serialVersionUID = 2081094295L;

    public static final QValidationResult validationResult = new QValidationResult("validationResult");

    public QValidationResult(String variable) {
        super(ValidationResult.class, forVariable(variable));
    }

    public QValidationResult(Path<? extends ValidationResult> path) {
        super(path.getType(), path.getMetadata());
    }

    public QValidationResult(PathMetadata metadata) {
        super(ValidationResult.class, metadata);
    }

}

