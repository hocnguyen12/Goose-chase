package fr.ensicaen.ecole.genielogiciel.model;

public class SquareStart implements Square {
    private int _number;
    public SquareStart(int n){
          _number = n;
    }
    @Override
    public void execute(AbstractFactoryStudent s){
    }

    @Override
    public String get_squareNameFR() {
        return "Départ";
    }

    @Override
    public String get_squareNameEN() {
        return "Start";
    }

}
