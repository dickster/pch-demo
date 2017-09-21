package com.brovada.repository;

import com.brovada.document.Message;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface MessageRepository extends MongoRepository<Message, String>, QueryDslPredicateExecutor<Message> {

   // inherited save method used.


}
