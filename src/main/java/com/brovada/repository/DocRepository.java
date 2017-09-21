package com.brovada.repository;

import com.brovada.document.DocReference;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import java.io.Serializable;

public interface DocRepository<T> extends MongoRepository<T, String>, QueryDslPredicateExecutor<T> {

    <D extends Serializable> D foo();

    default <T> T findReferencedDoc(DocReference<T> ref) {
        return null;
    }

}
