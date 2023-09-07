package com.app.controller;

import com.app.model.MyEvent;
import com.app.service.KafkaProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/kafka")
public class KafkaController {

    private final KafkaProducer kafkaProducer;

    @PostMapping
    public ResponseEntity<String> sentMessage(@RequestBody MyEvent myEvent) {
        kafkaProducer.send("test-topic", new MyEvent(myEvent.getKey()));
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("kafka", myEvent.getKey());
        return ResponseEntity
                .ok()
                .headers(httpHeaders)
                .body("Kafka event send");

//        return new ResponseEntity<>("Kafka event send", httpHeaders, HttpStatus.OK);
    }
}
