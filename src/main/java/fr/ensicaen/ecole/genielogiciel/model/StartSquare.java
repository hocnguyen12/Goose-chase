package fr.ensicaen.ecole.genielogiciel.model;

public class StartSquare implements Square {
    private int _number;
    public StartSquare(int n){
          _number = n;
    }
    @Override
    public void execute(Student s){
    }
    @Override
    public int getNumberSquare() {
        return _number;
    }

}
