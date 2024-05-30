package ru.education.spring.kafka.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import ru.education.spring.kafka.event.ProductCreatedEvent;

@Slf4j
@Component
@KafkaListener(topics = "product-created-events-topic", properties = {"spring.json.value.default.type=ru.education.spring.kafka.event.ProductCreatedEvent"})
public class ProduceCreatedEventHandler {

  @KafkaHandler
  public void handle(@Payload ProductCreatedEvent productCreatedEvent) {
    log.info("Received event: {}", productCreatedEvent.getTitle());
  }

}
