package fr.ensicaen.ecole.genielogiciel.model;

import fr.ensicaen.ecole.genielogiciel.LoginMain;

import java.util.List;

public class SquareEnd implements Square {

    public SquareEnd() {
    }

    @Override
    public void execute(AbstractFactoryStudent student, int diceTotal, List<Square> board){}

    @Override
    public String get_squareName() {
        return LoginMain.getMessageBundle().getString("squarename.end");
    }
}
