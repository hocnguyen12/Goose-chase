package fr.ensicaen.ecole.genielogiciel.presenter;

import fr.ensicaen.ecole.genielogiciel.model.Game;
import fr.ensicaen.ecole.genielogiciel.model.InvalidPlayersCount;
import fr.ensicaen.ecole.genielogiciel.model.InvalidTypeListSize;
import fr.ensicaen.ecole.genielogiciel.model.Model;
import fr.ensicaen.ecole.genielogiciel.model.character.AbstractFactoryStudent;
import fr.ensicaen.ecole.genielogiciel.view.GameView;

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

        //Fill according to view infos
        List<String> playersTypes= new ArrayList<>();
        playersTypes.add("Prepa");
        playersTypes.add("DUT");

        // Get player Count from view
        int playerCount = 2;

        try {
            //Initialize game with correct parameters
            String path = "fr/ensicaen/ecole/genielogiciel/board_config_2.json";
            _game.start(playerCount, playersTypes);
            _game.configureBoard(path);
        } catch (InvalidPlayersCount | InvalidTypeListSize e) {
            throw new RuntimeException(e);
        }

        _player1 = _game.getPlayers().get(0);
        _player2 = _game.getPlayers().get(1);

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

    public ArrayList<Integer> executePlayer(ArrayList<Integer> diceValues) {
        ArrayList<Integer> positionsList = _game.executePlayer(diceValues);
        int round = _game.getRound();

        return positionsList;
    }
    public AbstractFactoryStudent getPlayer1(){return _player1;}
    public AbstractFactoryStudent getPlayer2(){return _player2;}

    public int getSkillLevel1() { return _player1.getSkillLevel();}

    public int getSkillLevel2() {return _player2.getSkillLevel();}

    public ArrayList<String> endGameandGetWages() {
        _game.clean();
        return _game.computeWages();
    }
}