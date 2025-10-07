package com.app.changingpropertiesruntime.config;

import com.app.changingpropertiesruntime.service.MyService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class CustomConfig {

    @Bean
    @Scope(scopeName = "prototype")
    public MyService myService(@Value("${custom.property:default}") String property) {
        return new MyService(property);
    }
}
