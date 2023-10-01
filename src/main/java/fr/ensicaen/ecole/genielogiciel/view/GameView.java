package fr.ensicaen.ecole.genielogiciel.view;

import fr.ensicaen.ecole.genielogiciel.presenter.GamePresenter;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public final class GameView {
    private GamePresenter _gamePresenter;
    private Stage _stage;

    @FXML
    private TilePane container ;

    public static GameView createView() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(GameView.class.getResource("Board.fxml"));
        Parent root = fxmlLoader.load();
        final GameView view = fxmlLoader.getController();
        fxmlLoader.setController(view);
        Scene scene = new Scene(root, 1000, 1000);
        Stage stage = new Stage();
        stage.setScene(scene);
        view._stage = stage;
        scene.addEventHandler(KeyEvent.KEY_PRESSED, event -> view.onKeyPressed(event.getCode()));
        return view;
    }

    public void setPresenter( GamePresenter gamePresenter ) {
        _gamePresenter = gamePresenter;
    }

    public void show() {
        _stage.show();
    }

    private void onKeyPressed( KeyCode code ) {
        if (code == KeyCode.SPACE) {
            _gamePresenter.runGameLoop();
        }
    }
    public void initialize() {
        // Code pour une grille 8*8
        /*for (int x = 0; x < 64; x++) {
                Rectangle rectangle = new Rectangle(80,80);
                rectangle.setStyle("-fx-fill: white;-fx-stroke : black");
                container.getChildren().add(rectangle);
        }*/
        StackPane stack1 = new StackPane();
        container.setAlignment(Pos.CENTER);
        Rectangle rect1 = new Rectangle(80,80);
        rect1.setStyle("-fx-fill: white;-fx-stroke : black");
        Text text1 = new Text("1");
        stack1.getChildren().addAll(rect1,text1);
        container.getChildren().add(stack1);
        StackPane stack2 = new StackPane();
        Rectangle rect2 = new Rectangle(80,80);
        rect2.setStyle("-fx-fill: white;-fx-stroke : black");
        Text text2 = new Text("2");
        stack2.getChildren().addAll(rect2,text2);
        container.getChildren().add(stack2);
    }
}
