package fr.ensicaen.ecole.genielogiciel.model;

import java.util.Objects;

public class ConcreteFactoryLicence extends AbstractFactoryStudent {
    private Student _student;

    public ConcreteFactoryLicence() {
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
        return new Dilettante();
    }

    @Override
    public Diligent createDiligent() {

        return new Diligent();
    }

    @Override
    public Brilliant createBrilliant() {

        return new Brilliant();
    }

    public Student getStudent() {
        return _student;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ConcreteFactoryLicence that)) return false;
        return Objects.equals(_student, that._student);
    }


}
