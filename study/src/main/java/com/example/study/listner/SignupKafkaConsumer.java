package com.example.study.listner;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class SignupKafkaConsumer {

    @KafkaListener(topics = "user-email", groupId = "study-group", containerFactory = "kafkaListenerContainerFactory")
    public void consume(ConsumerRecord<String, String> consumerRecord) {//3
        System.out.println("Kafka에서 메시지 수신: " + consumerRecord.toString());
        //emailService.sendConfirmationEmail(email);
    }
}
