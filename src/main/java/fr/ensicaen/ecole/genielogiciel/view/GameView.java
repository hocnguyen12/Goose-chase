package fr.ensicaen.ecole.genielogiciel.view;

import fr.ensicaen.ecole.genielogiciel.model.Model;
import fr.ensicaen.ecole.genielogiciel.presenter.GamePresenter;

import javafx.animation.PathTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public final class GameView {
    private GamePresenter _gamePresenter;
    private Stage _stage;

    @FXML
    private TilePane container ;

    private final int MAX_LENGTH = 8;

    private final int MAX_HEIGHT = 8;

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

    private static int x = 0;
    private static int y = 0;
    public void initialize() {
        // Code pour une grille 8*8
        container.setAlignment(Pos.CENTER);
        /*
        int direction = 0; // 0 : right, 1 : down, 2 : left, 3 : up
        int max_length = MAX_LENGTH; // will vary during numbering
        int max_height = MAX_HEIGHT; // will vary during numbering
        int min_length = 0; // will vary during numbering
        int min_height = 0; // will vary during numbering
        for (int i = 0;i < MAX_LENGTH*MAX_HEIGHT;i++){
            Rectangle tile = new Rectangle(80,80);
            tile.setStroke(Color.BLACK);
            tile.setFill(Color.WHITE);
            Text text = new Text(Integer.toString(y*MAX_LENGTH+x));
            GridPane.setColumnIndex(tile,x);
            GridPane.setRowIndex(tile,y);
            GridPane.setColumnIndex(text,x);
            GridPane.setRowIndex(text,y);
            GridPane.setHalignment(text,HPos.CENTER);
            container.getChildren().addAll(tile,text);
            switch(direction){
                case 0 :
                    System.out.println("max_length" + max_length);
                    if (x < max_length - 1){
                        x++;
                        System.out.println("x : "+ x +" y " + y);
                    }
                    else {
                        direction = (direction+1)%4;
                        max_length--;
                        y++;
                        System.out.println("x : "+ x +" y " + y);
                    }
                    break;
                case 1 :
                    if (y < max_height - 1){
                        y++;
                    }
                    else {
                        direction = (direction+1)%4;
                        max_height--;
                        x--;
                    }
                    break;
                case 2 :
                    if (x > min_length){
                        x--;
                    }
                    else {
                        direction = (direction+1)%4;
                        min_length++;
                        y--;
                    }
                    break;
                case 3 :
                    if (y > min_height){
                        y--;
                    }
                    else {
                        direction = (direction+1)%4;
                        min_height++;
                        x++;
                    }
                    break;
            }
        }*/
        StackPane stack1 = new StackPane();
        container.setAlignment(Pos.CENTER);
        Circle pawn1 = new Circle(25);
        pawn1.setStyle("-fx-fill:green");
        Rectangle rect1 = new Rectangle(80,80);
        rect1.setStyle("-fx-fill: white;-fx-stroke : black");
        Text text1 = new Text("1");
        stack1.getChildren().addAll(rect1,text1,pawn1);
        container.getChildren().add(stack1);
        StackPane stack2 = new StackPane();
        Rectangle rect2 = new Rectangle(80,80);
        rect2.setStyle("-fx-fill: white;-fx-stroke : black");
        Text text2 = new Text("2");
        stack2.getChildren().addAll(rect2,text2);
        container.getChildren().add(stack2);
        Button btn = new Button("Lancer");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                stack2.getChildren().add(pawn1);
                stack1.getChildren().remove(pawn1);

            }
        });
        container.getChildren().add(btn);

    }

}
