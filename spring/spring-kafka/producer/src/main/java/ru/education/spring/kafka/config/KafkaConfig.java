package ru.education.spring.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import ru.education.spring.kafka.event.ProductCreatedEvent;

import java.util.Map;

@Configuration
public class KafkaConfig {

  @Value("${spring.kafka.producer.bootstrap-servers}")
  private String bootstrapServers;
  @Value("${spring.kafka.producer.key-serializer}")
  private String keySerializer;
  @Value("${spring.kafka.producer.value-serializer}")
  private String valueSerializer;
  @Value("${spring.kafka.producer.acks}")
  private String acks;
  @Value("${spring.kafka.producer.properties.delivery.timeout.ms}")
  private String deliveryTimout;
  @Value("${spring.kafka.producer.properties.linger.ms}")
  private String linger;
  @Value("${spring.kafka.producer.properties.request.timeout.ms}")
  private String requestTimeout;
  @Value("${spring.kafka.producer.properties.enable.idempotence}")
  private String idempotence;
  @Value("${spring.kafka.producer.properties.max.in.flight.requests.per.connection}")
  private String maxInFlightRequest;

  public final String topicName = "product-created-events-topic";

  //  создали свою фабрику для своего java конфиг
  @Bean
  public ProducerFactory<String, ProductCreatedEvent> producerFactory() {
    return new DefaultKafkaProducerFactory<>(producerConfigs());
  }

  //  создали свой template для productCreatedEvent dto со своим java конфигом
  @Bean
  public KafkaTemplate<String, ProductCreatedEvent> kafkaTemplate(
      ProducerFactory<String, ProductCreatedEvent> producerFactory
  ) {
    return new KafkaTemplate<String, ProductCreatedEvent>(producerFactory);
  }

  @Bean
  public NewTopic createTopic() {
    return TopicBuilder
        .name(topicName)
        .partitions(3)
        .replicas(3)
        .configs(Map.of("min.insync.replicas",
            "2")) // 2 сервера должны быть синхронизированы с лидером, иначе ошибка
        .build();
  }

  public Map<String, Object> producerConfigs() {
    return Map.of(
        ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers,
        ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, keySerializer,
        ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, valueSerializer,
        ProducerConfig.ACKS_CONFIG, acks,
        ProducerConfig.DELIVERY_TIMEOUT_MS_CONFIG, deliveryTimout,
        ProducerConfig.LINGER_MS_CONFIG, linger,
        ProducerConfig.REQUEST_TIMEOUT_MS_CONFIG, requestTimeout,
        ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG, idempotence,
        ProducerConfig.MAX_IN_FLIGHT_REQUESTS_PER_CONNECTION, maxInFlightRequest
    );
  }

  public String getTopicName() {
    return topicName;
  }
}
