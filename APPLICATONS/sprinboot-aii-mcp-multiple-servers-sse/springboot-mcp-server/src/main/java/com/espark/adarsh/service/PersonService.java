package com.espark.adarsh.service;

import com.espark.adarsh.config.ServiceConfig;
import com.espark.adarsh.entity.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@Service
public class PersonService {

    private ServiceConfig serviceConfig;
    private RestTemplate restTemplate;

    public PersonService(RestTemplate restTemplate, ServiceConfig serviceConfig) {
        this.restTemplate = restTemplate;
        this.serviceConfig = serviceConfig;
    }

    @Tool(name = "get_all_persons", description = "get all persons data in the system")
    public List<Person> getAllPerson () {
        try {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.set("Content-Type", "application/json");
            httpHeaders.set("Accept", "application/json");
            String url = serviceConfig.getService().get("person-service").getUrl() + "/persons";
            HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
            ResponseEntity<List<Person>> responseEntity = restTemplate.exchange(url, HttpMethod.GET, entity, new ParameterizedTypeReference<List<Person>>() {
            });
            return responseEntity.getBody();
        } catch (Exception e) {
            log.error("Exception occurred while fetching all persons: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Tool(name = "get_person_by_id", description = "get person  data by id")
    public Person getPersonByPersonId (Long personId) {
        try {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.set("Content-Type", "application/json");
            httpHeaders.set("Accept", "application/json");
            String  url = serviceConfig.getService().get("person-service").getUrl() +"/person/" + personId;
            HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
            ResponseEntity<Person> responseEntity = restTemplate.exchange(url, HttpMethod.GET, entity, new ParameterizedTypeReference<Person>() {
            });
            return responseEntity.getBody();
        } catch (Exception e) {
            log.error("Exception occurred while fetching person with id {}: {}", personId, e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Tool(name = "create_person", description = "create new person data in the system")
    public Person createPerson (Person person) {
        try {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.set("Content-Type", "application/json");
            httpHeaders.set("Accept", "application/json");
            String url = serviceConfig.getService().get("person-service").getUrl() +"/person";
            HttpEntity<Person> entity = new HttpEntity<>(person, httpHeaders);
            ResponseEntity<Person> responseEntity = restTemplate.exchange(url, HttpMethod.POST, entity, new ParameterizedTypeReference<Person>() {
            });
            return responseEntity.getBody();
        } catch (Exception e) {
            log.error("Exception occurred while creating person: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Tool(name = "update_person", description = "update person  data by id and person  data")
    public Person updatePerson (Long personId, Person person) {
        try {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.set("Content-Type", "application/json");
            httpHeaders.set("Accept", "application/json");
            String url = serviceConfig.getService().get("person-service").getUrl() +"/person/" + personId;
            HttpEntity<Person> entity = new HttpEntity<>(person, httpHeaders);
            ResponseEntity<Person> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, entity, new ParameterizedTypeReference<Person>() {
            });
            return responseEntity.getBody();
        } catch (Exception e) {
            log.error("Exception occurred while updating person with id {}: {}", personId, e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Tool(name = "remove_person_by_person_id", description = "delete person  data for id")
    public Person removePersonByPersonId (Long personId) {
        try {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.set("Content-Type", "application/json");
            httpHeaders.set("Accept", "application/json");
            String url = serviceConfig.getService().get("person-service").getUrl() +"/person/" + personId;
            HttpEntity<Person> entity = new HttpEntity<>(httpHeaders);
            ResponseEntity<Person> responseEntity = restTemplate.exchange(url, HttpMethod.DELETE, entity, new ParameterizedTypeReference<Person>() {
            });
            return responseEntity.getBody();
        } catch (Exception e) {
            log.error("Exception occurred while deleting person with id {}: {}", personId, e.getMessage());
            throw new RuntimeException(e);
        }
    }
}

