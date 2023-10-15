package fr.ensicaen.ecole.genielogiciel.view;

import fr.ensicaen.ecole.genielogiciel.presenter.LoginPresenter;
import fr.ensicaen.ecole.genielogiciel.LoginMain;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class LoginView {
    private LoginPresenter _presenter;

    private static FXMLLoader loader;
    private Stage _stage;

    @FXML
    private Label _player1;

    @FXML
    private Label _player2;
    @FXML
    private TextField _nickName1;

    @FXML
    private TextField _nickName2;
    @FXML
    private Label _errorLabel;

    @FXML
    private Button _launchGame;
    @FXML
    private ComboBox<String> combo_language;

    @FXML
    private ComboBox<String> combo_board;
    @FXML
    private ComboBox<String> combo_hardskill1;
    @FXML
    private ComboBox<String> combo_hardskill2;
    static String _path = "fr/ensicaen/ecole/genielogiciel/board_config_2.json";
    static String language = "Français";
    static String _hardskill1 = "Prepa";
    static String _hardskill2 = "Prepa";

    public static String getLanguage(){ return language;}

    public void setPresenter( LoginPresenter presenter ) {
        _presenter = presenter;
        ObservableList<String> options = FXCollections.observableArrayList(
                "Français",
                "Anglais"
        );
        combo_language.setItems(options);
        combo_language.setEditable(true);
        combo_language.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue selected, String old_language, String new_Language) {
                language = new_Language;
                loader.setResources(LoginMain.getMessageBundle());
                _player1.setText(LoginMain.getMessageBundle().getString("login1.message.text"));
                _player2.setText(LoginMain.getMessageBundle().getString("login2.message.text"));
                _launchGame.setText(LoginMain.getMessageBundle().getString("launch.button.text"));
            }

        });

        ObservableList<String> boardOptions = FXCollections.observableArrayList(
                "Configuration de base",
                "Configuration aléatoire"
        );
        combo_board.setItems(boardOptions);
        combo_board.setEditable(true);
        final String[] selectedBoardFile = {null}; // Variable final pour stocker le nom du fichier sélectionné
        combo_board.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> selected, String old_board, String new_board) {
                if ("Configuration de base".equals(new_board)) {
                    _path = "fr/ensicaen/ecole/genielogiciel/board_config_2.json";
                } else if ("Configuration aléatoire".equals(new_board)) {
                    _path = "fr/ensicaen/ecole/genielogiciel/board_config_1.json";
                }
            }
        });


        ObservableList<String> hardskillOption = FXCollections.observableArrayList(
                "Prepa",
                "DUT", "Licence"
        );
        combo_hardskill1.setItems(hardskillOption);
        combo_hardskill1.setEditable(true);
        combo_hardskill1.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> selected, String old_hardskill, String new_hardskill) {
                _hardskill1 = new_hardskill;
            }
        });
        combo_hardskill2.setItems(hardskillOption);
        combo_hardskill2.setEditable(true);
        combo_hardskill2.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> selected, String old_hardskill, String new_hardskill) {
                _hardskill2 = new_hardskill;
            }
        });
    }

    public static LoginView createView( Stage primaryStage, String  resourceName) throws IOException {
        loader = new FXMLLoader(LoginView.class.getResource(resourceName), LoginMain.getMessageBundle());
        Parent root = loader.load();
        // getController() does not return a presenter but actually a class of the View
        // if we want the presenter independent of the API JavaFX.
        LoginView view = loader.getController();

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        view._stage = primaryStage;
        return view;
    }

    public void show() {
        _stage.show();
    }

    public void close() {
        _stage.close();
    }

    public void displayError( String message ) {
        _errorLabel.setText(message);
    }

    @FXML
    private void launchGame() {
        ArrayList<String> _hardskill = new ArrayList<>();
        _hardskill.add(_hardskill1);
        _hardskill.add(_hardskill2);

        _presenter.launchGame(_nickName1.getText(),_nickName2.getText(), _path, _hardskill);
    }
}
