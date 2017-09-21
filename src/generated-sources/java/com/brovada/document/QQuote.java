package com.brovada.document;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QQuote is a Querydsl query type for Quote
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QQuote extends EntityPathBase<Quote> {

    private static final long serialVersionUID = -1206466403L;

    public static final QQuote quote = new QQuote("quote");

    public final DateTimePath<java.util.Date> endDate = createDateTime("endDate", java.util.Date.class);

    public final StringPath firstName = createString("firstName");

    public final StringPath id = createString("id");

    public final StringPath lastName = createString("lastName");

    public final SimplePath<java.util.Optional<QuoteResult>> result = createSimple("result", java.util.Optional.class);

    public final DateTimePath<java.util.Date> startDate = createDateTime("startDate", java.util.Date.class);

    public QQuote(String variable) {
        super(Quote.class, forVariable(variable));
    }

    public QQuote(Path<? extends Quote> path) {
        super(path.getType(), path.getMetadata());
    }

    public QQuote(PathMetadata metadata) {
        super(Quote.class, metadata);
    }

}

