package com.soft2run.queries;

import com.soft2run.queries.entity.Customer;
import com.soft2run.queries.entity.Purchase;
import com.soft2run.queries.repository.CustomerRepository;
import com.soft2run.queries.repository.PurchaseRepository;
import io.mongock.runner.springboot.EnableMongock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.time.LocalDate;

@SpringBootApplication
@EnableMongock
public class QueriesApplication {

    private static CustomerRepository customerRepository;
    private static PurchaseRepository purchaseRepository;
    private static MongoTemplate mongoTemplate;
    private static Purchase purchase;
    private static Customer customer;
    private static Purchase purchase2;
    private static Customer customer2;


    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(QueriesApplication.class, args);
        customerRepository = applicationContext.getBean(CustomerRepository.class);
        purchaseRepository = applicationContext.getBean(PurchaseRepository.class);
        mongoTemplate = applicationContext.getBean(MongoTemplate.class);

        purchase = Purchase.builder()
                .name("Mares")
                .description("Test Mares")
                .price(2.50)
                .build();

        customer = Customer.builder()
                .firstName("Pesho")
                .birthDate(LocalDate.now())
                .entity(Customer.ENTITY.LEGAL)
                .blocked(false)
                .purchase(purchase)
                .build();

        purchase2 = Purchase.builder()
                .name("Mares2")
                .description("Test Mares")
                .price(2.50)
                .build();

        customer2 = Customer.builder()
                .firstName("Pesho2")
                .birthDate(LocalDate.now())
                .entity(Customer.ENTITY.LEGAL)
                .blocked(false)
                .purchase(purchase)
                .build();

//        Purchase savedPurchase = purchaseRepository.save(purchase);
//        System.out.println(savedPurchase);
//
//        Customer savedCustomer = customerRepository.save(customer);
//        System.out.println(savedCustomer);
//
//        List<Customer> customers = customerRepository.findAll();
//        System.out.println(customers);
//
//        List<Customer> customers = customerRepository.findByFirstName("Pesho2");
//        System.out.println(customers);
//
//        List<Customer> customers = customerRepository.findByFirstNameCustom("Pesho2");
//        System.out.println(customers);

//        customerRepository.findAll()
//            .forEach(c -> customerRepository.deleteById(c.getId()));

//        purchaseRepository.saveAll(List.of(purchase, purchase2));
//        customerRepository.insert(List.of(customer, customer2));

//        List<Customer> customers = customerRepository.findByIdOrFirstName("64734dac5743ea10953753ee", "Pesho2");
//        System.out.println(customers);

//        List<Customer> customers = customerRepository.findAll(Sort.by("firstName").descending());
//        System.out.println(customers);

//        Customer pesho = customerRepository.findById("64734dac5743ea10953753ee").get();
//        pesho = pesho.toBuilder().blocked(true).build();
//        customerRepository.save(pesho);

//        customerRepository.deleteById("64734dac5743ea10953753ee");

//        List<Customer> mares = customerRepository.findByPurchaseNameCustom("Mares");
//        System.out.println(mares);
    }

    private static void mongoDbExamples() {
        //        Query query = new Query();
//        query.addCriteria(Criteria.where("firstName").is("Pesho2"));
//        List<Customer> customers = mongoTemplate.find(query, Customer.class);
//        System.out.println(customers);

//        Query query = Query.query(
//            new Criteria().orOperator(
//                Criteria.where("entity").is(Customer.ENTITY.PHYSICAL),
//                Criteria.where("blocked").is(true)
//            )
//        );
//
//        List<Customer> customers = mongoTemplate.find(query, Customer.class);
//        System.out.println(customers);

//        Query query = Query.query(Criteria.where("purchase.name").is("Kola"));
//
//        List<Customer> customers = mongoTemplate.find(query, Customer.class);
//        System.out.println(customers);

//        TextCriteria textCriteria = TextCriteria
//                .forDefaultLanguage()
//                .matching("Mares");
//
//        TextQuery textQuery = TextQuery.queryText(textCriteria)
//                .sortByScore()
//                .includeScore();
//
//        List<Customer> customers = mongoTemplate.find(textQuery, Customer.class);
//        System.out.println(customers);

//        mongoTemplate.findAllAndRemove(new Query(), Customer.class);

//        mongoTemplate.insert(customer);
//        mongoTemplate.insert(customer2);

//        mongoTemplate.insertAll(List.of(customer, customer2));

//        mongoTemplate.updateMulti(
//                new Query(),
//                Update.update("isBlocked", true),
//                Customer.class
//        );

//        Customer savedCustomer = mongoTemplate.findById("64733000cb2b080509293cdd", Customer.class);
//        savedCustomer = savedCustomer.toBuilder().blocked(false).build();
//        mongoTemplate.save(savedCustomer);

//        mongoTemplate.dropCollection(Customer.class);
//        mongoTemplate.dropCollection(Purchase.class);
    }
}
