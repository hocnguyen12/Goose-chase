package fr.ensicaen.ecole.genielogiciel.model;
public class ConcreteFactoryDUT extends AbstractFactoryStudent{
    private Student _student;
    public ConcreteFactoryDUT(){
        int randomInt = 1 + (int) (Math.random() * 6);
        if (randomInt == 1) {
            _student = createDilettante();
        } else if (randomInt == 2) {
            _student = createDiligent();
        } else {
            _student = createBrilliant();
        }
    }
    @Override
    public Dilettante createDilettante() {
        return null;
    }

    @Override
    public Diligent createDiligent() {
        return null;
    }

    @Override
    public Brilliant createBrilliant() {
        return null;
    }
}
