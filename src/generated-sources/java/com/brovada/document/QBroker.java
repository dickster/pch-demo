package com.brovada.old.document;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QBroker is a Querydsl query type for Broker
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QBroker extends EntityPathBase<Broker> {

    private static final long serialVersionUID = 822030808L;

    public static final QBroker broker = new QBroker("broker");

    public final StringPath desc = createString("desc");

    public final StringPath firstName = createString("firstName");

    public final StringPath id = createString("id");

    public final StringPath lastName = createString("lastName");

    public final StringPath number = createString("number");

    public QBroker(String variable) {
        super(Broker.class, forVariable(variable));
    }

    public QBroker(Path<? extends Broker> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBroker(PathMetadata metadata) {
        super(Broker.class, metadata);
    }

}

