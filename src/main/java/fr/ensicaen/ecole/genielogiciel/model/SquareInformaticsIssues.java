package fr.ensicaen.ecole.genielogiciel.model;

public class SquareInformaticsIssues implements Square{
    private AbstractFactoryStudent _characterInSquare = null;

    public SquareInformaticsIssues() {

    }

    @Override
    public void execute(AbstractFactoryStudent s) {
        if(_characterInSquare == null){
            s.set_InformaticsProblem(true);
            _characterInSquare = s;
        }else {
            _characterInSquare.set_InformaticsProblem(false);
            _characterInSquare = null;
        }
    }

    @Override
    public String get_squareNameFR() {
        return "Problemes Informatiques";
    }

    @Override
    public String get_squareNameEN() {
        return "Informatics Issues";
    }
}
