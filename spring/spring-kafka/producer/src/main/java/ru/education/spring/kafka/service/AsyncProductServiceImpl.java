package ru.education.spring.kafka.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import ru.education.spring.kafka.config.KafkaConfig;
import ru.education.spring.kafka.dto.CreateProductDTO;
import ru.education.spring.kafka.event.ProductCreatedEvent;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Slf4j
@Service
public class AsyncProductServiceImpl implements ProductService {

  private final KafkaTemplate<String, ProductCreatedEvent> kafkaTemplate;
  private final KafkaConfig kafkaConfig;

  public AsyncProductServiceImpl(
      KafkaTemplate<String, ProductCreatedEvent> kafkaTemplate,
      KafkaConfig kafkaConfig
  ) {
    this.kafkaTemplate = kafkaTemplate;
    this.kafkaConfig = kafkaConfig;
  }

  @Override
  public String createProduct(CreateProductDTO createProductDTO)
      throws ExecutionException, InterruptedException {
    String productId = UUID.randomUUID().toString();
    ProductCreatedEvent productCreatedEvent = new ProductCreatedEvent(
        productId,
        createProductDTO.getTitle(),
        createProductDTO.getPrice(),
        createProductDTO.getQuantity()
    );

//    async send
    produceAsync(productId, productCreatedEvent);

    log.info("Return: {}", productId);

    return productId;
  }

  /*
   * работает быстрее синхронного, когда не важно подтвержение отправки
   */
  private void produceAsync(String productId, ProductCreatedEvent productCreatedEvent) {
    CompletableFuture<SendResult<String, ProductCreatedEvent>> future =
        kafkaTemplate.send(kafkaConfig.getTopicName(), productId, productCreatedEvent);

    future.whenComplete((result, exception) -> {
      if (exception != null) {
        log.error("Failed to send message: {}", exception.getMessage());
      } else {
        log.info("Message sent successfully: {}", result.getRecordMetadata());
      }
    });
  }
}
