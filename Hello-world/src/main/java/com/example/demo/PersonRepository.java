package com.example.demo;

import org.springframework.data.repository.Repository;
import java.util.Optional;

public interface PersonRepository extends Repository<Person, Long> {

    Person save(Person person);

    Optional<Person> findById(Long id);
}
