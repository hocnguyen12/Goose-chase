package fr.ensicaen.ecole.genielogiciel.model;

import fr.ensicaen.ecole.genielogiciel.LoginMain;

import java.util.List;

public class SquareInformaticsIssues implements Square{

    private AbstractFactoryStudent _characterInSquare = null;

    public SquareInformaticsIssues() {}

    @Override
    public void execute(AbstractFactoryStudent student, int diceTotal, List<Square> board) {
        if(_characterInSquare == null){
            student.set_InformaticsProblem(true);
            _characterInSquare = student;
        }else {
            _characterInSquare.set_InformaticsProblem(false);
            _characterInSquare = null;
        }
    }

    @Override
    public String get_squareName() {
        return LoginMain.getMessageBundle().getString("squarename.ITissue");
    }
}