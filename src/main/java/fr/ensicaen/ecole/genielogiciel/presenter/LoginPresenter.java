package fr.ensicaen.ecole.genielogiciel.presenter;

import fr.ensicaen.ecole.genielogiciel.LoginMain;
import fr.ensicaen.ecole.genielogiciel.view.GameView;
import fr.ensicaen.ecole.genielogiciel.view.LoginView;

import java.io.IOException;

public final class LoginPresenter {
    private LoginView _view;

    public void setView( LoginView view ) {
        _view = view;
    }

    public void launchGame( String nickName1, String nickName2, String path) {
        if (nickName1.isEmpty() && nickName2.isEmpty()) {
            _view.displayError(LoginMain.getMessageBundle().getString("error.nickname"));
        } else {
            if (nickName1.isEmpty()){
                try {
                    createAndDisplayGameView(nickName2, path);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else if (nickName2.isEmpty()){
                try {
                    createAndDisplayGameView(nickName1, path);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else {
                try {
                    createAndDisplayGameView(nickName1,nickName2, path);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            _view.close();
        }
    }

    private void createAndDisplayGameView( String nickName, String path) throws IOException {
        GameView view = GameView.createView(nickName, path);
        GamePresenter gamePresenter = new GamePresenter(nickName, path);
        view.setPresenter(gamePresenter);
        gamePresenter.setView(view);
        view.show();
        gamePresenter.initializeGame();
    }

    private void createAndDisplayGameView( String nickName1, String nickName2, String path ) throws IOException {
        GameView view = GameView.createView(nickName1,nickName2, path);
        GamePresenter gamePresenter = new GamePresenter(nickName1,nickName2, path);
        view.setPresenter(gamePresenter);
        gamePresenter.setView(view);
        view.show();
        gamePresenter.initializeGame();
    }
}
