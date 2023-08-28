package com.app.selflearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestSelfLearnApplication {

//	@Bean
//	@ServiceConnection
//	PostgreSQLContainer<?> postgresContainer() {
//		return new PostgreSQLContainer<>(DockerImageName.parse("postgres:latest"));
//	}

	public static void main(String[] args) {
		SpringApplication.from(SelfLearnApplication::main).with(TestSelfLearnApplication.class).run(args);
	}

}
