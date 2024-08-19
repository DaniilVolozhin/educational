package ru.education.spring.kafka.config.kafka;

import lombok.AllArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.*;
import org.springframework.kafka.listener.DeadLetterPublishingRecoverer;
import org.springframework.kafka.listener.DefaultErrorHandler;
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.util.backoff.FixedBackOff;
import ru.education.spring.kafka.exception.NonRetryableException;
import ru.education.spring.kafka.exception.RetryableException;

import java.util.HashMap;
import java.util.Map;

//@Configuration
@AllArgsConstructor
public class RetryableKafkaConfig {

  private final Environment environment;

  @Bean
  public ConsumerFactory<String, Object> consumerFactory() {
    Map<String, Object> configMap = new HashMap<>();
    configMap.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
        environment.getProperty("spring.kafka.consumer.bootstrap-servers"));

    configMap.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
    configMap.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, ErrorHandlingDeserializer.class);
    configMap.put(ErrorHandlingDeserializer.VALUE_DESERIALIZER_CLASS, JsonDeserializer.class);

    configMap.put(JsonDeserializer.TRUSTED_PACKAGES,
        environment.getProperty("spring.kafka.consumer.properties.spring.json.trusted.packages"));
    configMap.put(ConsumerConfig.GROUP_ID_CONFIG,
        environment.getProperty("spring.kafka.consumer.group-id"));

    return new DefaultKafkaConsumerFactory<>(configMap);
  }

  @Bean
  public ConcurrentKafkaListenerContainerFactory<String, Object> kafkaListenerContainerFactory(
      ConsumerFactory<String, Object> consumerFactory,
      KafkaTemplate<String, Object> kafkaTemplate) {
    DefaultErrorHandler errorHandler = new DefaultErrorHandler(
        new DeadLetterPublishingRecoverer(kafkaTemplate),
        new FixedBackOff(3000, 3)
    );
    errorHandler.addNotRetryableExceptions(NonRetryableException.class);
    errorHandler.addRetryableExceptions(RetryableException.class);

    ConcurrentKafkaListenerContainerFactory<String, Object> factory =
        new ConcurrentKafkaListenerContainerFactory<>();
    factory.setConsumerFactory(consumerFactory);
    factory.setCommonErrorHandler(errorHandler);

    return factory;
  }

  @Bean
  public KafkaTemplate<String, Object> kafkaTemplate(
      ProducerFactory<String, Object> producerFactory
  ) {
    return new KafkaTemplate<>(producerFactory);
  }

  @Bean
  public ProducerFactory<String, Object> producerFactory() {
    Map<String, Object> configMap = new HashMap<>();
    configMap.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
        environment.getProperty("spring.kafka.consumer.bootstrap-servers"));
    configMap.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
    configMap.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

    return new DefaultKafkaProducerFactory<>(configMap);
  }
}
