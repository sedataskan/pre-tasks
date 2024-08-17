package org.example.kafkaconsumer.listener;

import org.springframework.kafka.annotation.KafkaListener;

public class MessageConsumer {

    @KafkaListener(topics = "car")
    public void listen(String message) {
        System.out.println(message);
    }
}
