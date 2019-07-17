package com.firdaus.webfluxtest.controller;

import com.firdaus.webfluxtest.entity.Person;
import com.firdaus.webfluxtest.model.PersonForm;
import com.firdaus.webfluxtest.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PersonService personService;

    @GetMapping("/get/{id}")
    public Mono<Person> findPersonById(@PathVariable long id){
        return personService.findById(id);
    }

    @GetMapping("/getAll")
    public Mono<List<Person>> findAllPerson(){
        return personService.findAll();
    }

    @PostMapping(value = "save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Person> savePerson(@RequestBody PersonForm personForm){
        return personService.save(personForm);
    }
}
