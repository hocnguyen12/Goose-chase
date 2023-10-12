package fr.ensicaen.ecole.genielogiciel.model;

import fr.ensicaen.ecole.genielogiciel.LoginMain;

import java.util.List;

public class SquareBDE implements Square{
    private AbstractFactoryStudent _characterInSquare = null;

    public SquareBDE() {}

    @Override
    public void execute(AbstractFactoryStudent student, int diceTotal, List<Square> board) {
        if(_characterInSquare == null){
            student.set_BDE(true);
            _characterInSquare = student;
        }else {
            student.set_BDE(true);
            _characterInSquare.set_BDE(false);
            _characterInSquare = student;
        }
    }

    @Override
    public String get_squareName() {
        return LoginMain.getMessageBundle().getString("squarename.BDE");
    }
}