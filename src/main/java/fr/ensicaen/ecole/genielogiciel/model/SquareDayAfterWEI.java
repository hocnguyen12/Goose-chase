package fr.ensicaen.ecole.genielogiciel.model;

import fr.ensicaen.ecole.genielogiciel.LoginMain;
import fr.ensicaen.ecole.genielogiciel.model.character.AbstractFactoryStudent;

import java.util.List;

public class SquareDayAfterWEI implements Square{

    public SquareDayAfterWEI() {
    }

    @Override
    public void execute(AbstractFactoryStudent student, int diceTotal, List<Square> board) {
        student.setSkipNextRoundWEI(true);
    }

    @Override
    public String getSquareName() {
        return LoginMain.getMessageBundle().getString("squarename.wei");
    }
}