package com.brovada.document;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QDraft is a Querydsl query type for Draft
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QDraft extends EntityPathBase<Draft> {

    private static final long serialVersionUID = -1218575422L;

    public static final QDraft draft = new QDraft("draft");

    public final StringPath broker = createString("broker");

    public final StringPath firstName = createString("firstName");

    public final StringPath id = createString("id");

    public final StringPath lastName = createString("lastName");

    public final StringPath middleName = createString("middleName");

    public final StringPath phone = createString("phone");

    public final StringPath proposal = createString("proposal");

    public final StringPath segment = createString("segment");

    public QDraft(String variable) {
        super(Draft.class, forVariable(variable));
    }

    public QDraft(Path<? extends Draft> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDraft(PathMetadata metadata) {
        super(Draft.class, metadata);
    }

}

