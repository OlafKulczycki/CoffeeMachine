# Coffee Machine Simulation

Dieses Repository enthält eine einfache Simulation einer Kaffeemaschine, die als Programmieraufgabe zu Lernzwecken entwickelt wurde. Es dient als Teil meines Portfolios, um meine Fähigkeiten in Kotlin und Softwareentwicklung zu demonstrieren.

## Projektbeschreibung

Die Kaffeemaschine bietet folgende Funktionen:
- **Kaffee kaufen**: Der Benutzer kann zwischen Espresso, Latte und Cappuccino wählen. Die Ressourcen der Maschine werden entsprechend angepasst.
- **Maschine auffüllen**: Der Benutzer kann Wasser, Milch, Kaffeebohnen und Becher hinzufügen.
- **Geld entnehmen**: Der Benutzer kann das gesamte Geld aus der Maschine entnehmen.
- **Status anzeigen**: Zeigt die aktuellen Ressourcen der Maschine an.
- **Beenden**: Beendet das Programm.

Das Projekt wurde mit **Kotlin** entwickelt und enthält Unit-Tests, um die Funktionalität der Kaffeemaschine zu überprüfen.

## Features

- **Interaktive Konsole**: Der Benutzer kann Aktionen über die Konsole ausführen.
- **Ressourcenmanagement**: Die Maschine überprüft, ob genügend Ressourcen für die Zubereitung von Kaffee vorhanden sind.
- **Unit-Tests**: Sicherstellung der korrekten Funktionalität durch automatisierte Tests.

## Verwendete Technologien

- **Programmiersprache**: Kotlin
- **Build-Tool**: Gradle
- **Test-Framework**: JUnit 5

## Projektstruktur

```
├── src
│   ├── main
│   │   └── kotlin
│   │       └── CoffeeMachine.kt   # Hauptklasse der Kaffeemaschine
│   │       └── Main.kt            # Einstiegspunkt des Programms
│   ├── test
│   │   └── kotlin
│   │       └── CoffeeMachineTest.kt  # Unit-Tests für die Kaffeemaschine
├── .gitignore
├── build.gradle
└── README.md
```

## Installation und Ausführung

1. **Repository klonen**:
   ```bash
   git clone <repository-url>
   cd <repository-name>
   ```

2. **Projekt bauen**:
   ```bash
   ./gradlew build
   ```

3. **Programm ausführen**:
   ```bash
   ./gradlew run
   ```

4. **Tests ausführen**:
   ```bash
   ./gradlew test
   ```

## Beispielausgabe

```
Write action (buy, fill, take, remaining, exit):
buy
What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:
1
I have enough resources, making you a coffee!

Write action (buy, fill, take, remaining, exit):
remaining
The coffee machine has:
150 ml of water
540 ml of milk
104 g of coffee beans
8 disposable cups
$554 of money
```

## Lernziele

- Beherrschen der Grundlagen von Kotlin.
- Implementierung von Klassen und Funktionen.
- Umgang mit Ressourcenmanagement und Benutzerinteraktionen.
- Schreiben und Ausführen von Unit-Tests.

## Lizenz

Dieses Projekt ist für persönliche Lernzwecke gedacht und unterliegt keiner spezifischen Lizenz.