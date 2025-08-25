package com.espark.adarsh.service;

import com.espark.adarsh.entity.Person;
import com.espark.adarsh.exception.PersonNotFoundException;
import com.espark.adarsh.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Slf4j
@Service
public class PersonService {

    private PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Tool(name = "get_all_persons", description = "get all persons data in the system")
    public List<Person> getAllPerson () {
        List<Person> personList = new LinkedList<>();
        this.personRepository.findAll().forEach(person -> personList.add(person));
        return personList;
    }

    @Tool(name = "get_person_by_id", description = "get person  data by id")
    public Person getPersonByPersonId (Long id) {
        return this.personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException("Person  not found"));
    }

    @Tool(name = "create_person", description = "create new person data in the system")
    public Person createPerson (Person person) {
        return this.personRepository.save(person);
    }

    @Tool(name = "update_person", description = "update person  data by id and person  data")
    public Person updatePerson (Long id, Person person) {
        return this.personRepository.save(person);
    }

    @Tool(name = "remove_person_by_person_id", description = "delete person  data for id")
    public Person removePersonByPersonId (Long id) {
        Person employee = this.personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException("Person  not found"));
        this.personRepository.deleteById(id);
        return employee;
    }
}

