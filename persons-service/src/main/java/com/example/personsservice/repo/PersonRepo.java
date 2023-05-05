package com.example.personsservice.repo;

import com.example.personsservice.domain.Person;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

@Repository
public class PersonRepo {

    private final Set<Person> persons = new HashSet<>();

    public void save(final Person person){
        persons.add(person);
    }

    public Person getPersonByUserName(final String username){
        return persons
            .stream()
            .filter(person -> Objects.equals(username, person.getName()))
            .findFirst()
            .orElseThrow(NoSuchElementException::new);
    }
}
