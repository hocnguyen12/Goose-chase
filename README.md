[<img src="https://www.ensicaen.fr/wp-content/uploads/2017/02/LogoEnsicaen.gif" width="256" >](https://www.ensicaen.fr)

Jeu Oie Ensicaen
================

**Professeur Encadrant :** Anthony Roger

**Cheffe de projet :** Cécile LU

**Architecte :** Kevin Herman

**Release Manager :** Paul NGUYEN

**Developpeurs :** Maxime Jingeaux, Ely Seraidarian, Winnie Kamtchueng-Fodjo-Kouam, Cécile Lu, Paul Nguyen

## Description du projet

Ce projet contient un exemple d'une application graphique écrite en Java avec
la bibliothèque graphique JavaFX. Elle est basée sur le patron d'architecture
Modèle-Vue-Présentation.

Le projet est géré par le moteur de production 'gradle'.

La configuration du plateau et la répartition des cases se fait à partir d'un fichier JSON présent à l'emplacement src/resources/fr.ensicaen.ecole.genielogiciel (Important : toujours mettre "size" à 64).

**Version actuelle :** 
- Grille de 64 case sur laquelle se déplace un personnage en spirale
- 4 joueurs max
- Choix d'un parcours (prépa, DUT ou licence)
- Attribution aléatoire d'un trait de charactère (dilletant, brilliant ou assidu)

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
        │   │      ├── fr.ensicaen.genielogiciel.mvp/*.java
        │   │      ├── fr.ensicaen.genielogiciel.mvp.model/*.java
        │   │      ├── fr.ensicaen.genielogiciel.mvp.presenter/*.java
        │   │      └── fr.ensicaen.genielogiciel.mvp.view/*.java
        │   │
        │   └── resources
        │          ├── fr.ensicaen.genielogiciel.mvp/view/*.fxml
        │          ├── fr.ensicaen.genielogiciel.mvp/view/*.css
        │          └── fr.ensicaen.genielogiciel.mvp/MessageBundle.properties.properties
        ├── test
            ├── java
            │      └── fr.ensicaen.genielogiciel.mvp/*.java
            └── resources

## VIEW
todo : 

- [x] Pion se déplacant en spirale
- [x] Grille de 64 cases
- [ ] Modifier écran de login
- [ ] demander la langue (fr, en)
- [ ] prendre en compte le nombre de joueur
- [ ] pour chaque joueur qu'on veut créer, demander le nom et hard skill (prepa, DUT, licence)

- [ ] creer n pions de couleurs différentes (entre 1 et 4)

- [ ] créer une fonction 'à part' qui déplace les pions (appelée par le presenter)

- [ ] créer des zones de texte modifiable par des methodes: 
- Zone de statistiques : fonction qui affiche nom, niveau de competence , et case actuelle
- afficher le nom du joueur qui doit lancer les dés et lui demander d'appuyer sur le bouton
- zone qui affiche la valeurs des dés

## PRESENTER
todo :

*necessite les fonctions de VIEW.*

## MODEL 
todo :

- [x] créer les personnages avec hard-skill choisi et soft-skill aléatoire
- [ ] Ajouter les cases restantes 
- [x] Lire la configuration du plateau à partir d'un fichier JSON