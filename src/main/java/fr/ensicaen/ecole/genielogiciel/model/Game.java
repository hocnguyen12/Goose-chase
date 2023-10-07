package fr.ensicaen.ecole.genielogiciel.model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<AbstractFactoryStudent> _players= new ArrayList<>();
    private final Square[] _board;
    private final int _boardLength;
    private int _diceValue1;
    private int _diceValue2;
    private int _round;

    public Game() {
        _boardLength = 64;
        _diceValue1 = 0;
        _diceValue2 = 0;
        _round = 1;
        _board = new Square[_boardLength];
    }

    public void start(int playersCount, List<String> playerTypes) throws InvalidPlayersCount {
        if (playersCount < 1 || playersCount > 4) {
            throw new InvalidPlayersCount("Player count must be between 1 and 4");
        }
        _board[0] = new StartSquare(0);
        _board[1] = new BasicSquare(1);
        _board[2] = new BasicSquare(2);
        _board[3] = new BasicSquare(3);
        _board[4] = new BasicSquare(4);
        _board[5] = new BasicSquare(5);
        _board[6] = new BasicSquare(6);
        _board[7] = new EndSquare(7);

        for (int i = 0; i < playersCount; i++) {
            switch (playerTypes.get(i)) {
                case "Prepa":
                    AbstractFactoryStudent sPrepa = new ConcreteFactoryPrepa();
                    _players.add(sPrepa);
                case "Licence":
                    AbstractFactoryStudent sLicence = new ConcreteFactoryLicence();
                    _players.add(sLicence);
                case "DUT":
                    AbstractFactoryStudent sDUT = new ConcreteFactoryDUT();
                    _players.add(sDUT);
            }
        }
    }

    public void executeRound() {
        if (gameIsFinished()) {

        } else {
            System.out.println("ROUND : " + _round);
            _round++;
            for (AbstractFactoryStudent student : _players) {
                _diceValue1 = rollDice();
                _diceValue2 = rollDice();

                int diceTotal;
                if (student.get_student() instanceof Dilettante) {
                    diceTotal = (_diceValue1 + _diceValue2) / 2;
                } else if (student.get_student() instanceof Diligent) {
                    diceTotal = _diceValue1 + _diceValue2;
                } else if (student.get_student() instanceof Brilliant) {
                    diceTotal = (_diceValue1 + _diceValue2) * 2;
                }
/*
                System.out.println("DE = " + _diceValue1 + "" + _diceValue2);
                move(_character);

                System.out.println("Je suis sur la case " + _character.getSquareNumber());
                _board[_character.getSquareNumber()].execute(_character);*/
            }
        }
    }


    void move(Character c) {
    }

    int rollDice() {
        return 1 + (int)(Math.random() * 6);
    }

    public boolean gameIsFinished(){
        if (_board[_boardLength - 1].get_character() != null) {
            return true;
        }
        return false;
    }

    public int get_diceValue() {
        return _diceValue1 /* + _diceValue2*/;
    }

    public int get_boardLength() {
        return _boardLength;
    }

    public int get_playerPosition(){
        return 0;
    }

    //tmp
    public void caseBonus(){
    }
}
