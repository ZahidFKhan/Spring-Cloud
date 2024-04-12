package com.zahid.contract.ConsumerDrivenContract;

import com.zahid.contract.ConsumerDrivenContract.controller.MainController;
import com.zahid.contract.ConsumerDrivenContract.entities.Customer;
import com.zahid.contract.ConsumerDrivenContract.service.CustomerService;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

@SpringBootTest
public abstract class CDCBaseTest {
  @MockBean CustomerService service;
  @Autowired MainController controller;

  @BeforeEach
  public void setUp() {
    RestAssuredMockMvc.standaloneSetup(controller);
    Mockito.when(service.findAllCustomers())
        .thenReturn(List.of(new Customer(1, "Zahid"), new Customer(2, "Arif")));
  }
}
