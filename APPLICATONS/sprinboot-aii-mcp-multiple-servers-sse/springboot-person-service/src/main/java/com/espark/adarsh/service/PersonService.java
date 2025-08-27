package com.espark.adarsh.service;

import com.espark.adarsh.entity.Person;
import com.espark.adarsh.exception.PersonNotFoundException;
import com.espark.adarsh.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

@Slf4j
@Service
public class PersonService {

    private PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Supplier<List<Person>> allPerson = () -> {
        List<Person> personList = new LinkedList<>();
        this.personRepository.findAll().forEach(person -> personList.add(person));
        return personList;
    };

    public Function<Long,Person> personByPersonId = (Long personId) -> {
        return this.personRepository.findById(personId)
                .orElseThrow(() -> new PersonNotFoundException("Person  not found"));
    };

    public Function<Person,Person> createPerson = (Person person) -> {
        return this.personRepository.save(person);
    };

    public BiFunction<Long,Person,Person> updatePerson =  (Long personId, Person person) -> {
        return this.personRepository.save(person);
    };

    public Function<Long,Person> removePersonByPersonId = (Long personId) -> {
        Person employee = this.personRepository.findById(personId)
                .orElseThrow(() -> new PersonNotFoundException("Person  not found"));
        this.personRepository.deleteById(personId);
        return employee;
    };
}

