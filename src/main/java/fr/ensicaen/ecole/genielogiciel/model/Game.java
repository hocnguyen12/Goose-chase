package fr.ensicaen.ecole.genielogiciel.model;

import fr.ensicaen.ecole.genielogiciel.model.character.*;
import fr.ensicaen.ecole.genielogiciel.json.BoardConfig;
import fr.ensicaen.ecole.genielogiciel.json.BoardConfigReader;
import fr.ensicaen.ecole.genielogiciel.model.square.Square;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final List<AbstractFactoryStudent> _players = new ArrayList<>();
    private int _currentPlayer;
    private List<Square> _board;
    private int _diceValue1;
    private int _diceValue2;
    private int _round;
    private int _averageSalary;
    private int _diceTotal;

    public Game() {
        _diceValue1 = 0;
        _diceValue2 = 0;
        _round = 1;
        _currentPlayer = 0;
        getWageFromWeb();
    }

    // for test only
    public List<AbstractFactoryStudent> getPlayers() {
        return _players;
    }

    public void clean() {
        _players.clear();
        _board.clear();
        _round = 1;
        _currentPlayer = 0;
        _board = null;
    }

    public void start(int playersCount, List<String> playerTypes) throws InvalidPlayersCount, InvalidTypeListSize {
        //example : playerTypes = ["Prepa", "Licence", "DUT", "Prepa"]
        if (playersCount < 1 || playersCount > 4) {
            throw new InvalidPlayersCount("Player count must be between 1 and 4");
        }
        if (playerTypes.size() != playersCount) {
            throw new InvalidTypeListSize("Player Types List must be same size as player count");
        }
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

        BoardConfig _config;
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

    public ArrayList<Integer> throwDice() {
        _diceValue1 = rollDice();
        _diceValue2 = rollDice();
        ArrayList<Integer> diceValues = new ArrayList<>();

        diceValues.add(_diceValue1);
        diceValues.add(_diceValue2);

        return diceValues;
    }

    public ArrayList<Integer> executePlayer(ArrayList<Integer> diceValues) {
        System.out.println("\n*** ROUND : " + _round + "***");
        if (gameIsFinished()) {
            return null;
        }

        _diceValue1 = diceValues.get(0);
        _diceValue2 = diceValues.get(1);
        AbstractFactoryStudent student = _players.get(_currentPlayer);
        student.resetRoundPositions();
        System.out.println("Au tour de : " + student.getName() + " (skill :" + student.getSkillLevel() + ")");

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
        } else if (student.getSquareNumber() == 0) {
            if (_diceValue1 == 6 && _diceValue2 == 3 || _diceValue1 == 3 && _diceValue2 == 6) {
                student.move(26);
                System.out.println("Square : N" + student.getSquareNumber() + " : " + getSquareName(student.getSquareNumber()));
                student.addRoundPositions(student.getSquareNumber());
                _board.get(student.getSquareNumber()).execute(student, 0, _board);
            } else if (_diceValue1 == 5 && _diceValue2 == 4 || _diceValue1 == 4 && _diceValue2 == 5) {
                student.move(53);
                System.out.println("Square : N" + student.getSquareNumber() + " : " + getSquareName(student.getSquareNumber()));
                student.addRoundPositions(student.getSquareNumber());
                _board.get(student.getSquareNumber()).execute(student, 0, _board);
            } else {
                computeDiceTotalAndExecuteSquare(student);
            }
        } else {
            computeDiceTotalAndExecuteSquare(student);
        }
        if (_currentPlayer == _players.size() - 1) {
            _currentPlayer = 0;
            _round++;
        } else {
            _currentPlayer++;
        }
        return student.getRoundPositions();
    }

    private void computeDiceTotalAndExecuteSquare(AbstractFactoryStudent student) {
        if (student.getStudent() instanceof Dilettante) {
            _diceTotal = (_diceValue1 + _diceValue2) / 2;
        } else if (student.getStudent() instanceof Diligent) {
            _diceTotal = _diceValue1 + _diceValue2;
        } else if (student.getStudent() instanceof Brilliant) {
            _diceTotal = (_diceValue1 + _diceValue2) * 2;
        }
        System.out.println("dice : " + _diceTotal);
        student.move(_diceTotal);
        System.out.println("Square : N" + student.getSquareNumber() + " : " + getSquareName(student.getSquareNumber()));
        student.addRoundPositions(student.getSquareNumber());
        _board.get(student.getSquareNumber()).execute(student, _diceTotal, _board);
    }

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

    public void getWageFromWeb() {
        try {
            String url = "https://www.ensicaen.fr/formation/insertion-professionnelle/";
            Document document = Jsoup.connect(url).get();
            Elements h4Elements = document.select("h4");

            // Vérifiez s'il y a au moins deux éléments h4
            if (h4Elements.size() >= 2) {
                // Récupérez le deuxième élément h4 (indice 1, car l'indice commence à 0)
                Element secondH4 = h4Elements.get(1);

                String salary = secondH4.text().replace(" ", "").replace("€", "");
                _averageSalary = Integer.parseInt(salary);
            } else {
                _averageSalary = 38500;
            }
        } catch (Exception e) {
            _averageSalary = 38500;
        }
    }

    public ArrayList<String> computeWages() {
        float averageSkill = (float) _players.stream()
                .mapToInt(AbstractFactoryStudent::getSkillLevel)
                .average()
                .orElse(0.0);

        ArrayList<String> salaryList = new ArrayList<>();
        for (AbstractFactoryStudent player : _players) {
            float coeff = (float) (0.5 * (player.getSkillLevel() - averageSkill) / averageSkill);
            salaryList.add(Math.round(_averageSalary + coeff * _averageSalary) + " €");
        }

        return salaryList;
    }

    public String getSquareName(int n) {
        return _board.get(n).getSquareName();
    }

    public int getRound() {
        return _round;
    }

    public int getDiceTotal() {
        return _diceTotal;
    }
}
