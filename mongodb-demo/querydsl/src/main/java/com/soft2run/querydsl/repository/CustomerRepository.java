package com.soft2run.querydsl.repository;

import com.soft2run.querydsl.entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface CustomerRepository extends MongoRepository<Customer, String>, QuerydslPredicateExecutor<Customer> {
}
