package fr.ensicaen.ecole.genielogiciel.winnie;
import fr.ensicaen.ecole.genielogiciel.model.AbstractFactoryEtudiant;
import fr.ensicaen.ecole.genielogiciel.model.ConcreteFactoryLicence;

public class Main {
    public static void main(String[] args) {
        Case _case1= new Case(1,0,0,0);
        Case _case2= new Case(2,0,0,0);
        Case _case3= new Case(3,0,0,0);
        Case _case4= new Case(4,0,0,0);
        Case _case5= new Case(5,0,0,0);
        Case _case6= new Case(6,0,0,0);
        Case _case7= new Case(7,0,0,1);

        AbstractFactoryEtudiant eleve= new ConcreteFactoryLicence();
        Plateau _plateau= new Plateau(eleve);


        _plateau.ajouter(_case1);
        _plateau.ajouter(_case2);
        _plateau.ajouter(_case3);
        _plateau.ajouter(_case4);
        _plateau.ajouter(_case5);
        _plateau.ajouter(_case6);
        _plateau.ajouter(_case7);
        _plateau.startGame();


    }
}