package com.example.MaKafka.kafka;

import org.apache.kafka.clients.consumer.Consumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @Value("${spring.kafka.topics.first-topic}")
    private String topicName;

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);


    @KafkaListener(topics = "kryzhFirstTopic", groupId = "kryzGroup")
    public void consume(String message){
        LOGGER.info(String.format("Message received -> %s", message));
    }
}
