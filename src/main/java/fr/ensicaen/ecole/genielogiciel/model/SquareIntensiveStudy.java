package fr.ensicaen.ecole.genielogiciel.model;

import fr.ensicaen.ecole.genielogiciel.LoginMain;

import java.util.List;

public class SquareIntensiveStudy implements Square{

    public SquareIntensiveStudy() {}

    @Override
    public void execute(AbstractFactoryStudent student, int diceTotal, List<Square> board) {
        student.increaseSkillLevel(3);
        System.out.println("Square N" + student.get_squareNumber() + ": " + board.get(student.get_squareNumber()).get_squareName());
        student.set_squareNumber(12);
    }

    @Override
    public String get_squareName() {
        return LoginMain.getMessageBundle().getString("squarename.Intensive");
    }
}