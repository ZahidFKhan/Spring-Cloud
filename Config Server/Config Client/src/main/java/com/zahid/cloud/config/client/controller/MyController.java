package com.zahid.cloud.config.client.controller;

import com.zahid.cloud.config.client.config.Config;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class MyController {
  private final Config config;

  @GetMapping
  String returnValue() {
    return config.getSay();
  }
}
