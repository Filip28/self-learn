package com.app.selflearn.repository;

import com.app.selflearn.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    Optional<Person> findById(@Param("id") long id);

    @Query("SELECT p FROM Person p WHERE p.name = :name")
    Optional<Person> findByName(@Param("name") String name);


    @Query("SELECT p FROM Person p WHERE p.age >= :age ORDER BY p.surname")
    List<Person> findByAgeStartsWith(@Param("age") long age);
}
