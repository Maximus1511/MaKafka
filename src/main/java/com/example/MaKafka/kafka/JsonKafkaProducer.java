package com.example.MaKafka.kafka;

import com.example.MaKafka.model.Dancer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaProducer.class);

    @Value("${spring.kafka.topics.json-topic}")
    private String jsonTopicName;
    private final KafkaTemplate<String, Dancer> kafkaTemplate;

    public JsonKafkaProducer(KafkaTemplate<String, Dancer> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(Dancer data) {
        LOGGER.info(String.format("Message sent -> %s", data.toString()));
        Message<Dancer> message = MessageBuilder
                .withPayload(data)
                .setHeader(KafkaHeaders.TOPIC, jsonTopicName)
                .build();
        kafkaTemplate.send(message);
    }
}
