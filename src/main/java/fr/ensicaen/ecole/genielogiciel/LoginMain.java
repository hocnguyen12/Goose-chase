package fr.ensicaen.ecole.genielogiciel;

import fr.ensicaen.ecole.genielogiciel.model.Game;
import fr.ensicaen.ecole.genielogiciel.presenter.LoginPresenter;
import fr.ensicaen.ecole.genielogiciel.view.LoginView;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public final class LoginMain extends Application {
    public static void main( String[] args ) {
        launch(args);
    }

    public static ResourceBundle getMessageBundle() {
        return ResourceBundle.getBundle("fr.ensicaen.ecole.genielogiciel.MessageBundle");
    }

    @Override
    public void start( final Stage primaryStage ) throws Exception {
/*
        LoginView view = LoginView.createView(primaryStage, "LoginDialog.fxml");
        LoginPresenter presenter = new LoginPresenter();
        view.setPresenter(presenter);
        presenter.setView(view);
        view.show();*/

        Game g = new Game();
        List<String> l = new ArrayList<>();
        l.add("Prepa");
        l.add("DUT");
        l.add("Licence");
        l.add("Prepa");
        g.start(4, l);
        g.configureBoard();

        List<Integer> positions = new ArrayList<>();

        System.out.println("ROUND : " + g._round);
        positions = g.executeRound();
        System.out.println(positions);
        while (positions != null) {
            System.out.println("ROUND : " + g._round);
            positions = g.executeRound();
            System.out.println(positions);
        }
    }
}
