package fr.ensicaen.ecole.genielogiciel.model;

import fr.ensicaen.ecole.genielogiciel.LoginMain;

public class SquareExam implements Square{
    public SquareExam() {
    }

    @Override
    public void execute(AbstractFactoryStudent s) {
        if (s.getSkillLevel() < 8) {
            if (s.getSquareNumber() - (8 - s.getSkillLevel()) < 0) {
                //we don't want negative positions, back to start
                s.setSquareNumber(0);
            } else {
                s.setSquareNumber(s.getSquareNumber() - (8 - s.getSkillLevel()));
            }
        }
    }

    @Override
    public String get_squareName() {
        return LoginMain.getMessageBundle().getString("squarename.exam");
    }

}
