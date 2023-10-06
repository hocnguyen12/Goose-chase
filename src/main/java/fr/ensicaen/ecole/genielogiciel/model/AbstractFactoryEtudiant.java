package fr.ensicaen.ecole.genielogiciel.model;
import fr.ensicaen.ecole.genielogiciel.winnie.Case;

import java.util.*;


public abstract class AbstractFactoryEtudiant {
    private Etudiant _etudiant;
    private int _competence;
    private Case current;
    private static int _attribut;
    public  abstract Diletante createDiletante();
    public abstract Assidu createAssidu();
    public abstract Brillant createBrillant();
    //public int lancerDe();

    public void deplacement(int value, ListIterator<Case> iterator){
        if(value>0){
            while(iterator.hasNext() && value >= 0){
                current= iterator.next();
                current.afficher();
                value--;
            }
            current.execute(this);
        }
        else if(value <0){
            value= -1*value;
            while(iterator.hasPrevious() && value >= 0){
                current= iterator.previous();
                current.afficher();
                value--;
            }
        }
        else{

        }

    }


    public int lancerDe(){
        return (int) (1+ (Math.random()*3));
    }
    public Case getCurrent(){
        return current;
    }



}
