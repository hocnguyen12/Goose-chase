package fr.ensicaen.ecole.genielogiciel.model;

public class EndSquare implements Square {
    private int _number;
    private Character _character;
    public EndSquare(int n){
        _number = n;
        _character = null;
    }
    @Override
    public void execute(Character c){
        _character = c;
    }

    @Override
    public int getNumberSquare() {
       return _number;
    }

    public Character get_character() {
        return _character;
    }
}
