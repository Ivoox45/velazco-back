package com.velazco.velazco_back.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
  @GetMapping("/")
  public String hello() {
    return "Hello world from Java Spring Boot!";
  }
}
