package fr.ensicaen.ecole.genielogiciel.model;

public class SquareDropout implements Square{
    public SquareDropout() {
    }

    @Override
    public void execute(AbstractFactoryStudent s) {
        s.set_squareNumber(0);
    }

    @Override
    public String get_squareNameFR() {
        return "Arret des études";
    }

    @Override
    public String get_squareNameEN() {
        return "College Dropout";
    }
}
