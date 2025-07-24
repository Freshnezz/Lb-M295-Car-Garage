-- Beispiel-Auto 1
INSERT INTO car (id, brand, model, year, licensePlate)
VALUES (1, 'Toyota', 'Corolla', '2019', 'ZH123456');

-- Beispiel-Auto 2
INSERT INTO car (id, brand, model, year, licensePlate)
VALUES (2, 'BMW', '320i', '2021', 'SG987654');

-- Beispiel-Service-Einträge
INSERT INTO service_entry (id, service_date, description, car_id)
VALUES (1, '2024-06-01', 'Ölwechsel', 1);

INSERT INTO service_entry (id, service_date, description, car_id)
VALUES (2, '2024-07-01', 'Reifenwechsel', 1);

INSERT INTO service_entry (id, service_date, description, car_id)
VALUES (3, '2024-06-15', 'Bremsen prüfen', 2);

