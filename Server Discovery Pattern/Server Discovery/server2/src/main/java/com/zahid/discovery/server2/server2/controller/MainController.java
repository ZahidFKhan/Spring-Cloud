package com.zahid.discovery.server2.server2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/hello")
public class MainController {
  @GetMapping
  String homepage() {
    return "<h2>HOMEPAGE SERVER2- hellow.</h2>";
  }
}
