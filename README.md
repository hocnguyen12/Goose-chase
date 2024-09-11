[<img src="https://www.ensicaen.fr/wp-content/uploads/2017/02/LogoEnsicaen.gif" width="256" >](https://www.ensicaen.fr)

Ensicaen Goose Chase Game
================
**Lab supervisor :** Anthony Roger

**Project Lead :** Cécile LU

**Architect :** Kevin Herman

**Release Manager:** Paul NGUYEN

**Software Developpers :** Maxime Jingeaux, Ely Seraidarian, Winnie Kamtchueng-Fodjo-Kouam, Cécile Lu, Paul Nguyen, Kevin Herman

## Running the game

In the project file :

Linux: 
```bash
./gradlew clean jar
java -jar build/libs/jeu-oie-ensicaen-0.0.2.jar
```
Windows:
```powershell
.\gradlew clean jar
java -jar .\build\libs\jeu-oie-ensicaen-0.0.2.jar
```

## Project description
This project contains an example of a graphics application written in Java using the JavaFX graphics library. 
It is based on the Model-View-Presentation architecture pattern.

The project is managed by the 'gradle' production engine.

The configuration of the board and the distribution of squares is based on a JSON file at src/resources/fr.ensicaen.ecole.genielogiciel.

**Current version:** 
- Choice of language: French or English
- 64-square grid on which characters move in spirals
- 2 players max
- Choice of education background course (prépa, DUT or licence)
- Random assignment of a character trait (dilletant, brilliant or assiduous)
- 16 effect boxes
- 2 boards available: basic configuration (representing as closely as possible the career path of an ENSICAEN student) and random configuration (with more unpredictable box placement).
- Calculation of players' salaries at the end of the game.

The project documentation, including report and presentation (in french), is included in the ```/other``` folder.

## Project Organization

The project has the following structure:
```
    .
    │
    ├── build.gradle, settings.gradle, gradle.properties
    │
    ├── .gitlab-ci.yml
    │
    └── src
        ├── main
        │   ├── java
        │   │      ├── fr.ensicaen.genielogiciel.json/*.java
        │   │      ├── fr.ensicaen.genielogiciel.model/*.java
        │   │      |          └── fr.ensicaen.genielogiciel.model.character/*.java
        │   │      |          └── fr.ensicaen.genielogiciel.model.square/*.java
        │   │      ├── fr.ensicaen.genielogiciel.presenter/*.java
        │   │      └── fr.ensicaen.genielogiciel.view/*.java
        │   │
        │   └── resources
        │          ├── fr.ensicaen.genielogiciel.view/*.fxml
        │          ├── fr.ensicaen.genielogiciel.view/*.css
        │          ├── fr.ensicaen.genielogiciel.board_config_1.json
        │          ├── fr.ensicaen.genielogiciel.board_config_2.json
        │          └── fr.ensicaen.genielogiciel/MessageBundle.properties.properties
        └── test
            ├── java
            │      └── fr.ensicaen.genielogiciel.model/*.java
            └── resources
```

## TASKS TO PERFORM
### VIEW

- [x] Pawn moving in a spiral
- [x] Grid of 64 squares
- [x] Modify login screen
- [x] request language (fr, en)
- [x] take into account number of players
- [x] for each player you want to create, ask for name and hard skill (prepa, DUT, licence)

- [x] create n pieces of different colors (between 1 and 4)

- [x] create a 'separate' function that moves the pieces (called by the presenter)

- [x] create text zones that can be modified by methods: 
- Statistics zone: function to display name, skill level and current square
- display the name of the player who is to roll the dice and ask him/her to press the button
- zone displays dice values

### PRESENT
todo :
*requires VIEW functions.

### MODEL 
todo :

- [x] create characters with chosen hard-skill and random soft-skill
- [x] Add remaining tested squares
- [x] Read set configuration from JSON file
