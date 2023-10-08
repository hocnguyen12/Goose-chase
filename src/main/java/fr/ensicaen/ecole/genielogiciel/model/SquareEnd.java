package fr.ensicaen.ecole.genielogiciel.model;

public class SquareEnd implements Square {
    public SquareEnd() {
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
