package com.danangcode.hello.connectionsKafka.controller;

import org.springframework.web.bind.annotation.RestController;

import com.danangcode.hello.connectionsKafka.service.KafkaProducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/producer-app")
public class EventController {
    
    @Autowired
    private KafkaProducer publisher;

    @GetMapping("/publish/{message}")
    public ResponseEntity<?> publishMessage(@PathVariable String message){
        try{
            System.out.println("Render here data message: " + message);
            publisher.sendMessageToTopic(message);
            System.out.println("Render 2");
            return ResponseEntity.ok("Message published successfully");
        } catch(Exception e){
            System.out.println("something error" + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
