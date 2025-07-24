package com.wiss.cargarage.repository;

import com.wiss.cargarage.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

// Dieses Interface stellt alle Standard-Datenbankoperationen für Car bereit
public interface CarRepository extends JpaRepository<Car, Integer> {
}
