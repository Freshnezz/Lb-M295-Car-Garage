package com.wiss.cargarage.controller;

import com.wiss.cargarage.model.Car;
import com.wiss.cargarage.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarRepository carRepository;

    @GetMapping
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @PostMapping
    public Car createCar(@RequestBody @Valid Car car) {
        return carRepository.save(car);
    }

    // PUT-Endpoint zum Aktualisieren eines Autos anhand der ID
    @PutMapping("/{id}")
    public ResponseEntity<Car> updateCar(
            @PathVariable int id,
            @RequestBody @Valid Car updatedCar) {

        // Suche nach dem bestehenden Auto in der Datenbank
        return carRepository.findById(id)
                .map(car -> {
                    // Setze die neuen Werte aus dem übergebenen Objekt
                    car.setBrand(updatedCar.getBrand());
                    car.setModel(updatedCar.getModel());
                    car.setYear(updatedCar.getYear());
                    car.setLicensePlate(updatedCar.getLicensePlate());

                    // Speichere das aktualisierte Auto
                    Car savedCar = carRepository.save(car);

                    // Rückgabe des aktualisierten Autos mit Status 200 OK
                    return ResponseEntity.ok(savedCar);
                })
                // Wenn Auto mit der ID nicht gefunden wurde → 404 Not Found
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    // DELETE /cars/{id} – Ein Auto anhand der ID löschen
    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable int id) {
        carRepository.deleteById(id);
    }

}

