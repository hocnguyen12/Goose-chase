package fr.ensicaen.ecole.genielogiciel.model;

public class EndSquare implements Square {
    private int _number;
    private boolean _gameEnd;
    public EndSquare(int n){
        _number = n;
    }
    @Override
    public void execute(Student s){
        _gameEnd = true;
    }

    @Override
    public int getNumberSquare() {
       return _number;
    }

    public boolean is_gameEnd() {
        return _gameEnd;
    }
}
