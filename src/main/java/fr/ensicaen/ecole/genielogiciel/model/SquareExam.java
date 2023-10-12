package fr.ensicaen.ecole.genielogiciel.model;

import fr.ensicaen.ecole.genielogiciel.LoginMain;

import java.util.List;

public class SquareExam implements Square{

    public SquareExam() {}

    @Override
    public void execute(AbstractFactoryStudent student, int diceTotal, List<Square> board) {
        if (student.get_skillLevel() < 8) {
            if (student.get_squareNumber() - (8 - student.get_skillLevel()) < 0) {
                //we don't want negative positions, back to start
                student.set_squareNumber(0);
            } else {
                student.move(- (8 - student.get_skillLevel()));
                board.get(student.get_squareNumber()).execute(student, diceTotal, board);
                System.out.println("Square : " + board.get(student.get_squareNumber()).get_squareName());            }
        }
    }

    @Override
    public String get_squareName() {
        return LoginMain.getMessageBundle().getString("squarename.exam");
    }
}