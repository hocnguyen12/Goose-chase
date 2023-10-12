package fr.ensicaen.ecole.genielogiciel.model;

import fr.ensicaen.ecole.genielogiciel.LoginMain;

import java.util.List;

public class SquareBasic implements Square{

    public SquareBasic() {
    }

    @Override
    public void execute(AbstractFactoryStudent student, int diceTotal, List<Square> board) {}

    @Override
    public String getSquareName() {
        return LoginMain.getMessageBundle().getString("squarename.state");
    }
}