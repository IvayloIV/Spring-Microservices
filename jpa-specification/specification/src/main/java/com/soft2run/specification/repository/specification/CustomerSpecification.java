package com.soft2run.specification.repository.specification;

import com.soft2run.specification.entity.Customer;
import com.soft2run.specification.entity.Customer_;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.ObjectUtils;

public class CustomerSpecification {

    public static Specification<Customer> withId(Long id) {
        if (ObjectUtils.isEmpty(id)) {
            return (customer, cq, cb) -> cb.conjunction();
        } else {
            return (customer, cq, cb) -> cb.equal(customer.get(Customer_.ID), id);
        }
    }

    public static Specification<Customer> withEntityType(Customer.ENTITY entity) {
        if (ObjectUtils.isEmpty(entity)) {
            return (customer, cq, cb) -> cb.conjunction();
        } else {
            return (customer, cq, cb) -> cb.equal(customer.get(Customer_.ENTITY), entity);
        }
    }

    public static Specification<Customer> withFullNameLike(String name) {
        if (ObjectUtils.isEmpty(name)) {
            return (customer, cq, cb) -> cb.conjunction();
        } else {
            return (customer, cq, cb) -> cb.like(cb.lower(customer.get(Customer_.FULL_NAME)), "%" + name.toLowerCase() + "%");
        }
    }
}
