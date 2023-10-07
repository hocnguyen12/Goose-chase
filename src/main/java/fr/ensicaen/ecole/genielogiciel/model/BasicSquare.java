package fr.ensicaen.ecole.genielogiciel.model;

public class BasicSquare implements Square{
    private final int _number;
    private Student _student;
    public BasicSquare(int n){
        _number = n;
    }
    @Override
    public void execute(Student s) {
        _student = s;
    }
    @Override
    public int getNumberSquare() {
        return _number;
    }
}
