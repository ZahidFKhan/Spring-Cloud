package com.zahid.contract.ConsumerDrivenContract.controller;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.zahid.contract.ConsumerDrivenContract.entities.Customer;
import com.zahid.contract.ConsumerDrivenContract.repository.CustomerRepository;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
// @WebMvcTest(MainController.class)
@AutoConfigureMockMvc
class MainControllerTest {
  @Autowired private MockMvc mockMvc;

  @MockBean CustomerRepository customerRepository;

  @Test
  void contextLoads() throws Exception {
    Mockito.when(customerRepository.findAll())
        .thenReturn(List.of(new Customer(1, "Zahid"), new Customer(2, "Arif")));

    mockMvc
        .perform(get("/"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string(containsString("Zahid")));
  }
}
