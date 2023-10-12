package fr.ensicaen.ecole.genielogiciel.model;

import fr.ensicaen.ecole.genielogiciel.LoginMain;

import java.util.List;

public class SquareDropout implements Square{
    public SquareDropout() {
    }

    @Override
    public void execute(AbstractFactoryStudent student, int diceTotal, List<Square> board) {
        student.set_squareNumber(0);
    }

    @Override
    public String get_squareName() {
        return LoginMain.getMessageBundle().getString("squarename.dropout");
    }
}