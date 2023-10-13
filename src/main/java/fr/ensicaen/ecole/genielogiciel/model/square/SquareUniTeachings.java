package fr.ensicaen.ecole.genielogiciel.model.square;

import fr.ensicaen.ecole.genielogiciel.LoginMain;
import fr.ensicaen.ecole.genielogiciel.model.character.AbstractFactoryStudent;
import fr.ensicaen.ecole.genielogiciel.model.character.ConcreteFactoryLicence;

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
        System.out.println("Square N" + student.getSquareNumber() + ": " + board.get(student.getSquareNumber()).getSquareName());
        student.addRoundPositions(student.getSquareNumber());
        board.get(student.getSquareNumber()).execute(student, diceTotal, board);
    }

    @Override
    public String getSquareName() {
        return LoginMain.getMessageBundle().getString("squarename.uni");
    }
}