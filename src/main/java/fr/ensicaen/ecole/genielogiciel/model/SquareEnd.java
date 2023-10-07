package fr.ensicaen.ecole.genielogiciel.model;

import java.util.ArrayList;
import java.util.List;

public class SquareEnd implements Square {
    private final int _number;
    public SquareEnd(int n){
        _number = n;
    }
    @Override
    public void execute(AbstractFactoryStudent s){
    }

    @Override
    public String get_squareNameFR() {
        return "Fin";
    }

    @Override
    public String get_squareNameEN() {
        return "End";
    }

}
