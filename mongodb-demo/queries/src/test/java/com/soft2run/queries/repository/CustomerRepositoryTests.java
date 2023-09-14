package com.soft2run.queries.repository;

import com.soft2run.queries.config.MongoDbConfig;
import com.soft2run.queries.entity.Customer;
import com.soft2run.queries.entity.Purchase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataMongoTest
@ExtendWith(SpringExtension.class)
@Import(MongoDbConfig.class)
public class CustomerRepositoryTests {

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @BeforeEach
    public void initData() {
        Purchase purchase = Purchase.builder()
                .name("Mares")
                .description("Test Mares")
                .price(2.50)
                .build();

        Customer customer = Customer.builder()
                .id("test-id-1")
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
                .id("test-id-2")
                .firstName("Pesho2")
                .birthDate(LocalDate.now())
                .entity(Customer.ENTITY.LEGAL)
                .blocked(false)
                .purchase(purchase)
                .build();

        customerRepository.insert(List.of(customer, customer2));
    }

    @AfterEach
    public void removeData() {
        customerRepository.deleteAll();
        purchaseRepository.deleteAll();
    }

    @Test
    public void findByFirstNameCustom_OK() {
        String firstName = "Pesho2";

        List<Customer> customers = customerRepository.findByFirstNameCustom(firstName);

        assertEquals(1, customers.size());
        assertEquals("test-id-2", customers.get(0).getId());
    }

    @Test
    public void testCascadeInsert() {
        Purchase purchase3 = Purchase.builder()
                .id("test-purchase-id-3")
                .name("Mares2")
                .description("Test Mares")
                .price(2.50)
                .build();

        Customer customer3 = Customer.builder()
                .id("test-customer-id-3")
                .firstName("Pesho2")
                .birthDate(LocalDate.now())
                .entity(Customer.ENTITY.LEGAL)
                .blocked(false)
                .purchase(purchase3)
                .build();


        Customer customer = customerRepository.save(customer3);

        assertNotNull(customer.getPurchase());
        assertEquals("test-purchase-id-3", customer.getPurchase().getId());
    }
}
