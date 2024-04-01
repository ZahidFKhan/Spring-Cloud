package com.zahidkhan.circuitbreaker.CircuitBreaker.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestConfigurations {
  @Bean
  RestTemplate restTemplate() {
    return new RestTemplate();
  }
}
