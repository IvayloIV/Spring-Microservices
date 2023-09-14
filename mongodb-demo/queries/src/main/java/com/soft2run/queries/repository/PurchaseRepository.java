package com.soft2run.queries.repository;

import com.soft2run.queries.entity.Purchase;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PurchaseRepository extends MongoRepository<Purchase, String> {
}
