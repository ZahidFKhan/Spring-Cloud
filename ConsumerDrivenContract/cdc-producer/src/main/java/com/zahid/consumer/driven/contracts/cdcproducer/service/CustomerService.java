package com.zahid.consumer.driven.contracts.cdcproducer.service;

import com.zahid.consumer.driven.contracts.cdcproducer.entities.Customer;
import com.zahid.consumer.driven.contracts.cdcproducer.repository.CustomerRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
  private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public List<Customer> findAllCustomers() {
      return repository.findAll();
  }
}
