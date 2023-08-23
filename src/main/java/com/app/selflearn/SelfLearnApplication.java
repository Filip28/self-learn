package com.app.selflearn;

import com.app.selflearn.database.PersonRepository;
import com.app.selflearn.model.Gender;
import com.app.selflearn.model.Person;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SelfLearnApplication implements CommandLineRunner {

	private final PersonRepository personRepository;

	public SelfLearnApplication(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(SelfLearnApplication.class, args);
	}

	@Override
	public void run(String... args) {
//		List<Person> persons = List.of(
//				new Person(1,"John", "Doe", 19, 1.85, Gender.MAN),
//				new Person(2,"Adrianna", "Dickie", 39, 1.45, Gender.WOMAN),
//				new Person(3,"Flower", "Noone", 24, 1.74, Gender.OTHER)
//		);
//		personRepository.saveAll(persons);
		personRepository.save(new Person(1L,"John", "Doe", 19, 1.85, Gender.MAN));
		personRepository.save(new Person(2L,"Adrianna", "Dickie", 39, 1.45, Gender.WOMAN));
		personRepository.save(new Person(3L,"Flower", "Noone", 24, 1.74, Gender.OTHER));
	}
}
