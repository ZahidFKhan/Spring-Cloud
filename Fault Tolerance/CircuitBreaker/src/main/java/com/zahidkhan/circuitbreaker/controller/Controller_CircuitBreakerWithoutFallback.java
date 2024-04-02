package com.zahidkhan.circuitbreaker.controller;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
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
public class Controller_CircuitBreakerWithoutFallback {
  private final RestTemplate restTemplate;
  private final CircuitBreakerFactory circuitBreakerFactory;
  boolean isServerDown = false;

  @GetMapping(value = "server-down")
  public void setServerDown() {
    isServerDown = true;
  }

  @GetMapping(value = "server-up")
  public void setServerUp() {
    isServerDown = false;
  }

  @GetMapping("without-fallback")
  public String getHomepage() {
    final String responseReceived =
        circuitBreakerFactory
            .create("circuit-breaker-without-fallback")
            .run(
                () ->
                    restTemplate.getForObject(
                        "http://localhost:8080/circuit-breaker/slow-s1", String.class),
                (exception) -> "Error Response From Circuit breaker.");
    return "Error Message Response : " + responseReceived;
  }

  @GetMapping("with-fallback")
  public String getHomepageFromFallback() {
    final String responseReceived =
        circuitBreakerFactory
            .create("circuit-breaker-with-fallback")
            .run(
                () ->
                    restTemplate.getForObject(
                        "http://localhost:8080/circuit-breaker/slow-s1", String.class),
                (exception) ->
                    restTemplate.getForObject(
                        "http://localhost:8080/circuit-breaker/slow-s2", String.class));
    return "Fallback Server Response : " + responseReceived;
  }

  @GetMapping(value = "slow-s1")
  @SneakyThrows
  public String returnSlowResponse() {
    if (isServerDown) {
      Thread.sleep(3000);
    }
    return "This is a slow response From Server S1.";
  }

  @GetMapping(value = "slow-s2")
  @SneakyThrows
  public String returnSlowResponseFromServer2() {
    return "This is a slow response From Server S2.";
  }
}
