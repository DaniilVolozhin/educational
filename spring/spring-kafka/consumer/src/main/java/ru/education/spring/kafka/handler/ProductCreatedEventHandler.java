package ru.education.spring.kafka.handler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.client.RestTemplate;
import ru.education.spring.kafka.event.ProductCreatedEvent;

@Slf4j
//@Component
@KafkaListener(topics = "product-created-events-topic")
@RequiredArgsConstructor
public class ProductCreatedEventHandler {

  private final RestTemplate restTemplate;

  @KafkaHandler
  public void handle(ProductCreatedEvent productCreatedEvent) {
    log.info("Received event: {}", productCreatedEvent.getTitle());
  }
}
