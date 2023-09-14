package com.soft2run.queries.repository;

import com.soft2run.queries.entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends MongoRepository<Customer, String> {

    List<Customer> findByFirstName(String firstName);

    List<Customer> findByIdOrFirstName(String id, String firstName);

    @Query("{'firstName': ?0}")
    List<Customer> findByFirstNameCustom(String firstName);

    @Query("{'purchase.name': ?0}")
    List<Customer> findByPurchaseNameCustom(String purchaseName);
}
