package fr.ensicaen.ecole.genielogiciel.model;
abstract class Student {
    private int _level;
    private int _position = 0;

    public void move(int n){
        //If new position exceeds 63, the player goes backw²
        if (_position + n > 63) {
            _position = 63 - (_position + n - 63);
        }
        _position += n;
    }

    public int get_position() {
        return _position;
    }
}


