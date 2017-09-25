package com.brovada.old.repository;

import com.brovada.old.document.Broker;
import com.brovada.old.document.QBroker;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import java.util.List;

public interface BrokerRepository extends MongoRepository<Broker, String>, QueryDslPredicateExecutor<Broker> {

    public Broker findByFirstName(String firstName);
    public Broker findByFirstNameIgnoreCase(String firstName);
    public List<Broker> findByLastName(String lastName);
    public List<Broker> findByLastNameIgnoreCase(String lastName);
    public List<Broker> findTop30ByLastName(String lastName);

   // @Cacheable("broker")
    default public List<Broker> find(String search) {
        QBroker broker = new QBroker("x");

        if (StringUtils.isNotBlank(search)) {
            Iterable<Broker> result = findAll(
                    broker.number.containsIgnoreCase(search)
                      .or(broker.firstName.containsIgnoreCase(search))
                      .or(broker.lastName.containsIgnoreCase(search))
            );
            return Lists.newArrayList(result);
        }
        else {
            return findAll();
        }
    }

    @CacheEvict(value = "broker")
    default public void resetBrokers() {
        // do nothing. strictly a marker to evict the cache.
    }

}
