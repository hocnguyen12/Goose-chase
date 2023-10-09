package fr.ensicaen.ecole.genielogiciel.model;

import fr.ensicaen.ecole.genielogiciel.LoginMain;

public class SquareExam implements Square{
    public SquareExam() {
    }

    @Override
    public void execute(AbstractFactoryStudent s) {
        if (s.get_skillLevel() < 8) {
            if (s.get_squareNumber() - (8 - s.get_skillLevel()) < 0) {
                //we don't want negative positions, back to start
                s.set_squareNumber(0);
            } else {
                s.set_squareNumber(s.get_squareNumber() - (8 - s.get_skillLevel()));
            }
        }
    }

    @Override
    public String get_squareName() {

        return LoginMain.getMessageBundle().getString("squarename.exam");
    }

}
