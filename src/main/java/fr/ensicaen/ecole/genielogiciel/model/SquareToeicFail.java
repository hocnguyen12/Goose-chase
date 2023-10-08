package fr.ensicaen.ecole.genielogiciel.model;

public class SquareToeicFail implements Square{
    public SquareToeicFail() {
    }

    @Override
    public void execute(AbstractFactoryStudent s) {
        s.set_squareNumber(s.get_squareNumber() - 12);
    }

    @Override
    public String get_squareNameFR() {
        return "Echec du Toeic";
    }

    @Override
    public String get_squareNameEN() {
        return "Toeic Fail";
    }
}
