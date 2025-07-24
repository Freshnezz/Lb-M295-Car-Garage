# M295 Abschlussprojekt – Car-Garage (Spring Boot)

## Inhaltsverzeichnis

1. [Projektbeschreibung](#projektbeschreibung)
2. [Zielsetzung](#zielsetzung)
3. [Technologien & Tools](#technologien--tools)
4. [Projektstruktur](#projektstruktur)
5. [Installation & Ausführung](#installation--ausführung)
6. [Zugangsdaten & Datenbank](#zugangsdaten--datenbank)
7. [Fehlerbehebung & Troubleshooting](#fehlerbehebung--troubleshooting)
8. [Reflexion & Learnings](#reflexion--learnings)
9. [GitHub](#github)

---

## Projektbeschreibung

Dieses Backend-Projekt wurde im Rahmen des Moduls M295 an der WISS Zürich im Sommer 2025 umgesetzt. Ziel war es, ein vollständiges Spring Boot Backend mit Docker und MySQL zu bauen, das alle CRUD-Funktionen für eine fiktive Car-Garage verwaltet. Es handelt sich um mein Abschlussprojekt in diesem Modul.

Das Projekt enthält zwei Haupt-Entities: `Car` und `ServiceEntry`. Es wurden Repositories, Controller und REST-Endpunkte erstellt, die alle mit Insomnia testbar sind.

---

## Zielsetzung

Ich wollte mit diesem Projekt beweisen, dass ich in der Lage bin, ein vollständiges Backend aufzubauen – inklusive:

* Verbindung zur MySQL-Datenbank via Docker
* Endpunkte zur Datenverarbeitung (CRUD)
* Validierung von Eingaben (Bean Validation)
* Dokumentation & Versionsverwaltung über GitHub

Ziel war es ausserdem, praktische Erfahrung mit Fehlersuche, Docker, Spring Boot und Testtools zu sammeln.

---

## Technologien & Tools

* **Java 21**
* **Spring Boot** (Starter Web, Data JPA, Validation)
* **MySQL 8 (Docker)**
* **Docker Desktop + docker-compose**
* **IntelliJ IDEA**
* **Git + GitHub**
* **Insomnia (zum Testen der REST-Endpunkte)**

---

## Projektstruktur

```bash
car-garage/
├── src/
│   ├── main/
│   │   ├── java/com/wiss/cargarage
│   │   │   ├── controller
│   │   │   ├── model
│   │   │   └── repository
│   │   └── resources/
│   │       └── application.properties / data.sql
│   └── test/
│       └── java/... (Tests folgen noch)
├── Dockerfile
├── docker-compose.yml
├── pom.xml
└── README.md
```

---

## Installation & Ausführung

> Voraussetzung: Docker Desktop installiert, Java 21, Git, Maven (lokal oder per IntelliJ)

### Schritt 1 – Projekt klonen

```bash
git clone https://github.com/Freshnezz/Lb-M295-Car-Garage.git
cd Lb-M295-Car-Garage
```

### Schritt 2 – Backend bauen

```bash
./mvnw clean package
```

Dadurch wird im Verzeichnis `target/` eine `.jar`-Datei erstellt.

### Schritt 3 – Docker starten

```bash
docker-compose up --build
```

Dadurch wird:

* eine MySQL-DB mit Datenbank `cargarage` gestartet
* die Spring Boot Anwendung im Container gebaut und gestartet

### Schritt 4 – Anwendung testen

Öffne z. B. Insomnia oder Postman und sende Anfragen an:

```
http://localhost:8080/api/cars
http://localhost:8080/api/service-entries
```

---

## Zugangsdaten & Datenbank

* **MySQL-Host:** `localhost` (Docker-intern: `db`)
* **Port:** `3307` (gemappt auf `3306` im Container)
* **Datenbank:** `cargarage`
* **Benutzer:** `root`
* **Passwort:** `Wiss2024`

In `application.properties` (bzw. in `docker-compose.yml`) sind alle Verbindungsdaten hinterlegt. Auch SQL-Initialdaten sind in `data.sql` gespeichert.

---

## Fehlerbehebung / Troubleshooting

Während der Entwicklung sind mir folgende Fehler passiert:

### ❌ Fehler: `COPY target/*.jar app.jar` → "no such file or directory"

✅ Lösung: Vor dem Docker-Build muss mit `mvn clean package` das `.jar` gebaut werden.

### ❌ Testpaket fehlt / kein `src/test/java`

✅ Lösung: Ordnerstruktur manuell erstellen oder über IntelliJ Rechtsklick → New Directory → `src/test/java`.

### ❌ `Cannot resolve symbol 'Mock'`, `@Test` etc.

✅ Lösung: Fehlende Abhängigkeiten in `pom.xml` ergänzt (`junit`, `mockito`, `spring-boot-starter-test`).

### ❌ Docker-Datenbank läuft, aber App findet sie nicht

✅ Lösung: Ports & Umgebungsvariablen in `docker-compose.yml` korrekt setzen:

```yml
SPRING_DATASOURCE_URL: jdbc:mysql://db:3306/cargarage
```

---

## Reflexion & Learnings

Dieses Projekt war für mich sehr intensiv. Am Anfang hatte ich keine Ahnung, wie man ein Backend mit Spring Boot strukturiert oder was Docker genau macht. Ich habe Stück für Stück gelernt, was Controller, Repositories und Entities machen, wie man mit Datenbanken verbindet, und wie man mit Tools wie Insomnia oder GitHub arbeitet.

Ich hatte oft Probleme, z. B. mit dem Datenbankzugriff oder fehlenden Abhängigkeiten. Aber ich habe jedes Mal dazugelernt – auch durch gezielte Hilfe von ChatGPT.

**Meine Learnings:**

* Wie man ein Spring Boot Projekt von Grund auf aufbaut
* Wie Docker und docker-compose funktionieren
* Wie man eine MySQL-Datenbank einrichtet und verbindet
* Wie man sauber dokumentiert und testet
* Wie wichtig Versionskontrolle mit GitHub ist

Ich bin stolz, dass ich das Projekt erfolgreich umsetzen konnte.

---

## GitHub

Das gesamte Projekt ist öffentlich verfügbar unter:

🔗 **[GitHub Repo](https://github.com/Freshnezz/Lb-M295-Car-Garage)**

Bitte beachte: Änderungen im Code erfordern einen erneuten Build:

```bash
./mvnw clean package
```

und dann ein erneutes:

```bash
docker-compose up --build
```

---

*Stand: 24. Juli 2025 – erstellt von Marc, Applikationsentwickler in Ausbildung (WISS Zürich)*
