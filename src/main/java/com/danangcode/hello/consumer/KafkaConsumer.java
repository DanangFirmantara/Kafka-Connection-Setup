package com.danangcode.hello.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {
    
    @KafkaListener(topics = "quickstart", groupId = "group-1")
    public void consume(String message){
        System.out.println(">>> message = " + message);
    }
}
