package com.soft2run.queries.migration;

import com.soft2run.queries.entity.Customer;
import com.soft2run.queries.entity.Purchase;
import com.soft2run.queries.repository.CustomerRepository;
import io.mongock.api.annotations.BeforeExecution;
import io.mongock.api.annotations.ChangeUnit;
import io.mongock.api.annotations.Execution;
import io.mongock.api.annotations.RollbackExecution;

import java.time.LocalDate;
import java.util.List;

@ChangeUnit(id = "seedCustomers", order = "001", author = "Ivo")
public class DbChangeLog001 {

    @Execution
    public void execution(CustomerRepository customerRepository) {
        Purchase purchase = Purchase.builder()
                .name("Mares")
                .description("Test Mares")
                .price(2.50)
                .build();

        Customer customer = Customer.builder()
                .firstName("Pesho")
                .birthDate(LocalDate.now())
                .entity(Customer.ENTITY.LEGAL)
                .blocked(false)
                .purchase(purchase)
                .build();

        Purchase purchase2 = Purchase.builder()
                .name("Mares2")
                .description("Test Mares")
                .price(2.50)
                .build();

        Customer customer2 = Customer.builder()
                .firstName("Pesho2")
                .birthDate(LocalDate.now())
                .entity(Customer.ENTITY.LEGAL)
                .blocked(false)
                .purchase(purchase)
                .build();

        customerRepository.insert(List.of(customer, customer2));
    }

    @RollbackExecution
    public void rollbackExecution(CustomerRepository customerRepository) {
        customerRepository.findAll()
            .forEach(c -> customerRepository.deleteById(c.getId()));
    }
}
