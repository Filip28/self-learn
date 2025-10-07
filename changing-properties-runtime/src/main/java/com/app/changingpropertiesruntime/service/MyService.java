package com.app.changingpropertiesruntime.service;

import org.springframework.stereotype.Service;

@Service
public class MyService {

    private final String property;

    public MyService(String property) {
        this.property = property;
    }

    public String getProperty() {
        return property;
    }
}
