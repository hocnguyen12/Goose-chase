package fr.ensicaen.ecole.genielogiciel.model;

import fr.ensicaen.ecole.genielogiciel.LoginMain;

import java.util.List;

public class SquareUniTeachings implements Square{

    public SquareUniTeachings() {
    }

    @Override
    public void execute(AbstractFactoryStudent student, int diceTotal, List<Square> board) {
        student.increaseSkillLevel(1);
        if (student instanceof ConcreteFactoryLicence) {
            student.move(1);
        } else {
            student.move(-1);
        }
        System.out.println("Square N" + student.get_squareNumber() + ": " + board.get(student.get_squareNumber()).get_squareName());
        board.get(student.get_squareNumber()).execute(student, diceTotal, board);
    }

    @Override
    public String get_squareName() {
        return LoginMain.getMessageBundle().getString("squarename.uni");
    }
}