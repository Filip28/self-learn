package com.app.controller;

import com.app.model.MyEvent;
import com.app.service.KafkaProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/kafka")
public class KafkaController {

    private final KafkaProducer kafkaProducer;


    @GetMapping
    public String test() {
        return "test";
    }

    @PostMapping
    public String sentMessage(@RequestBody MyEvent myEvent) {
        kafkaProducer.send("test-topic", new MyEvent(myEvent.getKey()));
        return "Hello World!";
    }
}
