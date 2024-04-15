package com.zahid.api.gateway.Apigateway.configurations;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;
import io.github.resilience4j.timelimiter.TimeLimiterRegistry;
import org.springframework.cloud.circuitbreaker.resilience4j.ReactiveResilience4JCircuitBreakerFactory;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JConfigBuilder;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JConfigurationProperties;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
public class Conf {
//  @Bean
//  public ReactiveResilience4JCircuitBreakerFactory reactiveResilience4JCircuitBreakerFactory(
//      CircuitBreakerRegistry circuitBreakerRegistry,
//      TimeLimiterRegistry timeLimiterRegistry,
//      Resilience4JConfigurationProperties resilence4jConf) {
//    ReactiveResilience4JCircuitBreakerFactory reactiveResilience4JCircuitBreakerFactory =
//        new ReactiveResilience4JCircuitBreakerFactory(
//            circuitBreakerRegistry, timeLimiterRegistry, resilence4jConf);
//
//    reactiveResilience4JCircuitBreakerFactory.configureCircuitBreakerRegistry(
//        circuitBreakerRegistry);
//    return reactiveResilience4JCircuitBreakerFactory;
//  }

  @Bean
  public Customizer<Resilience4JCircuitBreakerFactory> defaultCustomizer() {
    return factory -> factory.configureDefault(id -> new Resilience4JConfigBuilder(id)
            .timeLimiterConfig(TimeLimiterConfig.custom().timeoutDuration(Duration.ofSeconds(4)).build())
            .circuitBreakerConfig(CircuitBreakerConfig.ofDefaults())
            .build());
  }
}
