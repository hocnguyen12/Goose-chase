package fr.ensicaen.ecole.genielogiciel.model;

public class Character {
    private String _name;
    private String _hardskill;
    private int _squareNumber = 0;

    public Character(){
        _name = "Joueur";
        _hardskill = "Prepa";
    }

    public void setSquareNumber(int n) {
        _squareNumber = n;
    }

    public int getSquareNumber() {
        return _squareNumber;
    }
}
