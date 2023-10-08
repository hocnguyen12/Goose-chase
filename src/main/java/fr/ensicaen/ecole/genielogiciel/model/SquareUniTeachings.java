package fr.ensicaen.ecole.genielogiciel.model;

public class SquareUniTeachings implements Square{
    public SquareUniTeachings() {
    }
    @Override
    public void execute(AbstractFactoryStudent s) {

    }
    @Override
    public String get_squareNameFR() {
        return "Cours de Licence";
    }
    @Override
    public String get_squareNameEN() {
        return "Uni Class";
    }
}
