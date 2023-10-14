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

        //Run example

        Game g = new Game();

        int playerCount = 4;
        List<String> l = new ArrayList<>();
        l.add("Prepa");
        l.add("DUT");
        l.add("Licence");
        l.add("Prepa");

        String path = "fr/ensicaen/ecole/genielogiciel/board_config_2.json";
        g.start(playerCount, l);
        g.configureBoard(path);

        List<Integer> positionsList = new ArrayList<>();


        List<Integer> positions = new ArrayList<>();
        for (int i = 0; i < playerCount; i++) {
            List<Integer> diceValues = g.throwDice();
            positions = g.executePlayer((ArrayList<Integer>) diceValues);
            System.out.println(positions);
        }
        while (positions != null) {
            for (int i = 0; i < playerCount; i++) {
                List<Integer> diceValues = g.throwDice();
                positions = g.executePlayer((ArrayList<Integer>) diceValues);
                System.out.println(positions);
            }
        }

        g.getWageFromWeb();
        ArrayList<String> salaryList = g.computeWages();
        for (int i = 0; i < salaryList.size(); i++) {
            System.out.println(salaryList.get(i));
        }
    }
}
