package fr.ensicaen.ecole.genielogiciel.model;

import fr.ensicaen.ecole.genielogiciel.LoginMain;

public class SquareDropout implements Square{
    public SquareDropout() {
    }

    @Override
    public void execute(AbstractFactoryStudent s) {
        s.setSquareNumber(0);
    }

    @Override
    public String get_squareName() {
        return LoginMain.getMessageBundle().getString("squarename.dropout");
    }

}
