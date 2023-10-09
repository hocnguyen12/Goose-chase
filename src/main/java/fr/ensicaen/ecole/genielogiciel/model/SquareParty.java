package fr.ensicaen.ecole.genielogiciel.model;

import fr.ensicaen.ecole.genielogiciel.LoginMain;

public class SquareParty implements Square{
    public SquareParty() {
    }

    @Override
    public void execute(AbstractFactoryStudent s) {
        s.increaseSkillLevel(-1);
    }

    @Override
    public String get_squareName() {
        return LoginMain.getMessageBundle().getString("squarename.party");
    }

}
