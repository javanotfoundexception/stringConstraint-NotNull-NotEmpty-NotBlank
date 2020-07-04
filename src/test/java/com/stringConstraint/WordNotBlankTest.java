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
class WordNotBlankTest {

    private static Validator validator;

    @BeforeAll
    public static void setupValidatorInstance() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    public void shouldReturnViolationsSizeEqualOneIfNotBlankStringIsNull() {
        //given
        WordNotBlank wordNotBlank = new WordNotBlank();
        wordNotBlank.setNotBlankString(null);
        //when
        Set<ConstraintViolation<WordNotBlank>> violations = validator.validate(wordNotBlank);
        //then
        assertEquals(1, violations.size());
    }

    @Test
    public void shouldReturnViolationsSizeEqualOneIfNotBlankStringIsEmpty() {
        //given
        WordNotBlank wordNotBlank = new WordNotBlank();
        wordNotBlank.setNotBlankString("");
        //when
        Set<ConstraintViolation<WordNotBlank>> violations = validator.validate(wordNotBlank);
        //then
        assertEquals(1, violations.size());
    }

    @Test
    public void shouldReturnViolationsSizeEqualOneIfNoBlankStringIsBlank() {
        //given
        WordNotBlank wordNotBlank = new WordNotBlank();
        wordNotBlank.setNotBlankString("       ");
        //when
        Set<ConstraintViolation<WordNotBlank>> violations = validator.validate(wordNotBlank);
        //then
        assertEquals(1, violations.size());
    }

    @Test
    public void shouldReturnViolationsSizeEqualZeroIfNotBlankStringHasContent() {
        //given
        WordNotBlank wordNotBlank = new WordNotBlank();
        wordNotBlank.setNotBlankString("some text");
        //when
        Set<ConstraintViolation<WordNotBlank>> violations = validator.validate(wordNotBlank);
        //then
        assertEquals(0, violations.size());
    }
}
