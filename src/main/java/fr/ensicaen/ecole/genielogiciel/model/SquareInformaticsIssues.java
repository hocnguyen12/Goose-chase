package fr.ensicaen.ecole.genielogiciel.model;

import fr.ensicaen.ecole.genielogiciel.LoginMain;

import java.util.List;

public class SquareInformaticsIssues implements Square{

    private AbstractFactoryStudent _characterInSquare = null;

    public SquareInformaticsIssues() {}

    @Override
    public void execute(AbstractFactoryStudent student, int diceTotal, List<Square> board) {
        if(_characterInSquare == null){
            student.setInformaticsProblem(true);
            _characterInSquare = student;
        }else {
            _characterInSquare.setInformaticsProblem(false);
            _characterInSquare = null;
        }
    }

    @Override
    public String getSquareName() {
        return LoginMain.getMessageBundle().getString("squarename.ITissue");
    }

    public AbstractFactoryStudent getCharacterInSquare() {
        return _characterInSquare;
    }
}