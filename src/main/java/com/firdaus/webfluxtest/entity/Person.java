package com.firdaus.webfluxtest.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "person")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class Person implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "address")
    private String address;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
}
