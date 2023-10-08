package fr.ensicaen.ecole.genielogiciel.presenter;

import fr.ensicaen.ecole.genielogiciel.model.Model;
import fr.ensicaen.ecole.genielogiciel.view.GameView;

public final class GamePresenter {
    private final Model _model;
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
}