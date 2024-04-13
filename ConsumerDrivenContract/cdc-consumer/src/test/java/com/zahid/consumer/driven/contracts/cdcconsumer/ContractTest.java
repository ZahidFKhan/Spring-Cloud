package com.zahid.consumer.driven.contracts.cdcconsumer;

import com.zahid.consumer.driven.contracts.cdcconsumer.entities.Customer;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerPort;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.client.match.MockRestRequestMatchers;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@ExtendWith(SpringExtension.class)
@AutoConfigureJsonTesters
@AutoConfigureMockMvc
@AutoConfigureStubRunner(
    stubsMode = StubRunnerProperties.StubsMode.LOCAL,
    ids = "com.zahid.consumer.driven.contracts:cdc-producer:+")
public class ContractTest {

  @Autowired private MockMvc mockMvc;

  @StubRunnerPort("cdc-producer")
  private int producerPort;

  @Test
  @SneakyThrows
  void test_() {
    RestTemplate restTemplate = new RestTemplate();
    ParameterizedTypeReference<Collection<Customer>> ptr = new ParameterizedTypeReference<>() {};
    final ResponseEntity<Collection<Customer>> exchange =
        restTemplate.exchange("http://localhost:" + producerPort + "/", HttpMethod.GET, null, ptr);

    assertTrue(exchange.getStatusCode().is2xxSuccessful());
    assertEquals(2, Objects.requireNonNull(exchange.getBody()).size());
    assertEquals(List.of(new Customer(1, "Zahid"), new Customer(2, "Arif")), exchange.getBody());
    assertNotEquals(List.of(new Customer(1, "Arif"), new Customer(2, "Zahid")), exchange.getBody());

  }
}
