package com.wiss.cargarage;

import com.wiss.cargarage.model.Car;
import com.wiss.cargarage.repository.CarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CarGarageApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarGarageApplication.class, args);
    }
    @Bean
    CommandLineRunner initDatabase(CarRepository carRepository) {
        return args -> {
            // Testauto 1
            Car car1 = new Car();
            car1.setBrand("Hyundai");
            car1.setModel("i30 N");
            car1.setYear(2021);
            car1.setLicensePlate("ZH 123456");
            carRepository.save(car1);

            // Testauto 2
            Car car2 = new Car();
            car2.setBrand("Audi");
            car2.setModel("SQ5");
            car2.setYear(2020);
            car2.setLicensePlate("ZH 654321");
            carRepository.save(car2);

            System.out.println("🚗 Testdaten erfolgreich eingefügt!");
        };
    }

}
