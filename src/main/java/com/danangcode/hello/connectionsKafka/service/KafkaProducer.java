package com.danangcode.hello.connectionsKafka.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    @Autowired
    private KafkaTemplate<String, Object> template;

    public void sendMessageToTopic(String message){
       System.out.println("Render service");
       CompletableFuture<SendResult<String, Object>> future = template.send("quickstart", message);
       future.whenComplete((result, ex) -> {
            if(ex == null){
                System.out.println("Send message=[" + message + ". with offset=[" + result.getRecordMetadata().offset() + "]");
            } else {
                System.out.println("Unable to send message=[" + message + "] due to :" + ex.getMessage());
            }
       });
    }
}
