package com.zahid.contract.ConsumerDrivenContract.service;

import com.zahid.contract.ConsumerDrivenContract.entities.Customer;
import com.zahid.contract.ConsumerDrivenContract.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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
