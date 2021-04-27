package com.amigoscode.testing.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PhoneNumberValidatorTest {

    private PhoneNumberValidator underTest;

    @BeforeEach
    void setUp() {
        underTest = new PhoneNumberValidator();
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
