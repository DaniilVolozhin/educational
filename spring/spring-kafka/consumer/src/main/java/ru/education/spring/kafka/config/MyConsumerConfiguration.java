package ru.education.spring.kafka.config;

import java.util.HashMap;
import java.util.Map;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import ru.education.spring.kafka.event.ProductCreatedEvent;

//@Configuration
public class MyConsumerConfiguration {
  @Value("${spring.kafka.consumer.bootstrap-servers}")
  private String bootstrapServers;
  @Value("${spring.kafka.consumer.key-deserializer}")
  private String keyDeserializer;
  @Value("${spring.kafka.consumer.value-deserializer}")
  private String valueDeserializer;
  @Value("${spring.kafka.consumer.group-id}")
  private String groupId;


  @Bean
  public ConsumerFactory<String, ProductCreatedEvent> consumerFactory() {

    // Creating a Map of string-object pairs
    Map<String, Object> config = new HashMap<>();

    // Adding the Configuration
    config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
    config.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
    config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, keyDeserializer);
    config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, valueDeserializer);

    return new DefaultKafkaConsumerFactory<>(
        config,
        new StringDeserializer(),
        new JsonDeserializer<>(ProductCreatedEvent.class)
    );
  }
  @Bean
  public ConcurrentKafkaListenerContainerFactory<String, ProductCreatedEvent> kafkaListenerContainerFactory(
      ConsumerFactory<String, ProductCreatedEvent> consumerFactory
  ) {
    var factory = new ConcurrentKafkaListenerContainerFactory<String, ProductCreatedEvent>();
    factory.setConsumerFactory(consumerFactory);
    return factory;
  }
}
