package fr.ensicaen.ecole.genielogiciel.winnie;
import fr.ensicaen.ecole.genielogiciel.model.AbstractFactoryEtudiant;

import java.util.ArrayList;
import java.util.ListIterator;

public class Plateau {
    private ArrayList<Case> _cases= new ArrayList<>();
    private AbstractFactoryEtudiant _student;
    private ListIterator<Case> iterator;
    private int _number_of_square;

    public void ajouter(Case unecase){
        _cases.add(unecase);
        _number_of_square ++;
    }
    public Plateau(AbstractFactoryEtudiant student){
        _student= student;
        _number_of_square= 0;
    }

    public ArrayList<Case> get_cases() {
        return _cases;
    }
    public void startGame(){
        createIterator();
        _student.effet(1, iterator);
        while(_student.getCurrent().get_end()){
            _student.effet(1, iterator);
        }
        System.out.println("Jeu terminé");

    }
    public void createIterator(){
        iterator= get_cases().listIterator();
    }

}
