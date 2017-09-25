package com.brovada.old.document;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPolicy is a Querydsl query type for Policy
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPolicy extends EntityPathBase<Policy> {

    private static final long serialVersionUID = 1219977009L;

    public static final QPolicy policy = new QPolicy("policy");

    public final StringPath comments = createString("comments");

    public final DateTimePath<java.util.Date> created = createDateTime("created", java.util.Date.class);

    public final StringPath id = createString("id");

    public final StringPath policyNumber = createString("policyNumber");

    public final StringPath primaryQuote = createString("primaryQuote");

    public final ListPath<String, StringPath> quotes = this.<String, StringPath>createList("quotes", String.class, StringPath.class, PathInits.DIRECT2);

    public QPolicy(String variable) {
        super(Policy.class, forVariable(variable));
    }

    public QPolicy(Path<? extends Policy> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPolicy(PathMetadata metadata) {
        super(Policy.class, metadata);
    }

}

