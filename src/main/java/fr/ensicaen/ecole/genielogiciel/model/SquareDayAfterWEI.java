package fr.ensicaen.ecole.genielogiciel.model;

import fr.ensicaen.ecole.genielogiciel.LoginMain;

import java.util.List;

public class SquareDayAfterWEI implements Square{

    public SquareDayAfterWEI() {
    }

    @Override
    public void execute(AbstractFactoryStudent student, int diceTotal, List<Square> board) {
        student.set_skipNextRoundWEI(true);
    }

    @Override
    public String get_squareName() {
        return LoginMain.getMessageBundle().getString("squarename.wei");
    }
}