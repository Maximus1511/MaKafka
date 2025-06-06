package com.example.MaKafka.controller;

import com.example.MaKafka.kafka.JsonKafkaProducer;
import com.example.MaKafka.model.Dancer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/kafka")
public class JsonMessageController {

    private final JsonKafkaProducer jsonKafkaProducer;

    public JsonMessageController(JsonKafkaProducer jsonKafkaProducer) {
        this.jsonKafkaProducer = jsonKafkaProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody Dancer dancer) {
        jsonKafkaProducer.sendMessage(dancer);
        return ResponseEntity.ok("Json Dancer sent to kafka topic");
    }
}
