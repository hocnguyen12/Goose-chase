package fr.ensicaen.ecole.genielogiciel.model;

public class SquareParty implements Square{
    private int _number;

    public SquareParty(int _number) {
        this._number = _number;
    }
    @Override
    public void execute(AbstractFactoryStudent s) {
        s.increaseSkillLevel(-1);
    }

    @Override
    public String get_squareNameFR() {
        return "Soirée";
    }

    @Override
    public String get_squareNameEN() {
        return "Party";
    }
}
