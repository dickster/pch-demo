package com.brovada.old.document.config;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QLayoutHint is a Querydsl query type for LayoutHint
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QLayoutHint extends EntityPathBase<LayoutHint> {

    private static final long serialVersionUID = -1210645538L;

    public static final QLayoutHint layoutHint = new QLayoutHint("layoutHint");

    public QLayoutHint(String variable) {
        super(LayoutHint.class, forVariable(variable));
    }

    public QLayoutHint(Path<? extends LayoutHint> path) {
        super(path.getType(), path.getMetadata());
    }

    public QLayoutHint(PathMetadata metadata) {
        super(LayoutHint.class, metadata);
    }

}

