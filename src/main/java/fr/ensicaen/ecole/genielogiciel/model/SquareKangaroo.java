package fr.ensicaen.ecole.genielogiciel.model;

import fr.ensicaen.ecole.genielogiciel.LoginMain;

import java.util.List;

public class SquareKangaroo implements Square{

    public SquareKangaroo(){}

    @Override
    public void execute(AbstractFactoryStudent student, int diceTotal, List<Square> board) {
        student.move(diceTotal);
        board.get(student.get_squareNumber()).execute(student, diceTotal, board);
        System.out.println("Square : " + board.get(student.get_squareNumber()).get_squareName());
    }

    @Override
    public String get_squareName() {
        return LoginMain.getMessageBundle().getString("squarename.kangaroo");
    }
}