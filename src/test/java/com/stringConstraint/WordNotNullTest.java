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
class WordNotNullTest {

    private static Validator validator;

    @BeforeAll
    public static void setupValidatorInstance() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    public void shouldReturnViolationsSizeEqualOneIfNotNullStringIsNull() {
        //given
        WordNotNull wordNotNull = new WordNotNull();
        wordNotNull.setNotNullString(null);
        //when
        Set<ConstraintViolation<WordNotNull>> violations = validator.validate(wordNotNull);
        //then
        assertEquals(1, violations.size());
    }

    @Test
    public void shouldReturnViolationsSizeEqualZeroIfNotNullStringIsEmpty() {
        //given
        WordNotNull wordNotNull = new WordNotNull();
        wordNotNull.setNotNullString("");
        //when
        Set<ConstraintViolation<WordNotNull>> violations = validator.validate(wordNotNull);
        //then
        assertEquals(0, violations.size());
    }

    @Test
    public void shouldReturnViolationsSizeEqualZeroIfNotNullStringIsBlank() {
        //given
        WordNotNull wordNotNull = new WordNotNull();
        wordNotNull.setNotNullString("       ");
        //when
        Set<ConstraintViolation<WordNotNull>> violations = validator.validate(wordNotNull);
        //then
        assertEquals(0, violations.size());
    }

    @Test
    public void shouldReturnViolationsSizeEqualZeroIfNotNullStringHasContent() {
        //given
        WordNotNull wordNotNull = new WordNotNull();
        wordNotNull.setNotNullString("some text");
        //when
        Set<ConstraintViolation<WordNotNull>> violations = validator.validate(wordNotNull);
        //then
        assertEquals(0, violations.size());
    }
}
