package fr.ensicaen.ecole.genielogiciel.model;

import fr.ensicaen.ecole.genielogiciel.LoginMain;

public class SquareBasic implements Square{

    public SquareBasic() {
    }

    @Override
    public void execute(AbstractFactoryStudent s) {

    }

    @Override
    public String get_squareName() {
        return LoginMain.getMessageBundle().getString("squarename.state");
    }
}
