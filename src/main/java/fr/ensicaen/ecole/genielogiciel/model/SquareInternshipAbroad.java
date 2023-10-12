package fr.ensicaen.ecole.genielogiciel.model;

import fr.ensicaen.ecole.genielogiciel.LoginMain;

import java.util.List;

public class SquareInternshipAbroad implements Square{

    public SquareInternshipAbroad() {
    }

    @Override
    public void execute(AbstractFactoryStudent student, int diceTotal, List<Square> board) {
        student.increaseSkillLevel(2);
    }

    @Override
    public String getSquareName() {
        return LoginMain.getMessageBundle().getString("squarename.abroad");
    }
}