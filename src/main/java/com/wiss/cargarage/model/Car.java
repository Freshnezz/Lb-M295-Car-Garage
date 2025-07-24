package com.wiss.cargarage.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Brand darf nicht leer sein")
    @Size(min = 2, max = 50, message = "Brand muss zwischen 2 und 50 Zeichen lang sein")
    private String brand;

    @NotBlank(message = "Model darf nicht leer sein")
    @Size(min = 1, max = 50, message = "Model muss zwischen 1 und 50 Zeichen lang sein")
    private String model;

    @Min(value = 1886, message = "Jahr muss gültig sein (z. B. 2020)") // frühestes Automobiljahr :)
    private int year;

    @NotBlank(message = "Kennzeichen darf nicht leer sein")
    private String licensePlate;

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<ServiceEntry> serviceEntries = new ArrayList<>();

    // Standard-Konstruktor (wichtig für JPA)
    public Car() {
    }

    // Konstruktor mit Parametern
    public Car(String brand, String model, int year, String licensePlate) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.licensePlate = licensePlate;
    }

    // Getter und Setter
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    public String getLicensePlate() { return licensePlate; }
    public void setLicensePlate(String licensePlate) { this.licensePlate = licensePlate; }

    public List<ServiceEntry> getServiceEntries() { return serviceEntries; }
    public void setServiceEntries(List<ServiceEntry> serviceEntries) { this.serviceEntries = serviceEntries; }
}
