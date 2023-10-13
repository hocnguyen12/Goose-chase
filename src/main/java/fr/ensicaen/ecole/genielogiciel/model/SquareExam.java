package fr.ensicaen.ecole.genielogiciel.model;

import fr.ensicaen.ecole.genielogiciel.LoginMain;
import fr.ensicaen.ecole.genielogiciel.model.character.AbstractFactoryStudent;

import java.util.List;

public class SquareExam implements Square{

    public SquareExam() {}

    @Override
    public void execute(AbstractFactoryStudent student, int diceTotal, List<Square> board) {
        if (student.getSkillLevel() < 8) {
            if (student.getSquareNumber() - (8 - student.getSkillLevel()) < 0) {
                //we don't want negative positions, back to start
                student.setSquareNumber(0);
                student.addRoundPositions(student.getSquareNumber());
            } else {
                System.out.println("Square N" + student.getSquareNumber() + ": " + board.get(student.getSquareNumber()).getSquareName());
                student.move(-(8 - student.getSkillLevel()));
                student.addRoundPositions(student.getSquareNumber());
                board.get(student.getSquareNumber()).execute(student, diceTotal, board);
            }
        }
    }

    @Override
    public String getSquareName() {
        return LoginMain.getMessageBundle().getString("squarename.exam");
    }
}