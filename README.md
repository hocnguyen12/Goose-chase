[<img src="https://www.ensicaen.fr/wp-content/uploads/2017/02/LogoEnsicaen.gif" width="256" >](https://www.ensicaen.fr)

Jeu Oie Ensicaen
================

**Professeur Encadrant :** Anthony Roger

**Cheffe de projet :** Cécile LU

**Architecte :** Kevin Herman

**Release Manager :** Paul NGUYEN

**Developpeurs :** Maxime Jingeaux, Ely Seraidarian, Winnie Kamtchueng-Fodjo-Kouam, Cécile Lu, Paul Nguyen, Kevin Herman

## Description du projet

Ce projet contient un exemple d'une application graphique écrite en Java avec
la bibliothèque graphique JavaFX. Elle est basée sur le patron d'architecture
Modèle-Vue-Présentation.

Le projet est géré par le moteur de production 'gradle'.

La configuration du plateau et la répartition des cases se fait à partir d'un fichier JSON présent à l'emplacement src/resources/fr.ensicaen.ecole.genielogiciel.

**Version actuelle :** 
- Grille de 64 case sur laquelle se déplace les personnages en spirale
- 2 joueurs max
- Choix d'un parcours (prépa, DUT ou licence)
- Attribution aléatoire d'un trait de charactère (dilletant, brilliant ou assidu)
- 16 cases à effets

## Organisation du projet

Le projet a la structure suivante :

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

## VIEW
todo : 

- [x] Pion se déplacant en spirale
- [x] Grille de 64 cases
- [x] Modifier écran de login
- [x] demander la langue (fr, en)
- [x] prendre en compte le nombre de joueur
- [x] pour chaque joueur qu'on veut créer, demander le nom et hard skill (prepa, DUT, licence)

- [x] creer n pions de couleurs différentes (entre 1 et 4)

- [x] créer une fonction 'à part' qui déplace les pions (appelée par le presenter)

- [x] créer des zones de texte modifiable par des methodes: 
- Zone de statistiques : fonction qui affiche nom, niveau de competence , et case actuelle
- afficher le nom du joueur qui doit lancer les dés et lui demander d'appuyer sur le bouton
- zone qui affiche la valeurs des dés

## PRESENTER
todo :

*necessite les fonctions de VIEW.*

## MODEL 
todo :

- [x] créer les personnages avec hard-skill choisi et soft-skill aléatoire
- [x] Ajouter les cases restantes testées
- [x] Lire la configuration du plateau à partir d'un fichier JSON