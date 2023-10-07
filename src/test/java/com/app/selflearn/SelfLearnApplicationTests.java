package com.app.selflearn;

import org.springframework.boot.SpringApplication;

public class SelfLearnApplicationTests {

    public static void main(String[] args) {
        SpringApplication
                .from(SelfLearnApplication::main)
                .with(TestContainerConfig.class)
                .run(args);
    }
}
