package fr.ensicaen.ecole.genielogiciel.model;

import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BoardConfig {
    private int _size;
    private ArrayList<Square> _squares;

    // Getters and setters
    public int getSize() {
        return _size;
    }
    public void setSize(int size) {
        this._size = size;
    }

    public ArrayList<Square> getSquares() {
        return _squares;
    }
    public void setSquares(ArrayList<Square> squares) {
        this._squares = squares;
    }

    public void displaySize() {
        System.out.println(_size);
    }

    public void displayboard(){
        for (int i = 0; i < _size; i++){
            System.out.println(_squares.get(i).get_squareNameEN());
        }
    }

}