package com.wiss.cargarage.repository;

import com.wiss.cargarage.model.Car;
import com.wiss.cargarage.model.ServiceEntry;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class ServiceEntryRepositoryTest {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private ServiceEntryRepository serviceEntryRepository;

    @Test
    public void testSaveServiceEntry() {
        Car car = new Car("Ford", "Focus", 2016);
        car = carRepository.save(car);

        ServiceEntry entry = new ServiceEntry(LocalDate.now(), "Reifenwechsel", car);
        ServiceEntry savedEntry = serviceEntryRepository.save(entry);

        assertNotNull(savedEntry.getId());
        assertEquals("Reifenwechsel", savedEntry.getDescription());
        assertEquals(car.getId(), savedEntry.getCar().getId());
    }
}
