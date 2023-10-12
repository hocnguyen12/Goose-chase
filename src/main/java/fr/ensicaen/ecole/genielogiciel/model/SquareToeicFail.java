package fr.ensicaen.ecole.genielogiciel.model;

import fr.ensicaen.ecole.genielogiciel.LoginMain;

public class SquareToeicFail implements Square{
    public SquareToeicFail() {
    }

    @Override
    public void execute(AbstractFactoryStudent s) {
        s.setSquareNumber(s.getSquareNumber() - 12);
    }

    @Override
    public String get_squareName() {
        return LoginMain.getMessageBundle().getString("squarename.toeic");
    }

}
