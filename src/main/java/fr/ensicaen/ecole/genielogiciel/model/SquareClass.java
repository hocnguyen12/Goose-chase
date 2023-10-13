package fr.ensicaen.ecole.genielogiciel.model;

import fr.ensicaen.ecole.genielogiciel.LoginMain;

import java.util.List;

public class SquareClass implements Square {
    public SquareClass() {
    }

    @Override
    public void execute(AbstractFactoryStudent student, int diceTotal, List<Square> board) {
        student.increaseSkillLevel(1);
    }

    @Override
    public String getSquareName() {
        return LoginMain.getMessageBundle().getString("squarename.course");
    }
}