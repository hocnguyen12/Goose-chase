package fr.ensicaen.ecole.genielogiciel.model;

import fr.ensicaen.ecole.genielogiciel.LoginMain;

public class SquareUniTeachings implements Square{
    public SquareUniTeachings() {
    }
    @Override
    public void execute(AbstractFactoryStudent s) {
        s.increaseSkillLevel(1);
        if (s instanceof ConcreteFactoryLicence) {
            s.setSquareNumber(s.getSquareNumber() + 1);
        } else {
            s.setSquareNumber(s.getSquareNumber() - 1);
        }
    }
    @Override
    public String get_squareName() {
        return LoginMain.getMessageBundle().getString("squarename.uni");
    }

}
