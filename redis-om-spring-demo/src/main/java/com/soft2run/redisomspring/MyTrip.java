package com.soft2run.redisomspring;

import com.redis.om.spring.annotations.Document;
import com.redis.om.spring.annotations.Indexed;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@Data
@RedisHash(value = "MyHash")
@Document
public class MyTrip {

    @Id
    @Indexed
    private String id;

    @Indexed
    private Double tripDistance;

    @Indexed
    private String summary;
}
