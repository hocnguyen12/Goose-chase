package fr.ensicaen.ecole.genielogiciel.model;
public class ConcreteFactoryPrepa extends AbstractFactoryStudent{
    private Student _student;
    public ConcreteFactoryPrepa(){
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
        System.out.println("new Dilettante");
        return new Dilettante();
    }

    @Override
    public Diligent createDiligent() {
        System.out.println("new Diligent");
        return new Diligent();
    }

    @Override
    public Brilliant createBrilliant() {
        System.out.println("new Brilliant");
        return new Brilliant();
    }

    public Student get_student() {
        return _student;
    }
}
