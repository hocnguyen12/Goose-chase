package fr.ensicaen.ecole.genielogiciel.model;

import fr.ensicaen.ecole.genielogiciel.LoginMain;

public class SquareInternshipAbroad implements Square{
    public SquareInternshipAbroad() {
    }

    @Override
    public void execute(AbstractFactoryStudent s) {
        s.increaseSkillLevel(2);
    }

    @Override
    public String get_squareName() {
        return LoginMain.getMessageBundle().getString("squarename.abroad");
    }

}
