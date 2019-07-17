package com.firdaus.webfluxtest.repository;

import com.firdaus.webfluxtest.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
