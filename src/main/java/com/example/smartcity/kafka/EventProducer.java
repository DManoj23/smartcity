package com.example.smartcity.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class EventProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public EventProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publishEvent(String topic, String message) {
        try {
            kafkaTemplate.send(topic, message);
            System.out.println("Event published to Kafka topic [" + topic + "]: " + message);
        } catch (Exception e) {
            System.out.println("Kafka not running, event log instead: " + message);
        }
    }
}
