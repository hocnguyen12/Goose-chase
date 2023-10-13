package fr.ensicaen.ecole.genielogiciel.model;

import fr.ensicaen.ecole.genielogiciel.LoginMain;

import java.util.List;

public class SquareKangaroo implements Square{

    public SquareKangaroo(){}

    @Override
    public void execute(AbstractFactoryStudent student, int diceTotal, List<Square> board) {
        if (diceTotal == 0) {
            return;
        }
        student.move(diceTotal);
        System.out.println("Square N" + student.getSquareNumber() + ": " + board.get(student.getSquareNumber()).getSquareName());
        student.addRoundPositions(student.getSquareNumber());
        board.get(student.getSquareNumber()).execute(student, diceTotal, board);
    }

    @Override
    public String getSquareName() {
        return LoginMain.getMessageBundle().getString("squarename.kangaroo");
    }
}