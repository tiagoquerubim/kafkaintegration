package com.kafkaintegration.kafkaintegration.controller;

import com.kafkaintegration.kafkaintegration.util.ResponseSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/message")
public class TestRestController extends ResponseSupport {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String msg) {
        kafkaTemplate.send("kafkaintegration", msg);
    }
    @GetMapping(path = "/sendmessage")
    public ResponseEntity<String> sendMessage() {
        sendMessage("testing");
        return ok("Message sent");
    }

    @KafkaListener(topics = "kafkaintegration", groupId = "foo")
    public void listenGroupFoo(String message) {
        System.out.println("Received Message in group foo: " + message);
    }
}
