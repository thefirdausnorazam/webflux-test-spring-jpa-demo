package com.firdaus.webfluxtest.service.impl;

import com.firdaus.webfluxtest.entity.Person;
import com.firdaus.webfluxtest.model.PersonForm;
import com.firdaus.webfluxtest.repository.PersonRepository;
import com.firdaus.webfluxtest.service.AsycJdbcService;
import com.firdaus.webfluxtest.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Component
public class PersonServiceImpl extends AsycJdbcService implements PersonService {

    @Autowired
    public PersonServiceImpl(Scheduler jdbcScheduler,
                             PersonRepository personRepository) {
        setScheduler(jdbcScheduler);
        this.personRepository = personRepository;
    }

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    private PersonRepository personRepository;

    @Override
    public Mono<Person> findById(long id) {
        return asyncMono(() -> personRepository.findById(id).orElse(null));
    }

    @Override
    public Mono<List<Person>> findAll() {
        return asyncMono(() -> personRepository.findAll());
    }

    @Override
    public Mono<Person> save(PersonForm personForm) {
        return asyncMono(() -> {
            Person person = new Person();
            person.setName(personForm.getName());
            person.setAddress(personForm.getAddress());
            person.setDateOfBirth(LocalDate.parse(personForm.getDateOfBirth()));
            person.setAge((int) person.getDateOfBirth().until(LocalDate.now(), ChronoUnit.YEARS));
            return personRepository.save(person);
        });
    }
}
