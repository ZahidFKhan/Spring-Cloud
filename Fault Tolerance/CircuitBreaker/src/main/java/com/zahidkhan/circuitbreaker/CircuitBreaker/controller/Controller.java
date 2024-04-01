package com.zahidkhan.circuitbreaker.CircuitBreaker.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(
    value = "circuit-breaker/",
    produces = {MediaType.APPLICATION_JSON_VALUE})
@RequiredArgsConstructor
public class Controller {
  private final RestTemplate restTemplate;
  private final CircuitBreakerFactory circuitBreakerFactory;
  boolean isServerDown = false;

  @GetMapping(value = "server-down")
  public void setServerDown()  {
    isServerDown = true;
  }
  @GetMapping(value = "server-up")
  public void setServerUp()  {
    isServerDown = false;
  }


  @GetMapping(value = "slow")
  public String returnSlowResponse() throws InterruptedException {
    if (isServerDown) {
      Thread.sleep(3000);
    }
    return "This is a slow response From Server S1.";
  }

  @GetMapping("without-fallback")
  public String getHomepage() {
    final String responseReceived =
        circuitBreakerFactory
            .create("circuit-breaker-without-fallback")
            .run(
                () -> restTemplate.getForObject("http://localhost:8080/circuit-breaker/slow", String.class),
                (exception) -> "Response From Circuit breaker.");
    return "Fast Server Response : " + responseReceived;
  }
}
