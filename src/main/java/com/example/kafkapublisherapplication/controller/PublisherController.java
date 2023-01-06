package com.example.kafkapublisherapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PublisherController {

    @Autowired
    private KafkaTemplate<String ,Object> kafkaTemplate;

    private String topic ="enggadda";

    @GetMapping("/getMessage/{name}")

    public String get(@PathVariable String name ){
        kafkaTemplate.send(topic,"Hi " +name +"Welcome to EnggAdda") ;
        return "Data is published by publisher ";
    }
}
