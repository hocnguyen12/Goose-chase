package fr.ensicaen.ecole.genielogiciel.model;

import fr.ensicaen.ecole.genielogiciel.LoginMain;

public class SquareStart implements Square {
    public SquareStart() {
    }

    @Override
    public void execute(AbstractFactoryStudent s){
    }

    @Override
    public String get_squareName() {
        return LoginMain.getMessageBundle().getString("squarename.start");
    }


}
