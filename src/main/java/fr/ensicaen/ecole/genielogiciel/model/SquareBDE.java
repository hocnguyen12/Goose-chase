package fr.ensicaen.ecole.genielogiciel.model;

public class SquareBDE implements Square{
    private AbstractFactoryStudent _characterInSquare = null;

    public SquareBDE() {

    }

    @Override
    public void execute(AbstractFactoryStudent s) {
        if(_characterInSquare == null){
            s.set_BDE(true);
            _characterInSquare = s;
        }else {
            s.set_BDE(true);
            _characterInSquare.set_BDE(false);
            _characterInSquare = s;
        }
    }

    @Override
    public String get_squareNameFR() {
        return "Bloqué BDE";
    }

    @Override
    public String get_squareNameEN() {
        return "Stuck in BDE";
    }
}

