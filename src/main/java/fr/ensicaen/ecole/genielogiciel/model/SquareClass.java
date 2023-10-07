package fr.ensicaen.ecole.genielogiciel.model;

public class SquareClass implements Square{
    private int _number;

    public SquareClass(int _number) {
        this._number = _number;
    }

    @Override
    public void execute(AbstractFactoryStudent s) {
        s.increaseSkillLevel(1);
    }

    @Override
    public String get_squareNameFR() {
        return "Cours";
    }

    @Override
    public String get_squareNameEN() {
        return "Class";
    }
}
