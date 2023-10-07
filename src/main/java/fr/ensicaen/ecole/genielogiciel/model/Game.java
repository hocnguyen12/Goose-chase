package fr.ensicaen.ecole.genielogiciel.model;

import javax.swing.*;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.GenericDeclaration;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<AbstractFactoryStudent> _players= new ArrayList<>();
    private final Square[] _board;
    private final int _boardLength;
    private int _diceValue1;
    private int _diceValue2;
    private int _round;
    private BoardConfig _config;

    public Game() {
        _boardLength = 64;
        _diceValue1 = 0;
        _diceValue2 = 0;
        _round = 1;
        _board = new Square[_boardLength];
    }

    public void start(int playersCount, List<String> playerTypes) throws InvalidPlayersCount {
        //playerTypes = ["Prepa", "Licence", "DUT", "Prepa"]
        if (playersCount < 1 || playersCount > 4) {
            throw new InvalidPlayersCount("Player count must be between 1 and 4");
        }

        configureBoard();

        //Players creation
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

    private void configureBoard() {
        /*
        try {
            BoardConfigReader boardConfigReader = new BoardConfigReader();
            _config = boardConfigReader.readBoardConfig();
        } catch (IOException e) {
            e.printStackTrace();
            // Gérer les erreurs de lecture du fichier JSON ici
        }

        _board = _config.getSquares();*/
        //Later read JSON config file

        //Start, Basic...Basic, End
        _board[0] = new StartSquare(0);
        for (int i = 0; i < 63; i++){
            _board[i] = new BasicSquare(i);
        }
        _board[63] = new EndSquare(63);

    }

    public void executeRound() {
        if (gameIsFinished()) {

        } else {
            List<Integer> positionsList= new ArrayList<Integer>();

            System.out.println("ROUND : " + _round);
            _round++;
            for (AbstractFactoryStudent student : _players) {
                _diceValue1 = rollDice();
                _diceValue2 = rollDice();

                int diceTotal = 0;
                if (student.get_student() instanceof Dilettante) {
                    diceTotal = (_diceValue1 + _diceValue2) / 2;
                } else if (student.get_student() instanceof Diligent) {
                    diceTotal = _diceValue1 + _diceValue2;
                } else if (student.get_student() instanceof Brilliant) {
                    diceTotal = (_diceValue1 + _diceValue2) * 2;
                }

                student.get_student().move(diceTotal);
            }
        }
    }

    int rollDice() {
        return 1 + (int)(Math.random() * 6);
    }

    public boolean gameIsFinished(){
        for (AbstractFactoryStudent student : _players) {
            if (student.get_student().get_position() == 63) {
                return true;
            }
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
