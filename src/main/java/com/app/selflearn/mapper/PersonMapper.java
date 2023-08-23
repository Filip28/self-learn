package com.app.selflearn.mapper;

import com.app.selflearn.model.Gender;
import com.app.selflearn.model.Person;
import com.app.selflearn.model.PersonDto;

public interface PersonMapper {

    static Person toPerson(PersonDto personDto) {
        return Person
                .builder()
                .name(personDto.name())
                .surname(personDto.surname())
                .age(personDto.age())
                .height(personDto.height())
                .gender(Gender.valueOf(personDto.gender().toUpperCase()))
                .build();
    }

    static PersonDto toPersonDto(Person person) {
        return PersonDto
                .builder()
                .name(person.getName())
                .surname(person.getSurname())
                .age(person.getAge())
                .height(person.getHeight())
                .gender(person.getGender().toString())
                .build();
    }
}
