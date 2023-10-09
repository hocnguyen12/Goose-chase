package fr.ensicaen.ecole.genielogiciel.model;

import fr.ensicaen.ecole.genielogiciel.LoginMain;

public class SquareToeicFail implements Square{
    public SquareToeicFail() {
    }

    @Override
    public void execute(AbstractFactoryStudent s) {
        s.set_squareNumber(s.get_squareNumber() - 12);
    }

    @Override
    public String get_squareName() {

        return LoginMain.getMessageBundle().getString("squarename.toeic");
    }

}
