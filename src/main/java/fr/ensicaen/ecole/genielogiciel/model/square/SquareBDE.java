package fr.ensicaen.ecole.genielogiciel.model.square;

import fr.ensicaen.ecole.genielogiciel.LoginMain;
import fr.ensicaen.ecole.genielogiciel.model.character.AbstractFactoryStudent;

import java.util.List;

public class SquareBDE implements Square{
    private AbstractFactoryStudent _characterInSquare = null;

    public SquareBDE() {}

    @Override
    public void execute(AbstractFactoryStudent student, int diceTotal, List<Square> board) {
        if(_characterInSquare == null){
            student.setBDE(true);
            _characterInSquare = student;
        }else {
            student.setBDE(true);
            _characterInSquare.setBDE(false);
            _characterInSquare = student;
        }
    }

    @Override
    public String getSquareName() {
        return LoginMain.getMessageBundle().getString("squarename.BDE");
    }

    public AbstractFactoryStudent getCharacterInSquare() {
        return _characterInSquare;
    }
}