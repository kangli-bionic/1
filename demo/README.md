# Inhalt:
Diese Ordner enthält ein "FizzBuzz" Programm. Das Programm besteht aus Front- und Backend. Frontend ist in ReactJS und Backend mit Java + Spring Boot geschrieben.

# Funktionsbeschreibung:
Nach dem Starten der Applikation, Eingabewerte in natürlichen Zahlen in die Inputbox eingeben. Die Ausgabe entspricht der FizzBuzz Logik:
- bei Zahlen teilbar durch 3 wird "Fizz" ausgegeben
- bei Zahlen teilbar durch 5 wird "Buzz" ausgegeben
- bei Zahlen teilbar durch 3 und 5 wird "Fizz Buzz" ausgegeben
- bei allen anderen Zahl wird der selbe Wert ausgegeben

Werte kleiner als 1, Buchstaben oder leere Werte (Null) werden vom Programm ignoriert.

Die Applikation ist gut zu bedienen auf Desktop, Tablet und Mobile und läuft auf allen modernen Browsern - inkl. IE11. ;)

# Tests:
## REST API
Tests für die REST API sind vorhanden und befinden sich im Ordner
`demo/src/test/java/de/interview/fizzbuzz/demo/controller/FizzBuzzControllerTest.java`

## Business Logik
Unit Tests für die Business Logik habe ich in JUnit mit TDD geschrieben
`demo/src/test/java/de/interview/fizzbuzz/demo/controller/BusinessLogicTest.java`

## End-to-End Test
E2E Tests habe ich mit cypress geschrieben:

Zum Ausführen der cypress UI
`npm run testE2E:open`

Zum Ausführen des cypress Tests im Terminal:
`npm run testE2E:run`

Der Ordner befindet sich in
`demo/app/cypress/integration`

# Stying:
Für das Styling der UI Elemente habe ich BEM (Block Element Modifier) eingesetzt

# Start
## Frontend: 

Initial bitte `npm install`. Danach:
`npm start`

## Backend:
Zum starten entweder über im IDE über die run configuration oder:
`./mvnw spring-boot:run`
