package com.zahid.discovery.server1.server1.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@AllArgsConstructor
public class MainController {
  private final RestTemplate restTemplate;
  @GetMapping
  String homepage() {
    return restTemplate.getForObject("http://SERVICE2/hello",String.class);
  }
}
