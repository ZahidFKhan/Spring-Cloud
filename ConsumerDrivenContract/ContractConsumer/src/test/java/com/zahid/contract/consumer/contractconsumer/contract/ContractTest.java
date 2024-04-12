package com.zahid.contract.consumer.contractconsumer.contract;

import static java.util.Objects.requireNonNull;
import static org.assertj.core.api.Assertions.*;

import com.zahid.contract.consumer.contractconsumer.entities.Customer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@ExtendWith(SpringExtension.class)
@AutoConfigureJsonTesters
@AutoConfigureStubRunner(
    stubsMode = StubRunnerProperties.StubsMode.LOCAL,
    ids = "com.zahid.contract:ConsumerDrivenContract-Producer:+:8082")
public class ContractTest {

  @Test
  void test() {
    final RestTemplate restTemplate = new RestTemplate();

    final ResponseEntity<Customer> response =
        restTemplate.getForEntity("http://localhost:8082/", Customer.class);
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    System.out.println(response.getBody());
    assertThat(requireNonNull(response.getBody()));
  }
}
