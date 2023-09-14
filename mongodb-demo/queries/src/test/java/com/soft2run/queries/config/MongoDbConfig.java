package com.soft2run.queries.config;

import com.soft2run.queries.repository.CustomerRepository;
import com.soft2run.queries.repository.PurchaseRepository;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

@TestConfiguration
public class MongoDbConfig {

    @Bean
    public CascadeCustomerEventListener cascadeCustomerEventListener(PurchaseRepository purchaseRepository,
                                                                     CustomerRepository customerRepository) {
        return new CascadeCustomerEventListener(purchaseRepository, customerRepository);
    }

    //TODO: Uncomment if you want to use standalone database, not embedded
//    @Bean
//    public MongoDatabaseFactory mongoDatabaseFactory() {
//        return new SimpleMongoClientDatabaseFactory("mongodb://admin:password@localhost:27017/test?authSource=admin");
//    }
//
//    @Bean
//    public MongoTemplate mongoTemplate() {
//        return new MongoTemplate(mongoDatabaseFactory());
//    }
}
