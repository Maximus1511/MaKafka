package com.example.MaKafka.kafka;

import com.example.MaKafka.model.Dancer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaConsumer.class);

    @KafkaListener(topics = "kryzJsonTopic", groupId = "kryzGroup")
    public void consume(Dancer dancer){
        LOGGER.info(String.format("Dancer received -> %s", dancer.toString()));
    }
}
