package fr.ensicaen.ecole.genielogiciel.model;

import fr.ensicaen.ecole.genielogiciel.LoginMain;

import java.util.List;

public class SquareDropout implements Square{
    public SquareDropout() {
    }

    @Override
    public void execute(AbstractFactoryStudent student, int diceTotal, List<Square> board) {
        student.setSquareNumber(0);
        student.addRoundPositions(student.getSquareNumber());
    }

    @Override
    public String getSquareName() {
        return LoginMain.getMessageBundle().getString("squarename.dropout");
    }
}