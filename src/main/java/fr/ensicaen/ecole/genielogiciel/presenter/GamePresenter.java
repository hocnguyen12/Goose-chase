package fr.ensicaen.ecole.genielogiciel.presenter;

import fr.ensicaen.ecole.genielogiciel.model.Game;
import fr.ensicaen.ecole.genielogiciel.model.InvalidPlayersCount;
import fr.ensicaen.ecole.genielogiciel.model.InvalidTypeListSize;
import fr.ensicaen.ecole.genielogiciel.model.Model;
import fr.ensicaen.ecole.genielogiciel.model.character.AbstractFactoryStudent;
import fr.ensicaen.ecole.genielogiciel.model.character.ConcreteFactoryDUT;
import fr.ensicaen.ecole.genielogiciel.model.character.ConcreteFactoryPrepa;
import fr.ensicaen.ecole.genielogiciel.view.GameView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
public final class GamePresenter {
    private final Model _model;

    private AbstractFactoryStudent _player1;

    private AbstractFactoryStudent _player2;
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

        _player1 = new ConcreteFactoryPrepa();
        _player2 = new ConcreteFactoryDUT();
        //Fill according to view infos
        List<String> playersTypes= new ArrayList<>();
        playersTypes.add("Prepa");
        playersTypes.add("DUT");
        //playersTypes.add("Licence");
        //playersTypes.add("Prepa");

        // Get player Count from view
        int playerCount = 2;

        try {
            //Initialize game with correct parameters
            String path = "fr/ensicaen/ecole/genielogiciel/board_config_2.json";
            _game.start(playerCount, playersTypes);
            _game.configureBoard(path);
        } catch (InvalidPlayersCount e) {
            throw new RuntimeException(e);
        } catch (InvalidTypeListSize e) {
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

    public ArrayList<Integer> throwDice() {
        return _game.throwDice();
    }

    public List<Integer> executePlayer(ArrayList<Integer> diceValues) {
        List<Integer> positionsList = _game.executePlayer(diceValues);
        int round = _game.getRound();

        return positionsList;
    }
    public AbstractFactoryStudent getPlayer1(){return _player1;}
    public AbstractFactoryStudent getPlayer2(){return _player2;}
}