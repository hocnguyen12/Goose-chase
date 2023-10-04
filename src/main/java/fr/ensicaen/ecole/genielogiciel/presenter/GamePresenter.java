package fr.ensicaen.ecole.genielogiciel.presenter;

import fr.ensicaen.ecole.genielogiciel.model.Game;
import fr.ensicaen.ecole.genielogiciel.model.Model;
import fr.ensicaen.ecole.genielogiciel.view.GameView;

public final class GamePresenter {
    private final Model _model;
    private Game _game;
    private GameView _view;
    private boolean _end = false;

    public GamePresenter( String nickName ) {
        _model = new Model();
        _model.setNickname(nickName);
    }

    public void setView( GameView view ) {
        _view = view;
    }

    public void runGameLoop() {
        System.out.println("Et c'est parti...");
        _game = new Game();
        _game.start();
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
        int previous_position = _game.get_playerPosition();
        System.out.println("PREVIOUS " + previous_position);
        int flag = _game.executeRound();
        int diceValue = _game.get_diceValue();
        displayDiceValue(diceValue);
        if (_game.get_playerPosition() == 4){
            System.out.println("Case bonus : +1");
            _game.caseBonus();
            _view.moveForward();
        }
        if (flag == -1) {
            System.out.println("arrivée dépassée, il faut avancer de " + (_game.get_length() - previous_position - 1));
            for (int j = 0; j < (_game.get_length() - previous_position - 1); j++) {
                _view.moveForward();
            }
            return;
        } else {
            for (int i = 0; i < diceValue; i++) {
                _view.moveForward();
            }
        }
    }

    public void displayDiceValue(int value) {
        _view.displayValue(value);
    }
}