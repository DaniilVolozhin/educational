package ru.education.spring.kafka.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/response")
public class MockController {

  @GetMapping("/200")
  public ResponseEntity<String> mock200() {
    return ResponseEntity.ok("200");
  }

  @GetMapping("/500")
  public ResponseEntity<String> mock500() {
    return ResponseEntity.status(500).body("500");
  }
}
