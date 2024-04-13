package com.zahid.consumer.driven.contracts.cdcproducer;

import com.zahid.consumer.driven.contracts.cdcproducer.controller.MainController;
import com.zahid.consumer.driven.contracts.cdcproducer.entities.Customer;
import com.zahid.consumer.driven.contracts.cdcproducer.repository.CustomerRepository;
import com.zahid.consumer.driven.contracts.cdcproducer.service.CustomerService;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public abstract class CDCBaseTest {
  @MockBean CustomerService service;
  @MockBean
  CustomerRepository repository;
  @Autowired MainController controller;

  @BeforeEach
  public void setUp() {
    RestAssuredMockMvc.standaloneSetup(controller);
    Mockito.when(service.findAllCustomers())
        .thenReturn(List.of(new Customer(1, "Zahid"), new Customer(2, "Arif")));
  }
}
