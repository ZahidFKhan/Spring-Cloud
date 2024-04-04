package com.zahid.cloud.config.client.controller;

import com.zahid.cloud.config.client.config.Config;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
  private final Config config;

  public MyController(Config config) {
    this.config = config;
  }

  @GetMapping
  String returnValue() {
    return config.getSay();
  }
}
