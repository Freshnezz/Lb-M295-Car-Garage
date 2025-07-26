# M295 CarGarage – Backend Projekt mit Spring Boot

## Projektziel und Motivation

Im Rahmen des Moduls **M295 - Backendentwicklung** habe ich mich bewusst dafür entschieden, nicht mein bestehendes Frontend aus **Modul 294** zu verwenden. Stattdessen wollte ich die Herausforderung annehmen, **ein vollständiges Backend-Projekt von Grund auf selbst zu entwickeln**, ohne mich auf bereits bestehende Strukturen zu verlassen.

Das Ziel war es, ein realistisches, aber technisch gut umsetzbares Backend zu realisieren, das sich um die Verwaltung einer imaginären **Autogarage** kümmert. Dabei sollen CRUD-Funktionen für Fahrzeuge, Serviceeinträge und optional Rechnungen ermöglicht werden – ein Thema, das mich auch persönlich interessiert, da ich mich für Autos, Wartung und Technik begeistere.

---

## ⚙️ Technologien & Tools

* Java 21
* Spring Boot (REST API)
* Maven
* MySQL (via Docker Container)
* Docker Compose
* IntelliJ IDEA
* GitHub

---

## Projektstruktur

```plaintext
car-garage
├── src
│   └── main
│       ├── java
│       │   └── ch.wiss.car_garage
│       │       ├── controller
│       │       ├── model
│       │       ├── repository
│       │       └── service
│       └── resources
│           └── application.properties
├── docker-compose.yml
├── Dockerfile
├── pom.xml
└── README.md
```

---

## Funktionale Anforderungen

* Fahrzeuge erfassen, aktualisieren, löschen und auflisten
* Service-Einträge einem Fahrzeug zuweisen
* Datenbank-Anbindung via JPA/Hibernate
* Fehlerbehandlung bei ungültigen Eingaben (Validation)
* Automatisches Erstellen der Datenbanktabellen

---

## Meine Learnings und Erfahrungen

Dieses Projekt war für mich in vielerlei Hinsicht eine echte Lernreise:

### **Was ich gelernt habe:**

* Wie man ein Spring Boot Projekt sauber strukturiert
* Wie man REST-Controller, Services und Repositories trennt
* Wie man Entities mit Beziehungen modelliert
* Wie Docker & Docker Compose im Zusammenspiel mit Spring Boot funktionieren
* Wie man das Projekt so aufbaut, dass es auch für andere lauffähig ist

### **Womit ich zu kämpfen hatte:**

* IntelliJ hat bei mir keinen `src/test/java`-Ordner angezeigt – ich musste diesen manuell anlegen
* Docker hatte anfangs Build-Probleme, weil das `.jar` im falschen Pfad gesucht wurde
* Git push scheiterte mehrmals an Berechtigungen, Merge-Konflikten oder IntelliJ-Warnungen
* Ich war zeitweise extrem verwirrt von zu vielen parallelen Informationen (ADS lässt grüssen)

Aber am Ende habe ich durchgehalten – und es **läuft!**

---

## (Geplante) Tests

Die Unit Tests für die REST-Controller und Services wurden **noch nicht final implementiert**, sind aber geplant. Sie wären z.B. mit `@WebMvcTest` oder `@SpringBootTest` realisierbar.

Einige Stolpersteine:

* IntelliJ hat kein automatisches Testverzeichnis erstellt
* Der Testaufbau hätte zusätzliche Zeit gekostet, die ich lieber in ein funktionierendes Hauptsystem gesteckt habe

---

## Setup & Installation

### Voraussetzungen

* Java 21
* Docker Desktop installiert
* IntelliJ IDEA Community oder Ultimate

### Schritt-für-Schritt Anleitung (mit Docker Compose)

1. Repository klonen:

```bash
git clone https://github.com/Freshnezz/Lb-M295-Car-Garage.git
cd Lb-M295-Car-Garage
```

2. Spring Boot `.jar` erstellen:

```bash
./mvnw clean package
```

3. Docker-Container starten:

```bash
docker-compose up --build
```

4. Backend ist nun unter erreichbar:

```http
http://localhost:8080
```

### Zugangsdaten zur Datenbank (Docker Compose `db` Service)

* Host: `localhost`
* Port: `3306`
* DB: `cargarage`
* User: `root`
* Passwort: `Wiss2024`

Diese Daten sind im `docker-compose.yml` sowie `application.properties` definiert.

---

## Datenmodell (vereinfacht)

* `Car`

  * id (Long)
  * marke (String)
  * modell (String)
  * jahrgang (int)
  * liste von ServiceEntry

* `ServiceEntry`

  * id (Long)
  * beschreibung (String)
  * datum (LocalDate)
  * kosten (BigDecimal)
  * Referenz zu Car (ManyToOne)

---

## Abschluss & Reflexion

Ich habe bewusst ein eigenes, sauberes Backend gebaut, das auf Best Practices basiert und sich ohne externes Frontend bedienen lässt (z. B. mit Insomnia oder Postman). Das hat mir ermöglicht, **jede einzelne Komponente selbst zu erstellen, zu verstehen und anzupassen**.

Ich bin stolz, dass ich alles von der Datenbank bis zur REST-API mit Docker durchgezogen habe, auch wenn es Phasen gab, in denen ich dachte: "Was mache ich hier eigentlich?!" Aber genau da beginnt das echte Lernen.

---

## Kontakt

Falls jemand dieses Projekt anschauen, bewerten oder forken möchte:
GitHub: [https://github.com/Freshnezz/Lb-M295-Car-Garage](https://github.com/Freshnezz/Lb-M295-Car-Garage)

Danke fürs Lesen 🙏 – und danke an ChatGPT, der mich bei den schlimmsten Fehlern nie ausgelacht hat ^^

---

**Marc**, angehender Applikationsentwickler EFZ – Quereinsteiger mit Herz, Humor und Lerneifer.

---

> Hinweis: Das Projekt wurde vollständig selbst entwickelt und dokumentiert. Hilfe gab es punktuell durch ChatGPT und den super Unterricht von G. Laveder 
