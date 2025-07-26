package com.wiss.cargarage.model;

import jakarta.validation.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class CarTest {

    private Validator validator;

    @BeforeEach
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testValidCarShouldPass() {
        Car car = new Car("Ford", "Focus", 2018);

        Set<ConstraintViolation<Car>> violations = validator.validate(car);

        assertTrue(violations.isEmpty());
    }

    @Test
    public void testEmptyMakeShouldFail() {
        Car car = new Car("", "Golf", 2015);

        Set<ConstraintViolation<Car>> violations = validator.validate(car);

        assertFalse(violations.isEmpty());
        assertTrue(violations.stream().anyMatch(v -> v.getPropertyPath().toString().equals("make")));
    }
}
