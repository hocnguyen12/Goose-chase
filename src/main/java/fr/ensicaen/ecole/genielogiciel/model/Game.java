package fr.ensicaen.ecole.genielogiciel.model;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<AbstractFactoryStudent> _players= new ArrayList<>();
    private final Square[] _board;
    private final int _boardLength;
    private int _diceValue1;
    private int _diceValue2;
    public int _round;
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
            System.out.println("Creation d'un joueur");
            switch (playerTypes.get(i)) {
                case "Prepa":
                    System.out.println("new Prepa");
                    AbstractFactoryStudent sPrepa = new ConcreteFactoryPrepa();
                    _players.add(sPrepa);
                    break;
                case "Licence":
                    System.out.println("new Licence");
                    AbstractFactoryStudent sLicence = new ConcreteFactoryLicence();
                    _players.add(sLicence);
                    break;
                case "DUT":
                    System.out.println("new DUT");
                    AbstractFactoryStudent sDUT = new ConcreteFactoryDUT();
                    _players.add(sDUT);
                    break;
            }
        }
    }

    public void configureBoard() {
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
        _board[0] = new SquareStart(0);
        for (int i = 0; i < 63; i++){
            _board[i] = new SquareBasic(i);
        }
        _board[63] = new SquareEnd(63);

    }

    public List<Integer> executeRound() {
        if (gameIsFinished()) {
            return null;
        } else {
            List<Integer> positionsList= new ArrayList<>();


            for (AbstractFactoryStudent student : _players) {
                if (student.nextRoundSkipped())  {
                    student.set_skipNextRound(false);
                    continue;
                }
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
                System.out.println("dice : " + diceTotal);

                student.move(diceTotal);
                _board[student.get_squareNumber()].execute(student);
                System.out.println("Square : " + getSquareNameEN(student.get_squareNumber()));

                positionsList.add(student.get_squareNumber());
            }
            _round++;
            return positionsList;
        }
    }

    int rollDice() {
        return 1 + (int)(Math.random() * 6);
    }

    public boolean gameIsFinished(){
        for (AbstractFactoryStudent student : _players) {
            if (student.get_squareNumber() == 63) {
                return true;
            }
        }
        return false;
    }

    public String getSquareNameEN(int n) {
        return _board[n].get_squareNameEN();
    }
    public String getSquareNameFR(int n) {
        return _board[n].get_squareNameFR();
    }
}
