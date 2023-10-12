package fr.ensicaen.ecole.genielogiciel.model;

import fr.ensicaen.ecole.genielogiciel.LoginMain;

public class SquareDUTTeachings implements Square{
    public SquareDUTTeachings() {
    }

    @Override
    public void execute(AbstractFactoryStudent s) {
        s.increaseSkillLevel(1);
        if (s instanceof ConcreteFactoryDUT) {
            s.setSquareNumber(s.getSquareNumber() + 1);
        } else {
            s.setSquareNumber(s.getSquareNumber() - 1);
        }
    }
    @Override
    public String get_squareName() {
        return LoginMain.getMessageBundle().getString("squarename.dut");
    }

}
