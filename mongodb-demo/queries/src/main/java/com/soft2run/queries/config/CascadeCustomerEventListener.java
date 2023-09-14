package com.soft2run.queries.config;

import com.soft2run.queries.entity.Customer;
import com.soft2run.queries.entity.Purchase;
import com.soft2run.queries.repository.CustomerRepository;
import com.soft2run.queries.repository.PurchaseRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.data.mongodb.core.mapping.event.BeforeDeleteEvent;
import org.springframework.stereotype.Component;

@Component
public class CascadeCustomerEventListener extends AbstractMongoEventListener<Customer> {

    private final PurchaseRepository purchaseRepository;
    private final CustomerRepository customerRepository;

    @Autowired
    public CascadeCustomerEventListener(PurchaseRepository purchaseRepository,
                                        CustomerRepository customerRepository) {
        this.purchaseRepository = purchaseRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public void onBeforeConvert(BeforeConvertEvent<Customer> event) {
        Purchase purchase = event.getSource().getPurchase();
        purchaseRepository.save(purchase);
    }

    @Override
    public void onBeforeDelete(BeforeDeleteEvent<Customer> event) {
        ObjectId objectId = event.getDocument().get("_id", ObjectId.class);
        Customer customer = customerRepository.findById(objectId.toString()).get();
        purchaseRepository.delete(customer.getPurchase());
    }
}
