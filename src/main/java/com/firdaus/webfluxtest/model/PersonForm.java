package com.firdaus.webfluxtest.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @Getter @Setter
public class PersonForm {

    private String name;

    private String address;

    private String dateOfBirth;
}
