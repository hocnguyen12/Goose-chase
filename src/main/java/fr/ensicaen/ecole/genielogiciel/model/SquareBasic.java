package fr.ensicaen.ecole.genielogiciel.model;

public class SquareBasic implements Square{
    private final int _number;
    public SquareBasic(int n){
        _number = n;
    }
    @Override
    public void execute(AbstractFactoryStudent s) {

    }

    @Override
    public String get_squareNameFR() {
        return "Vide";
    }

    @Override
    public String get_squareNameEN() {
        return "Empty";
    }
}
