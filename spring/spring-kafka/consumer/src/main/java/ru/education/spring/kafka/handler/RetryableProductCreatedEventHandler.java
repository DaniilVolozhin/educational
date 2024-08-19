package ru.education.spring.kafka.handler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import ru.education.spring.kafka.event.ProductCreatedEvent;
import ru.education.spring.kafka.exception.NonRetryableException;
import ru.education.spring.kafka.exception.RetryableException;

@Slf4j
@Component
@KafkaListener(topics = "product-created-events-topic"/*, groupId = "product-created-events-topic"*/)
@RequiredArgsConstructor
public class RetryableProductCreatedEventHandler {

  private final RestTemplate restTemplate;

  @KafkaHandler
  public void handle(ProductCreatedEvent productCreatedEvent) {
    log.info("Received event: {}", productCreatedEvent.getTitle());

    String url = "http://localhost:8990/response/200";

    try {
      ResponseEntity<String> response =
          restTemplate.exchange(url, HttpMethod.GET, null, String.class);

      if (response.getStatusCode().value() == HttpStatus.OK.value()) {
        log.info("Received response: {}", response.getBody());
      }

    } catch (ResourceAccessException e) {
      log.error(e.getMessage());
      throw new RetryableException(e);
    } catch (Exception e) {
      log.error(e.getMessage());
      throw new NonRetryableException(e);
    }
  }

  //  Non Retryable
//  @KafkaHandler
//  public void handle(ProductCreatedEvent productCreatedEvent) {
//    if (true) {
//      throw new NonRetryableException("Non retryable exception");
//    }
//    log.info("Received event: {}", productCreatedEvent.getTitle());
//  }
}
