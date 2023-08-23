package com.app.selflearn.controller;

import com.app.selflearn.model.Person;
import com.app.selflearn.model.PersonDto;
import com.app.selflearn.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;

    @GetMapping("/all")
    public List<Person> getPerson() {
        return personService.getPersons();
    }

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public Person getPerson(@RequestParam String name) {
        return personService.getPersonByName(name);
    }

    @GetMapping("/adults")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Person> getAdultPeople() {
        return personService.getAdultPeople();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Person createPerson(@RequestBody PersonDto personDto) {
        return null;
    }

}