package com.wiss.cargarage.controller;

import com.wiss.cargarage.model.Car;
import com.wiss.cargarage.model.ServiceEntry;
import com.wiss.cargarage.repository.CarRepository;
import com.wiss.cargarage.repository.ServiceEntryRepository;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

@RestController
@RequestMapping("/services")
public class ServiceEntryController {

    @Autowired
    private ServiceEntryRepository serviceEntryRepository;

    @Autowired
    private CarRepository carRepository;

    // GET /services – Alle Service-Einträge abrufen
    @GetMapping
    public List<ServiceEntry> getAllServiceEntries() {
        return serviceEntryRepository.findAll();
    }

    // ✅ GET /services/{id} – Ein bestimmter Eintrag per ID abrufen
    @GetMapping("/{id}")
    public ServiceEntry getServiceEntryById(@PathVariable int id) {
        return serviceEntryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Service-Eintrag mit ID " + id + " nicht gefunden"));
    }

    // DELETE /services/{id}
    @DeleteMapping("/{id}")
    public void deleteServiceEntry(@PathVariable int id) {
        serviceEntryRepository.deleteById(id);
    }

    // PUT /services/{id}
    @PutMapping("/{id}")
    public ServiceEntry updateServiceEntry(@PathVariable int id, @RequestBody ServiceEntryRequest request) {
        ServiceEntry existingEntry = serviceEntryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Service-Eintrag nicht gefunden"));

        Car car = carRepository.findById(request.getCarId())
                .orElseThrow(() -> new RuntimeException("Auto nicht gefunden"));

        existingEntry.setServiceDate(request.getServiceDate());
        existingEntry.setDescription(request.getDescription());
        existingEntry.setCar(car);

        return serviceEntryRepository.save(existingEntry);
    }

    // POST /services
    @PostMapping
    public ServiceEntry createServiceEntry(@RequestBody ServiceEntryRequest request) {
        Optional<Car> carOptional = carRepository.findById(request.getCarId());

        if (carOptional.isEmpty()) {
            throw new RuntimeException("Kein Auto mit ID " + request.getCarId() + " gefunden");
        }

        Car car = carOptional.get();
        ServiceEntry entry = new ServiceEntry(request.getServiceDate(), request.getDescription(), car);
        return serviceEntryRepository.save(entry);
    }

    // Hilfsklasse für POST & PUT Requests
    public static class ServiceEntryRequest {
        @NotNull(message = "Datum darf nicht leer sein")
        @PastOrPresent(message = "Datum darf nicht in der Zukunft liegen")
        private LocalDate serviceDate;

        @NotBlank(message = "Beschreibung darf nicht leer sein")
        private String description;

        @NotNull(message = "carId darf nicht leer sein")
        private Integer carId;

        public LocalDate getServiceDate() { return serviceDate; }
        public void setServiceDate(LocalDate serviceDate) { this.serviceDate = serviceDate; }

        public String getDescription() { return description; }
        public void setDescription(String description) { this.description = description; }

        public int getCarId() { return carId; }
        public void setCarId(int carId) { this.carId = carId; }
    }
}
