package com.zahid.consumer.driven.contracts.cdcproducer.controller;

import com.zahid.consumer.driven.contracts.cdcproducer.entities.Customer;
import com.zahid.consumer.driven.contracts.cdcproducer.service.CustomerService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
public class MainController {
  private final CustomerService service;

  public MainController(CustomerService service) {
    this.service = service;
  }

  @GetMapping
  public List<Customer> allCustomers() {
    return service.findAllCustomers();
  }
}
