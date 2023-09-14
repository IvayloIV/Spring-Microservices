package com.soft2run.specification;

import com.soft2run.specification.entity.Customer;
import com.soft2run.specification.entity.Customer_;
import com.soft2run.specification.repository.CustomerRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

import static com.soft2run.specification.repository.specification.CustomerSpecification.*;

@SpringBootApplication
public class SpecificationApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(SpecificationApplication.class, args);
        CustomerRepository customerRepository = applicationContext.getBean(CustomerRepository.class);

        final Long id = 1L;
        final Customer.ENTITY legal = Customer.ENTITY.LEGAL;
        final String fullName = "no2";

        List<Customer> customers = customerRepository.findAll(withId(id)
                .and(withEntityType(legal))
                .and(withFullNameLike(fullName)));
        System.out.println(customers);
    }
}
