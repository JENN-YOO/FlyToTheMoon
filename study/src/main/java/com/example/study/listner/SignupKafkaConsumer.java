package com.example.study.listner;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class SignupKafkaConsumer {

    @KafkaListener(topics = "user-email", groupId = "study-group", containerFactory =  "kafkaListnerContainerFactory")
    public void consume(ConsumerRecord<String, String> consumerRecord) {
        System.out.println("Kafka consumer received: " + consumerRecord.toString());
    }
}
