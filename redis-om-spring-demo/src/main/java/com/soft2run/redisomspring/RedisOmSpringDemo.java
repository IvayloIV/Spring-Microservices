package com.soft2run.redisomspring;

import com.redis.om.spring.annotations.EnableRedisDocumentRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRedisDocumentRepositories
@SpringBootApplication
public class RedisOmSpringDemo {

	public static void main(String[] args) {
		SpringApplication.run(RedisOmSpringDemo.class, args);
	}

}
