package com.zahid.api.gateway.Apigateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {
  @GetMapping(path = "/fallback")
  String fallbackResponse() {
    return "FALLBACK Response!";
  }
}
