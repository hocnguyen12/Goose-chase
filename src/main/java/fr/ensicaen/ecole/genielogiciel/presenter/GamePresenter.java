package fr.ensicaen.ecole.genielogiciel.presenter;

import fr.ensicaen.ecole.genielogiciel.model.Game;
import fr.ensicaen.ecole.genielogiciel.model.Model;
import fr.ensicaen.ecole.genielogiciel.view.GameView;

public final class GamePresenter {
    private final Model _model;
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
        Game g = new Game();
        g.start();


    }

    private void update() {
        // Update the model
    }

    private void render() {
        // Display the result on the view
        //_view.toto();
    }
}