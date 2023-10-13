package fr.ensicaen.ecole.genielogiciel.presenter;

import fr.ensicaen.ecole.genielogiciel.model.Game;
import fr.ensicaen.ecole.genielogiciel.model.InvalidPlayersCount;
import fr.ensicaen.ecole.genielogiciel.model.Model;
import fr.ensicaen.ecole.genielogiciel.view.GameView;
import java.util.ArrayList;
import java.util.List;
public final class GamePresenter {
    private final Model _model;
    private Game _game;
    private String _lang = "en";
    private GameView _view;
    private boolean _end = false;

    public GamePresenter( String nickName ) {
        _model = new Model();
        _model.setNickname1(nickName);
    }
    public GamePresenter( String nickName1, String nickName2 ) {
        _model = new Model();
        _model.setNickname1(nickName1);
        _model.setNickname2(nickName2);
    }
    public String getNickname1() {return _model.getNickname1();}
    public String getNickname2() {return _model.getNickname2();}
    public void setView( GameView view ) {
        _view = view;
    }

    public void initializeGame() {
        //initialize language
        _lang = "en";
        //MODEL
        System.out.println("Et c'est parti...");
        _game = new Game();

        //Fill according to view infos
        List<String> playersTypes= new ArrayList<>();
        playersTypes.add("Prepa");
        playersTypes.add("DUT");
        playersTypes.add("Licence");
        playersTypes.add("Prepa");

        // Get player Count from view
        int playerCount = 4;

        try {
            //Initialize game with correct parameters
            String path = "fr/ensicaen/ecole/genielogiciel/board_config_1.json";
            _game.start(playerCount, playersTypes, path);
        } catch (InvalidPlayersCount e) {
            throw new RuntimeException(e);
        }

        //VIEW
        //Create n pawns
    }
    public void runGameLoop() {
        System.out.println("Et c'est parti...");
    }

    private void update() {
        // Update the model
    }

    private void render() {
        // Display the result on the view
        //_view.toto();
    }

    // Notre modele ne gere pas encore les bonus, c'est donc la présentation qui s'en charge
    // QUE pour le MVP 1 pour montrer au client une première gestion des bonus
    // Sinon nextroundregarde la valeur du dé calculée dans le modèle et fait avancer la vue autant de fois que necessaire
    public void nextRound() {
        List<Integer> positionsList = new ArrayList<>();
        //positionsList = _game.executeRound();

        for (int i : positionsList){
            //display pawns at their new square

            if (_lang.equals("en")) {
                _game.getSquareName(i);
            }
        }
        /*
        int previous_position = _game.get_playerPosition();
        System.out.println("PREVIOUS " + previous_position);
        int flag = _game.executeRound();
        int diceValue = _game.get_diceValue();
        displayDiceValue(diceValue);
        if (_game.get_playerPosition() == 4){
            System.out.println("Case bonus : +1");
            _game.caseBonus();
            //_view.moveForward();
        }
        if (flag == -1) {
            System.out.println("arrivée dépassée, il faut avancer de " + (_game.get_boardLength() - previous_position - 1));
            for (int j = 0; j < (_game.get_boardLength() - previous_position - 1); j++) {
                //_view.moveForward();
            }
            return;
        } else {
            for (int i = 0; i < diceValue; i++) {
                //_view.moveForward();
            }
        }*/
    }
}