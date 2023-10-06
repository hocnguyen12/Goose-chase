package fr.ensicaen.ecole.genielogiciel.model;

import java.util.Scanner;

public class Game {
    private Character _character;
    private final Square[] _board;
    private final int _length;
    private int _diceValue1;
    private int _diceValue2;

    private int _round;

    public Game() {
        _length = 8;
        _diceValue1 = 0;
        _diceValue2 = 0;
        _round = 1;
        _board = new Square[_length];
    }

    public void start() {
        _character = new Character();
        _board[0] = new StartSquare(0);
        _board[1] = new BasicSquare(1);
        _board[2] = new BasicSquare(2);
        _board[3] = new BasicSquare(3);
        _board[4] = new BasicSquare(4);
        _board[5] = new BasicSquare(5);
        _board[6] = new BasicSquare(6);
        _board[7] = new EndSquare(7);
    }

    public int executeRound() {
        if (isLastSquareEmpty()) {
            System.out.println("ROUND : " + _round);
            _round++;

            _diceValue1 = rollDice();
            _diceValue2 = rollDice();

            System.out.println("DE = " + _diceValue1 + "" + _diceValue2);
            move(_character);
            // ARRIVEE DEPASSEE
            if (_character.getSquareNumber() >= 7) {
                System.out.println("Arrivée dépassée");
                return -1;
            }
            System.out.println("Je suis sur la case " + _character.getSquareNumber());
            _board[_character.getSquareNumber()].execute(_character);
            return 0;
        } else {
            //ARRIVEE ATTEINTE
            System.out.println("Arrivée atteinte");
            return -1;
        }
    }


    void move(Character c) {
        c.setSquareNumber(c.getSquareNumber() + _diceValue1 + _diceValue1);
    }

    int rollDice() {
        return 1 + (int)(Math.random() * ((6 - 1) + 1));
    }

    public boolean isLastSquareEmpty(){
        if (_board[_length - 1].get_character() == null) {
            return true;
        }
        return false;
    }

    public int get_diceValue() {
        return _diceValue1 + _diceValue2;
    }

    public int get_length() {
        return _length;
    }

    public int get_playerPosition(){
        return _character.getSquareNumber();
    }

    //tmp
    public void caseBonus(){
        _character.setSquareNumber(_character.getSquareNumber() + 1);
    }
}
