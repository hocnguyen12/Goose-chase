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

    public void launchGame( String nickName1, String nickName2 ) {
        if (nickName1.isEmpty() && nickName2.isEmpty()) {
            _view.displayError(LoginMain.getMessageBundle().getString("error.nickname"));
        } else {
            if (nickName1.isEmpty()){
                try {
                    createAndDisplayGameView(nickName2);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else if (nickName2.isEmpty()){
                try {
                    createAndDisplayGameView(nickName1);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else {
                try {
                    createAndDisplayGameView(nickName1,nickName2);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            _view.close();
        }
    }

    private void createAndDisplayGameView( String nickName ) throws IOException {
        GameView view = GameView.createView(nickName);
        GamePresenter gamePresenter = new GamePresenter(nickName);
        view.setPresenter(gamePresenter);
        gamePresenter.setView(view);
        view.show();
    }

    private void createAndDisplayGameView( String nickName1, String nickName2 ) throws IOException {
        GameView view = GameView.createView(nickName1,nickName2);
        GamePresenter gamePresenter = new GamePresenter(nickName1,nickName2);
        view.setPresenter(gamePresenter);
        gamePresenter.setView(view);
        view.show();
    }
}
