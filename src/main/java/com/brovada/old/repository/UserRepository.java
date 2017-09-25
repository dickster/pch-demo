package com.brovada.old.repository;

import com.brovada.old.document.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface UserRepository extends MongoRepository<User, String>, QueryDslPredicateExecutor<User> {

    public User findByEmail(String email);
    public User findByName(String name);


}
