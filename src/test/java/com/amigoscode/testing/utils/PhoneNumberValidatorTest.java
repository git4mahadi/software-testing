package com.amigoscode.testing.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


import java.time.LocalDate;
import java.time.LocalTime;

import static org.assertj.core.api.Assertions.assertThat;

class PhoneNumberValidatorTest {

    private PhoneNumberValidator underTest;

    @BeforeEach
    void setUp() {
        underTest = new PhoneNumberValidator();
    }



    // when testing is drive to development is called TDD.
    @ParameterizedTest
    @CsvSource({
            "+447000000000, true",
            "44700000000000, false",
            "4470000000000, false"
    })
    void itShouldValidatePhoneNumberParam(String phoneNumber, Boolean expected ) {
        // Given
        // When
        boolean isValid = underTest.test(phoneNumber);

        System.out.println(LocalTime.MIN);
        // Then
        assertThat(isValid).isEqualTo(expected);
    }

    // when testing is drive to development is called TDD.
    @Test
    void itShouldValidatePhoneNumber() {
        // Given
        String phoneNumber = "+447000000000";

        // When
        boolean isValid = underTest.test(phoneNumber);

        // Then
        assertThat(isValid).isTrue();
    }


    @Test
    @DisplayName("Should fail when does not start with +")
    void itShouldValidatePhoneNumberWhenDoesNotStartWithPlus() {
        // Given
        String phoneNumber = "4470000000000";

        // When
        boolean isValid = underTest.test(phoneNumber);

        // Then
        assertThat(isValid).isFalse();
    }
}
