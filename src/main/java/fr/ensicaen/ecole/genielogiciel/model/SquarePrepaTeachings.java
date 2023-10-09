package fr.ensicaen.ecole.genielogiciel.model;

import fr.ensicaen.ecole.genielogiciel.LoginMain;

public class SquarePrepaTeachings implements Square{
    public SquarePrepaTeachings() {
    }
    @Override
    public void execute(AbstractFactoryStudent s) {
        s.increaseSkillLevel(1);
        if (s instanceof ConcreteFactoryLicence) {
            s.set_squareNumber(s.get_squareNumber() + 1);
        } else {
            s.set_squareNumber(s.get_squareNumber() - 1);
        }
    }

    @Override
    public String get_squareName() {
        return LoginMain.getMessageBundle().getString("squarename.prepa");
    }

}
