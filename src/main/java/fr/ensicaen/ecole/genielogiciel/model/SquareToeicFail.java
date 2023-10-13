package fr.ensicaen.ecole.genielogiciel.model;

import fr.ensicaen.ecole.genielogiciel.LoginMain;

import java.util.List;

public class SquareToeicFail implements Square{

    public SquareToeicFail() {
    }

    @Override
    public void execute(AbstractFactoryStudent student, int diceTotal, List<Square> board) {
        System.out.println("Square N" + student.getSquareNumber() + ": " + board.get(student.getSquareNumber()).getSquareName());
        student.move(-12);
        student.addRoundPositions(student.getSquareNumber());
        board.get(student.getSquareNumber()).execute(student, diceTotal, board);
    }

    @Override
    public String getSquareName() {
        return LoginMain.getMessageBundle().getString("squarename.toeic");
    }
}