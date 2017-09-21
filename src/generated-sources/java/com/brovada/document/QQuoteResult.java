package com.brovada.document;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QQuoteResult is a Querydsl query type for QuoteResult
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QQuoteResult extends EntityPathBase<QuoteResult> {

    private static final long serialVersionUID = -1329212646L;

    public static final QQuoteResult quoteResult = new QQuoteResult("quoteResult");

    public final DateTimePath<java.util.Date> created = createDateTime("created", java.util.Date.class);

    public final DateTimePath<java.util.Date> expiry = createDateTime("expiry", java.util.Date.class);

    public final ListPath<String, StringPath> notes = this.<String, StringPath>createList("notes", String.class, StringPath.class, PathInits.DIRECT2);

    public final StringPath quoteMethod = createString("quoteMethod");

    public final StringPath referrer = createString("referrer");

    public final NumberPath<Long> status = createNumber("status", Long.class);

    public final NumberPath<Double> totalPremium = createNumber("totalPremium", Double.class);

    public QQuoteResult(String variable) {
        super(QuoteResult.class, forVariable(variable));
    }

    public QQuoteResult(Path<? extends QuoteResult> path) {
        super(path.getType(), path.getMetadata());
    }

    public QQuoteResult(PathMetadata metadata) {
        super(QuoteResult.class, metadata);
    }

}

