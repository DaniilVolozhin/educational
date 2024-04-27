package ru.education.spring.kafka.config;

import java.util.Map;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {

  public final String topicName = "product-created-events-topic";

  @Bean
  public NewTopic createTopic() {
    return TopicBuilder
        .name(topicName)
        .partitions(3)
        .replicas(3)
        .configs(Map.of("min.insync.replicas", "2")) // 2 сервера должны быть синхронизированы с лидером, иначе ошибка
        .build();
  }

  public String getTopicName() {
    return topicName;
  }
}
