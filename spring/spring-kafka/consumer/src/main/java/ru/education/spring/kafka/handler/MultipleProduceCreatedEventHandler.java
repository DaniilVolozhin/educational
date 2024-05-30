//package ru.education.spring.kafka.handler;
//
//import org.springframework.kafka.annotation.KafkaHandler;
//import org.springframework.kafka.annotation.KafkaListener;
//
////@Component
//@KafkaListener(topics = "product-created-events-topic")
//public class MultipleProduceCreatedEventHandler {
//  /*
//  * такая конструкция позволяет из одного топика читать разные объекты
//  * и автоматически определять их в обработчик по типу объекта
//  */
//
//  @KafkaHandler
//  public void handle(ProductCreatedEvent productCreatedEvent) {
//  }
//
//  @KafkaHandler
//  public void handle(ProductDeletedEvent productCreatedEvent) {
//  }
//
//}
