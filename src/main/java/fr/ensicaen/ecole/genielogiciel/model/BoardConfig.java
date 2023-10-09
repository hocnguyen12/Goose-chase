package fr.ensicaen.ecole.genielogiciel.model;

import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BoardConfig {
    private ArrayList<Square> _squares;

    public ArrayList<Square> getSquares() {
        return _squares;
    }
    public void setSquares(ArrayList<Square> squares) {
        this._squares = squares;
    }

    public void displayboard(){
        for (int i = 0; i < 64; i++){
            System.out.println(_squares.get(i).get_squareName());
        }
    }
}