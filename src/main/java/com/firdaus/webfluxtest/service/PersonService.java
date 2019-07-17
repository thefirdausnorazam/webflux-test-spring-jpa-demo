package com.firdaus.webfluxtest.service;

import com.firdaus.webfluxtest.entity.Person;
import com.firdaus.webfluxtest.model.PersonForm;
import reactor.core.publisher.Mono;

import java.util.List;

public interface PersonService {

    Mono<Person> findById(long id);

    Mono<List<Person>> findAll();

    Mono<Person> save(PersonForm personForm);
}
