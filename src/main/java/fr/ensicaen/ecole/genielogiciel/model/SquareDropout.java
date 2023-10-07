package fr.ensicaen.ecole.genielogiciel.model;

public class SquareDropout implements Square{
    private int _number;

    public SquareDropout(int _number) {
        this._number = _number;
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
