package com.xuetaoshi.customer.dal.repos;

import org.springframework.data.repository.CrudRepository;

import com.xuetaoshi.customer.dal.entities.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
