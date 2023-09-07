package com.app.service;

import com.app.model.MyEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafkaConsumer {

    @KafkaListener(topics = "test-topic")
    public void listen(MyEvent myEvent) {
        System.out.println(myEvent.toString());
    }
}
