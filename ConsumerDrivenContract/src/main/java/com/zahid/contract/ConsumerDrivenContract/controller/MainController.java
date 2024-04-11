package com.zahid.contract.ConsumerDrivenContract.controller;

import com.zahid.contract.ConsumerDrivenContract.entities.Customer;
import com.zahid.contract.ConsumerDrivenContract.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
public class MainController {
  private final CustomerRepository customerRepository;

  @GetMapping
  public List<Customer> allCustomers() {
    return customerRepository.findAll();
  }
}
