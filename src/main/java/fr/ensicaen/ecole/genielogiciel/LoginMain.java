package fr.ensicaen.ecole.genielogiciel;

import fr.ensicaen.ecole.genielogiciel.presenter.LoginPresenter;
import fr.ensicaen.ecole.genielogiciel.model.Game;

import fr.ensicaen.ecole.genielogiciel.view.LoginView;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;



public final class LoginMain extends Application {


    public static void main( String[] args ) {
        launch(args);
    }
    public static ResourceBundle getMessageBundle() {

        if (LoginView.getLanguage().equals("Français")) {
            return ResourceBundle.getBundle("fr.ensicaen.ecole.genielogiciel.MessageBundle");
        }
        return ResourceBundle.getBundle("fr.ensicaen.ecole.genielogiciel.MessageBundle_en_US");
    }

    @Override
    public void start( final Stage primaryStage ) throws Exception {
        LoginView view = LoginView.createView(primaryStage, "LoginDialog.fxml");
        LoginPresenter presenter = new LoginPresenter();
        view.setPresenter(presenter);
        presenter.setView(view);
        view.show();
    }
}