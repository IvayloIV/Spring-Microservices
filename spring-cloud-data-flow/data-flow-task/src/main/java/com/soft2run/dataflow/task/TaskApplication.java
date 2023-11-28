package com.soft2run.dataflow.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;

import java.util.Random;

@Slf4j
@EnableTask
@SpringBootApplication
public class TaskApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(TaskApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Random random = new Random();
        int firstNum = random.nextInt(1000) + 1;
        int secondNum = random.nextInt(1000) + 1;
        log.info("{} + {} = {}", firstNum, secondNum, firstNum + secondNum);
    }
}
