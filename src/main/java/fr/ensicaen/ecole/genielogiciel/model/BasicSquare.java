package fr.ensicaen.ecole.genielogiciel.model;

public class BasicSquare implements Square{
    private final int _number;
    private Character _character;
    public BasicSquare(int n){
        _number = n;
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
