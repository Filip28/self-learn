package com.app.selflearn.service;

import com.app.selflearn.database.PersonRepository;
import com.app.selflearn.exception.ResourceNotFoundException;
import com.app.selflearn.mapper.PersonMapper;
import com.app.selflearn.model.Gender;
import com.app.selflearn.model.Person;
import com.app.selflearn.model.PersonDto;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;


    @Cacheable(value = "persons", key = "'getPersons'")
    public List<Person> getPersons() {
        return personRepository.findAll();
    }
    @Cacheable(cacheNames = "person", key = "#name")
    public Person getPersonByName(String name) {
        return personRepository.findByName(name)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Person not found!")); // from spring 5 new
        // option to throw exception using that class
    }
    @Cacheable(value = "persons")
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

    @CachePut(value = "person")
    public Person updatePerson(long id, PersonDto personDto){
        return Optional.ofNullable(personDto)
                .map(p -> {
                    Person updateEmployee = personRepository.findById(id)
                            .orElseThrow(() -> new ResourceNotFoundException(String.format("Person with id: [%d] not found!", id)));

                    updateEmployee.setAge(personDto.age());
                    updateEmployee.setName(personDto.name());
                    updateEmployee.setSurname(personDto.surname());
                    updateEmployee.setHeight(personDto.height());
                    updateEmployee.setGender(Gender.valueOf(personDto.gender()));
                    return personRepository.save(updateEmployee);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Person can't be null while requesting to update it!"));
    }
}
