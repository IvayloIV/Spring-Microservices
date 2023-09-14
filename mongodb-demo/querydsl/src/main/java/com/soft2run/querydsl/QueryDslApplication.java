package com.soft2run.querydsl;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.soft2run.querydsl.entity.Customer;
import com.soft2run.querydsl.entity.QCustomer;
import com.soft2run.querydsl.repository.CustomerRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class QueryDslApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(QueryDslApplication.class, args);
        CustomerRepository customerRepository = applicationContext.getBean(CustomerRepository.class);

        QCustomer customer = QCustomer.customer;
        BooleanExpression booleanExpression = customer.firstName.eq("Pesho2");
        Iterable<Customer> customers = customerRepository.findAll(booleanExpression);
        System.out.println(customers);
    }
}
