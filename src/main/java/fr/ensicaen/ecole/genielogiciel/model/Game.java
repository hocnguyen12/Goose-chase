package fr.ensicaen.ecole.genielogiciel.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private final List<AbstractFactoryStudent> _players = new ArrayList<>();
    private int _currentPlayer;
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
        _boardLength = 64;
        _currentPlayer = 0;
    }

    public void start(int playersCount, List<String> playerTypes, String configPath) throws InvalidPlayersCount {
        //example : playerTypes = ["Prepa", "Licence", "DUT", "Prepa"]
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
                    sPrepa.setName("Player " + (i + 1));
                    _players.add(sPrepa);
                    break;
                case "Licence":
                    System.out.println("new Licence");
                    AbstractFactoryStudent sLicence = new ConcreteFactoryLicence();
                    sLicence.setName("Player " + (i + 1));
                    _players.add(sLicence);
                    break;
                case "DUT":
                    System.out.println("new DUT");
                    AbstractFactoryStudent sDUT = new ConcreteFactoryDUT();
                    sDUT.setName("Player " + (i + 1));
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
        _board = _config.getSquares();

        //@TEST
        System.out.println("Board : ");
        _config.displayboard();
    }

    public List<Integer> executePlayer() {
        System.out.println("\n*** ROUND : " + _round + "***");
        if (gameIsFinished()) {
            return null;
        }

        AbstractFactoryStudent student = _players.get(_currentPlayer);
        student.resetRoundPositions();
        System.out.println("Au tour de : " + student.getName() + " (skill :" + student.getSkillLevel() + ")");
        _diceValue1 = rollDice();
        _diceValue2 = rollDice();
        if (student.nextRoundSkipped()) {
            System.out.println("#Round skipped");
            student.setSkipNextRoundWEI(false);
            student.addRoundPositions(student.getSquareNumber());
        } else if (student.isBDE()) {
            System.out.println("#bde");
            student.addRoundPositions(student.getSquareNumber());
        } else if (student.hasInformaticsProblem()) {
            System.out.println("#informatics");
            student.addRoundPositions(student.getSquareNumber());
        } else if (_round == 1) {
                if (_diceValue1 == 6 && _diceValue2 == 3 || _diceValue1 == 3 && _diceValue2 == 6) {
                    student.move(26);
                    System.out.println("Square : N" + student.getSquareNumber() + " : " + getSquareName(student.getSquareNumber()));
                    student.addRoundPositions(student.getSquareNumber());
                    _board.get(student.getSquareNumber()).execute(student, 26, _board);
                }
                if (_diceValue1 == 5 && _diceValue2 == 4 || _diceValue1 == 4 && _diceValue2 == 5) {
                    student.move(53);
                    System.out.println("Square : N" + student.getSquareNumber() + " : " + getSquareName(student.getSquareNumber()));
                    student.addRoundPositions(student.getSquareNumber());
                    _board.get(student.getSquareNumber()).execute(student, 53, _board);
                } else {
                    int diceTotal = 0;
                    if (student.getStudent() instanceof Dilettante) {
                        diceTotal = (_diceValue1 + _diceValue2) / 2;
                    } else if (student.getStudent() instanceof Diligent) {
                        diceTotal = _diceValue1 + _diceValue2;
                    } else if (student.getStudent() instanceof Brilliant) {
                        diceTotal = (_diceValue1 + _diceValue2) * 2;
                    }
                    System.out.println("dice : " + diceTotal);
                    student.move(diceTotal);
                    System.out.println("Square : N" + student.getSquareNumber() + " : " + getSquareName(student.getSquareNumber()));
                    student.addRoundPositions(student.getSquareNumber());
                    _board.get(student.getSquareNumber()).execute(student, diceTotal, _board);
                }
            } else {
            int diceTotal = 0;
            if (student.getStudent() instanceof Dilettante) {
                diceTotal = (_diceValue1 + _diceValue2) / 2;
            } else if (student.getStudent() instanceof Diligent) {
                diceTotal = _diceValue1 + _diceValue2;
            } else if (student.getStudent() instanceof Brilliant) {
                diceTotal = (_diceValue1 + _diceValue2) * 2;
            }
            System.out.println("dice : " + diceTotal);
            student.move(diceTotal);
            System.out.println("Square : N" + student.getSquareNumber() + " : " + getSquareName(student.getSquareNumber()));
            student.addRoundPositions(student.getSquareNumber());
            _board.get(student.getSquareNumber()).execute(student, diceTotal, _board);
        }
        if (_currentPlayer == _players.size() - 1) {
            _currentPlayer = 0;
            _round++;
        } else {
            _currentPlayer++;
        }
        return student.getRoundPositions();
    }

    /*
    public List<Integer> executeRound() {
        if (_round > 100) {
            System.out.println("BUG PARTIE INFINIE");
            return null;
        }

        System.out.println("\n*** ROUND : " + _round + "***");
        List<Integer> positionsList = new ArrayList<>();

        for (AbstractFactoryStudent student : _players) {
            if (gameIsFinished()) {
                return null;
            }
            System.out.println("Au tour de : " + student.getName() + " (skill :" + student.getSkillLevel() + ")");
            if (student.nextRoundSkipped()) {
                System.out.println("#Round skipped");
                student.setSkipNextRoundWEI(false);
                positionsList.add(student.getSquareNumber());
                continue;
            }
            if (student.isBDE()) {
                System.out.println("#bde");
                positionsList.add(student.getSquareNumber());
                continue;
            }
            if (student.hasInformaticsProblem()) {
                System.out.println("#informatics");
                positionsList.add(student.getSquareNumber());
                continue;
            }
            _diceValue1 = rollDice();
            _diceValue2 = rollDice();
            if (_round == 1) {
                if (_diceValue1 == 6 && _diceValue2 == 3 || _diceValue1 == 3 && _diceValue2 == 6) {
                    student.move(26);
                }
                if (_diceValue1 == 5 && _diceValue2 == 4 || _diceValue1 == 4 && _diceValue2 == 5) {
                    student.move(53);
                } else {
                    int diceTotal = 0;
                    if (student.getStudent() instanceof Dilettante) {
                        diceTotal = (_diceValue1 + _diceValue2) / 2;
                    } else if (student.getStudent() instanceof Diligent) {
                        diceTotal = _diceValue1 + _diceValue2;
                    } else if (student.getStudent() instanceof Brilliant) {
                        diceTotal = (_diceValue1 + _diceValue2) * 2;
                    }
                    System.out.println("dice : " + diceTotal);
                    student.move(diceTotal);
                }
                System.out.println("Square : N" + student.getSquareNumber() + " : " + getSquareName(student.getSquareNumber()));
                _board.get(student.getSquareNumber()).execute(student, 0, _board);
                positionsList.add(student.getSquareNumber());
                continue;
            }
            int diceTotal = 0;
            if (student.getStudent() instanceof Dilettante) {
                diceTotal = (_diceValue1 + _diceValue2) / 2;
            } else if (student.getStudent() instanceof Diligent) {
                diceTotal = _diceValue1 + _diceValue2;
            } else if (student.getStudent() instanceof Brilliant) {
                diceTotal = (_diceValue1 + _diceValue2) * 2;
            }
            System.out.println("dice : " + diceTotal);
            student.move(diceTotal);
            System.out.println("Square : N" + student.getSquareNumber() + " : " + getSquareName(student.getSquareNumber()));
            _board.get(student.getSquareNumber()).execute(student, diceTotal, _board);
            positionsList.add(student.getSquareNumber());
        }
        _round++;
        return positionsList;
    }*/

    int rollDice() {
        return 1 + (int)(Math.random() * 6);
    }

    public boolean gameIsFinished(){
        for (AbstractFactoryStudent student : _players) {
            if (student.getSquareNumber() == 63) {
                return true;
            }
        }

        boolean allPlayersBlocked = true;
        for (AbstractFactoryStudent player : _players) {
            if (!player.isBDE() && !player.hasInformaticsProblem()) {
                allPlayersBlocked = false;
                break;  // Si un joueur n'est pas bloqué sur l'une des deux cases, la partie n'est pas terminée
            }
        }
        if (allPlayersBlocked) {
            System.out.println("TOUT LE MONDE EST BLOQUE");
            return true;
        }
        return false;
    }

    public String getSquareName(int n) {
        return _board.get(n).getSquareName();
    }

    public int get_round() {
        return _round;
    }
}
