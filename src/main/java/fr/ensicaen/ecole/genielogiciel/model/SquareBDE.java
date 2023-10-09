package fr.ensicaen.ecole.genielogiciel.model;

import fr.ensicaen.ecole.genielogiciel.LoginMain;

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
    public String get_squareName() {
        return LoginMain.getMessageBundle().getString("squarename.BDE");
    }
}

