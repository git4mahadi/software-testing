package com.amigoscode.testing.model;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;


class PersonTest {

    @Test
    void itShouldName() {
        // Given
        PersonDTO personDTO = new PersonDTO("mahadi", 12, "2020-12-12");
        Person person = new ModelMapper().map(personDTO, Person.class);
        person.setDateOfBirth(LocalDateTime.of(LocalDate.parse(personDTO.getDateOfBirth()),
                LocalTime.now()));
        System.out.println(personDTO);
        System.out.println(person);
        // When

        // Then

    }
}