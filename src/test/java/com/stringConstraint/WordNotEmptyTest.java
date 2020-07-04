package com.stringConstraint;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class WordNotEmptyTest {

    private static Validator validator;

    @BeforeAll
    public static void setupValidatorInstance() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    public void shouldReturnViolationsSizeEqualOneIfNotEmptyStringIsNull() {
        //given
        WordNotEmpty wordNotEmpty = new WordNotEmpty();
        wordNotEmpty.setNotEmptyString(null);
        //when
        Set<ConstraintViolation<WordNotEmpty>> violations = validator.validate(wordNotEmpty);
        //then
        assertEquals(1, violations.size());
    }

    @Test
    public void shouldReturnViolationsSizeEqualOneIfNotEmptyStringIsEmpty() {
        //given
        WordNotEmpty wordNotEmpty = new WordNotEmpty();
        wordNotEmpty.setNotEmptyString("");
        //when
        Set<ConstraintViolation<WordNotEmpty>> violations = validator.validate(wordNotEmpty);
        //then
        assertEquals(1, violations.size());
    }

    @Test
    public void shouldReturnViolationsSizeEqualZeroIfNotEmptyStringIsBlank() {
        //given
        WordNotEmpty wordNotEmpty = new WordNotEmpty();
        wordNotEmpty.setNotEmptyString("       ");
        //when
        Set<ConstraintViolation<WordNotEmpty>> violations = validator.validate(wordNotEmpty);
        //then
        assertEquals(0, violations.size());
    }

    @Test
    public void shouldReturnViolationsSizeEqualZeroIfNotEmptyStringHasContent() {
        //given
        WordNotEmpty wordNotEmpty = new WordNotEmpty();
        wordNotEmpty.setNotEmptyString("some text");
        //when
        Set<ConstraintViolation<WordNotEmpty>> violations = validator.validate(wordNotEmpty);
        //then
        assertEquals(0, violations.size());
    }
}
