package fr.ensicaen.ecole.genielogiciel.model;

public class SquareDUTClass implements Square{
    private int _number;
    public SquareDUTClass(int _number) {
        this._number = _number;
    }
    @Override
    public void execute(AbstractFactoryStudent s) {
        s.increaseSkillLevel(1);
        if (s instanceof ConcreteFactoryDUT) {
            s.set_squareNumber(s.get_squareNumber() + 1);
        } else {
            s.set_squareNumber(s.get_squareNumber() - 1);
        }
    }
    @Override
    public String get_squareNameFR() {
        return "Cours de DUT";
    }
    @Override
    public String get_squareNameEN() {
        return "DUT Class";
    }
}
