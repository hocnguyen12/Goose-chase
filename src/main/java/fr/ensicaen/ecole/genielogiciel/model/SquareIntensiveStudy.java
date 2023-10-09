package fr.ensicaen.ecole.genielogiciel.model;

public class SquareIntensiveStudy implements Square{

    public SquareIntensiveStudy() {

    }

    @Override
    public void execute(AbstractFactoryStudent s) {
        s.increaseSkillLevel(1);
        s.set_squareNumber(12);
    }

    @Override
    public String get_squareNameFR() {
        return "Revisions Intensives";
    }

    @Override
    public String get_squareNameEN() {
        return "Intensive Studying";
    }
}

