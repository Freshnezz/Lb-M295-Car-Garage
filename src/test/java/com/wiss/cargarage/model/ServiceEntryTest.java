package com.wiss.cargarage.model;

import jakarta.validation.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class ServiceEntryTest {

    private Validator validator;

    @BeforeEach
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testValidServiceEntryShouldPass() {
        Car car = new Car("Tesla", "Model 3", 2022);
        ServiceEntry entry = new ServiceEntry(LocalDate.now(), "Wartung", car);

        Set<ConstraintViolation<ServiceEntry>> violations = validator.validate(entry);

        assertTrue(violations.isEmpty());
    }

    @Test
    public void testEmptyDescriptionShouldFail() {
        Car car = new Car("Audi", "A4", 2020);
        ServiceEntry entry = new ServiceEntry(LocalDate.now(), "", car);

        Set<ConstraintViolation<ServiceEntry>> violations = validator.validate(entry);

        assertFalse(violations.isEmpty());
        assertTrue(violations.stream().anyMatch(v -> v.getPropertyPath().toString().equals("description")));
    }

    @Test
    public void testFutureServiceDateShouldFail() {
        Car car = new Car("BMW", "M3", 2021);
        ServiceEntry entry = new ServiceEntry(LocalDate.now().plusDays(3), "Inspektion", car);

        Set<ConstraintViolation<ServiceEntry>> violations = validator.validate(entry);

        assertFalse(violations.isEmpty());
        assertTrue(violations.stream().anyMatch(v -> v.getPropertyPath().toString().equals("serviceDate")));
    }
}
