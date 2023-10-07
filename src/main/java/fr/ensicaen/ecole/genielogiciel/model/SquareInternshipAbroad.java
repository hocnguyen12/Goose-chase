package fr.ensicaen.ecole.genielogiciel.model;

public class SquareInternshipAbroad implements Square{
    private int _number;

    public SquareInternshipAbroad(int _number) {
        this._number = _number;
    }
    @Override
    public void execute(AbstractFactoryStudent s) {
        s.increaseSkillLevel(2);
    }

    @Override
    public String get_squareNameFR() {
        return "Stage à l'étranger";
    }

    @Override
    public String get_squareNameEN() {
        return "Internship Abroad";
    }
}
