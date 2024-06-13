package ru.education.spring.kafka.handler;

import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import ru.education.spring.kafka.event.ProductCreatedEvent;
import ru.education.spring.kafka.event.ProductDeletedEvent;

//@Component
@KafkaListener(topics = "product-created-events-topic")
public class MultipleProductCreatedEventHandler {
  /*
  * такая конструкция позволяет из одного топика читать разные объекты
  * и автоматически определять их в обработчик по типу объекта
  */

  @KafkaHandler
  public void handle(ProductCreatedEvent productCreatedEvent) {
  }

  @KafkaHandler
  public void handle(ProductDeletedEvent productCreatedEvent) {
  }

}
