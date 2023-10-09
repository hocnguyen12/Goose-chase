package fr.ensicaen.ecole.genielogiciel.model;

import fr.ensicaen.ecole.genielogiciel.LoginMain;

public class SquareUniTeachings implements Square{
    public SquareUniTeachings() {
    }
    @Override
    public void execute(AbstractFactoryStudent s) {

    }
    @Override
    public String get_squareName() {
        return LoginMain.getMessageBundle().getString("squarename.uni");
    }

}
