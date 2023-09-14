package com.soft2run.redisomspring;

import com.redis.om.spring.repository.RedisDocumentRepository;

public interface MyTripRepository extends RedisDocumentRepository<MyTrip, String> {
}
