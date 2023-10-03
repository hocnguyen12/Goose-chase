package fr.ensicaen.ecole.genielogiciel.model;

import java.util.Scanner;

public class Game {
    private Character _character;
    private Square[] _board;
    private int _length;
    private int _diceValue;

    private int _round;

    public Game() {
        _length = 2;
        _diceValue = 0;
        _round = 0;
        _board = new Square[_length];
    }

    public void start() {
        _character = new Character();
        _board[0] = new StartSquare(0);
        _board[1] = new EndSquare(1);

        while (checkEnd(_board[1]) != 1) {
            System.out.println("round n° :" + _round);
            // for each player in player list
            executeRound(_character);
            _round++;
        }
        System.out.println("Partie terminée !");

    }

    void executeRound(Character c) {
        System.out.println("Faites un choix : ");
        System.out.println("(1) Lancer le dés");
        /*Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                _diceValue = dice();

        }*/
        _diceValue = dice();

        move(c);
        System.out.println("_board.execute n°" + _round);
        _board[c.getSquareNumber()].execute(c);

    }


    void move(Character c) {
        c.setSquareNumber(c.getSquareNumber() + _diceValue);
    }

    int dice() {
        return 1;
    }

    public int checkEnd(Square s){
        if (s.get_character() == null) {
            return 0;
        }
        return 1;

    }
}
