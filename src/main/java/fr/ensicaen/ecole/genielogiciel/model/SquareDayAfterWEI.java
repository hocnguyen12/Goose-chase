package fr.ensicaen.ecole.genielogiciel.model;

import fr.ensicaen.ecole.genielogiciel.LoginMain;

public class SquareDayAfterWEI implements Square{
    public SquareDayAfterWEI() {
    }

    @Override
    public void execute(AbstractFactoryStudent s) {
        s.set_skipNextRoundWEI(true);
    }

    @Override
    public String get_squareName() {

        return LoginMain.getMessageBundle().getString("squarename.wei");
    }

}
