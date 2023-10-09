package fr.ensicaen.ecole.genielogiciel.model;

import fr.ensicaen.ecole.genielogiciel.LoginMain;

public class SquareIntensiveStudy implements Square{

    public SquareIntensiveStudy() {

    }

    @Override
    public void execute(AbstractFactoryStudent s) {
        s.increaseSkillLevel(1);
        s.set_squareNumber(12);
    }

    @Override
    public String get_squareName() {
        return LoginMain.getMessageBundle().getString("squarename.Intensive");
    }
}

