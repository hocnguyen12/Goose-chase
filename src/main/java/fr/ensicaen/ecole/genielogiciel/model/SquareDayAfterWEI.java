package fr.ensicaen.ecole.genielogiciel.model;

public class SquareDayAfterWEI implements Square{
    private int _number;

    public SquareDayAfterWEI(int _number) {
        this._number = _number;
    }
    @Override
    public void execute(AbstractFactoryStudent s) {
        s.set_skipNextRound(true);
    }

    @Override
    public String get_squareNameFR() {
        return "Landemain de WEI";
    }

    @Override
    public String get_squareNameEN() {
        return "Day after WEI";
    }
}
