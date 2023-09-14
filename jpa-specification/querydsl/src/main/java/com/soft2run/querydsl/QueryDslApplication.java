package com.soft2run.querydsl;

import com.soft2run.querydsl.entity.Customer;
import com.soft2run.querydsl.entity.QCustomer;
import com.soft2run.querydsl.repository.CustomerRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class QueryDslApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(QueryDslApplication.class, args);
        CustomerRepository customerRepository = applicationContext.getBean(CustomerRepository.class);

        final Long id = 1L;
        final Customer.ENTITY legal = Customer.ENTITY.LEGAL;
        final String fullName = "n2o";

        QCustomer qCustomer = QCustomer.customer;
        Iterable<Customer> customers = customerRepository.findAll(qCustomer.id.eq(id)
                .and(qCustomer.entity.eq(legal))
                .and(qCustomer.fullName.like("%" + fullName.toLowerCase() + "%")));
        System.out.println(customers);
    }
}
