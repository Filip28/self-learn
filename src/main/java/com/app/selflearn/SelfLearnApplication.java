package com.app.selflearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SelfLearnApplication {

    public static void main(String[] args) {
        SpringApplication.run(SelfLearnApplication.class, args);
    }

}
