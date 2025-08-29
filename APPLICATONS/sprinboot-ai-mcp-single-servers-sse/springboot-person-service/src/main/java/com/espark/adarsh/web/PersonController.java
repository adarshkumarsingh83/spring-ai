package com.espark.adarsh.web;

import com.espark.adarsh.entity.Person;
import com.espark.adarsh.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class PersonController {

    private PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/persons")
    public List<Person> getAllPerson() {
        return this.personService.allPerson.get();
    }

    @GetMapping("/person/{id}")
    public Person getPersonByPersonId(@PathVariable("id") Long personId) {
        return this.personService.personByPersonId.apply(personId);
    }

    @PostMapping("/person")
    public Person createPerson(@RequestBody Person person) {
        return this.personService.createPerson.apply(person);
    }

    @PutMapping("/person/{id}")
    public Person updatePerson(@PathVariable("id") Long personId, @RequestBody Person person) {
        return this.personService.updatePerson.apply(personId, person);
    }

    @DeleteMapping("/person/{id}")
    public Person removePersonByPersonId(@PathVariable("id") Long personId) {
        return this.personService.removePersonByPersonId.apply(personId);
    }
}

