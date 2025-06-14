package com.example.MaKafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Value("${spring.kafka.topics.first-topic}")
    private String topicName;

    @Value("${spring.kafka.topics.json-topic}")
    private String jsonTopicName;

    @Bean
    public NewTopic createTopic() {
        return TopicBuilder
                .name(topicName)
                .build();
    }

    @Bean
    public NewTopic createJsonTopic() {
        return TopicBuilder
                .name(jsonTopicName)
                .build();
    }
}
