package fr.ensicaen.ecole.genielogiciel.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private final List<AbstractFactoryStudent> _players= new ArrayList<>();
    private List<Square> _board;
    private int _boardLength;
    private int _diceValue1;
    private int _diceValue2;
    private int _round;
    private BoardConfig _config;

    public Game() {
        _diceValue1 = 0;
        _diceValue2 = 0;
        _round = 1;
    }

    public void start(int playersCount, List<String> playerTypes, String configPath) throws InvalidPlayersCount {
        //playerTypes = ["Prepa", "Licence", "DUT", "Prepa"]
        if (playersCount < 1 || playersCount > 4) {
            throw new InvalidPlayersCount("Player count must be between 1 and 4");
        }
        configureBoard(configPath);
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

    public void configureBoard(String path) {
        System.out.println("Configuring board from json file...");
        BoardConfigReader boardConfigReader = new BoardConfigReader();

        try {
            _config = boardConfigReader.readBoardConfig(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Accédez aux données de configuration
        //_boardLength = _config.getSize();
        _board = _config.getSquares();

        //@TEST
        //System.out.println("Size : ");
        //_config.displaySize();
        System.out.println("Board : ");
        _config.displayboard();
    }

    public List<Integer> executeRound() {
        if (gameIsFinished()) {
            return null;
        } else {
            List<Integer> positionsList= new ArrayList<>();

            for (AbstractFactoryStudent student : _players) {
                if (student.nextRoundSkipped())  {
                    student.set_skipNextRoundWEI(false);
                    continue;
                }
                if(student.is_BDE()){
                    continue;
                }
                if(student.has_InformaticsProblem()){
                    continue;
                }

                _diceValue1 = rollDice();
                _diceValue2 = rollDice();

                if(_round == 1){
                    if(_diceValue1 == 6 && _diceValue2 == 3 || _diceValue1 == 3 && _diceValue2 == 6){
                        student.move(26);
                    }
                    if(_diceValue1 == 5 && _diceValue2 == 4 || _diceValue1 == 4 && _diceValue2 == 5){
                        student.move(53);
                    }
                    _board.get(student.get_squareNumber()).execute(student);
                    continue;
                }

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
                _board.get(student.get_squareNumber()).execute(student);
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
        return _board.get(n).get_squareNameEN();
    }
    public String getSquareNameFR(int n) {
        return _board.get(n).get_squareNameFR();
    }

    public int get_round() {
        return _round;
    }
}
