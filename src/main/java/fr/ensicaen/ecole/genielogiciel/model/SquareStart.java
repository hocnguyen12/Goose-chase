package fr.ensicaen.ecole.genielogiciel.model;

public class SquareStart implements Square {
    public SquareStart() {
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
