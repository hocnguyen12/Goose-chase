package fr.ensicaen.ecole.genielogiciel.model;

import fr.ensicaen.ecole.genielogiciel.LoginMain;

public class SquareInformaticsIssues implements Square{
    private AbstractFactoryStudent _characterInSquare = null;

    public SquareInformaticsIssues() {

    }

    @Override
    public void execute(AbstractFactoryStudent s) {
        if(_characterInSquare == null){
            s.setInformaticsProblem(true);
            _characterInSquare = s;
        }else {
            _characterInSquare.setInformaticsProblem(false);
            s.setInformaticsProblem(true);
            _characterInSquare = s;
        }
    }

    @Override
    public String get_squareName() {
        return LoginMain.getMessageBundle().getString("squarename.ITissue");
    }
    public AbstractFactoryStudent getStudent(){
        return _characterInSquare;
    }
}
