package com.app.selflearn.controller;

import com.app.selflearn.repository.PersonRepository;
import com.app.selflearn.model.Gender;
import com.app.selflearn.model.Person;
import com.redis.testcontainers.RedisContainer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.shaded.com.github.dockerjava.core.MediaType;
import org.testcontainers.utility.DockerImageName;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Testcontainers
@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
class PersonControllerTest {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private MockMvc mockMvc;

    @Container
    @ServiceConnection
    private static final PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:15-alpine");

    @Container
    @ServiceConnection
    private static final RedisContainer redis = new RedisContainer(DockerImageName.parse("redis:6.2.6"));

    @BeforeEach
    void beforeAll() {
        personRepository.deleteAll();
        postgres.start();
        redis.start();
    }

    @AfterAll
    static void afterAll() {
        postgres.stop();
        redis.stop();
    }

    @Test
    void testPersonController() throws Exception{
        // given
        Person person = Person.builder()
                .name("John")
                .surname("Doe")
                .age(22)
                .height(1.84)
                .gender(Gender.MAN)
                .build();
        personRepository.save(person);

        // when + then
        mockMvc.perform(
                        get("/person/all").contentType(MediaType.APPLICATION_JSON.name())
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$.[0].name").value("John"))
                .andExpect(jsonPath("$.[0].surname").value("Doe"))
                .andExpect(jsonPath("$.[0].age").value(22))
                .andExpect(jsonPath("$.[0].height").value(1.84))
                .andExpect(jsonPath("$.[0].gender").value(Gender.MAN.name()))
                .andExpect(jsonPath("$.[0].addresses").doesNotExist());
    }

}