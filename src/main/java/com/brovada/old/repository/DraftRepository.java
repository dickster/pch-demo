package com.brovada.old.repository;

import com.brovada.old.document.Draft;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface DraftRepository extends MongoRepository<Draft, String>, QueryDslPredicateExecutor<Draft> {

    public Draft findById(String id);

}
