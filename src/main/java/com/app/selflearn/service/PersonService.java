package com.app.selflearn.service;

import com.app.selflearn.database.PersonRepository;
import com.app.selflearn.exception.ResourceNotFoundException;
import com.app.selflearn.mapper.PersonMapper;
import com.app.selflearn.model.Person;
import com.app.selflearn.model.PersonDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;


    public List<Person> getPersons() {
        return personRepository.findAll();
    }

    public Person getPersonByName(String name) {
        return personRepository.findByName(name)
//                .orElseThrow(() -> new ResourceNotFoundException("Not found!"));
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Person not found!")); // from spring 5 new
        // option to throw exception using that class
    }

    public List<Person> getAdultPeople() {
        return personRepository.findAdults();
    }

    public Person create(PersonDto personDto) {
        return Optional.ofNullable(personDto)
                .map(p -> {
                    Person person = PersonMapper.toPerson(personDto);
                    return personRepository.save(person);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Person can't be null while requesting to create it!"));
    }
}
