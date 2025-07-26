package com.wiss.cargarage.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

@Entity
public class ServiceEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "Datum darf nicht leer sein")
    @PastOrPresent(message = "Datum darf nicht in der Zukunft liegen")
    private LocalDate serviceDate;

    @NotBlank(message = "Beschreibung darf nicht leer sein")
    private String description;

    @NotNull(message = "Kosten dürfen nicht leer sein")
    private Double cost;

    @ManyToOne
    @JoinColumn(name = "car_id", nullable = false)
    @JsonBackReference
    private Car car;

    public ServiceEntry() {}

    public ServiceEntry(LocalDate serviceDate, String description, Double cost, Car car) {
        this.serviceDate = serviceDate;
        this.description = description;
        this.cost = cost;
        this.car = car;
    }

    public ServiceEntry(LocalDate serviceDate, String description, Car car) {
    }

    public int getId() { return id; }

    public LocalDate getServiceDate() { return serviceDate; }

    public void setServiceDate(LocalDate serviceDate) { this.serviceDate = serviceDate; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public Double getCost() { return cost; }

    public void setCost(Double cost) { this.cost = cost; }

    public Car getCar() { return car; }

    public void setCar(Car car) { this.car = car; }
}
