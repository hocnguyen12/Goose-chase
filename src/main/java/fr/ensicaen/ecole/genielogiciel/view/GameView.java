package fr.ensicaen.ecole.genielogiciel.view;

import fr.ensicaen.ecole.genielogiciel.model.Model;
import fr.ensicaen.ecole.genielogiciel.presenter.GamePresenter;

import javafx.animation.PathTransition;
import javafx.animation.PauseTransition;
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
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.*;

public final class GameView {
    private GamePresenter _gamePresenter;
    private Stage _stage;
    @FXML
    private TilePane container ;
    @FXML
    private GridPane grid_anchor;

    private static final int MAX_LENGTH = 8;
    private static final int MAX_HEIGHT = 8;
    private int index = 0;

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
            _gamePresenter.initializeGame();
        }
    }


    public void initialize() {
        // Code pour une grille 8*8
        GamePresenter presenter = new GamePresenter("test");
        this.setPresenter(presenter);
        grid_anchor.setAlignment(Pos.CENTER);
        container.setAlignment(Pos.CENTER);
        Circle pawn = new Circle(30);
        pawn.setFill(Color.GREEN);
        Map<Integer,StackPane> stack_array = new HashMap<>();
        int[][] array = SpiralPath.computeSpiralPath(MAX_HEIGHT);
        for (int i = 0;i < MAX_LENGTH;i++){
            for (int j = 0;j < MAX_HEIGHT;j++){
                Rectangle rect = new Rectangle(80,80);
                rect.setFill(Color.WHITE);
                rect.setStroke(Color.BLACK);
                System.out.println("i j :"+i+" "+j);
                Text text = new Text(Integer.toString(array[i][j]));
                StackPane stack = new StackPane();
                stack.getChildren().addAll(rect,text);
                if (i==0 && j == 0) {
                    stack.getChildren().add(pawn);
                }
                stack_array.put(array[i][j],stack);
                //stack_array[i][j].setId(Integer.toString(array[i][j]));

                container.getChildren().add(stack);
            }
        }
        /*StackPane stack1 = new StackPane();
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
        container.getChildren().add(stack2);*/
        Button btn = new Button("Lancer");
        Popup popup = new Popup();
        Text text = new Text("Victoire !");
        popup.getContent().add(text);
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (index == 63){
                    return;
                }
                index++;
                stack_array.get(index).getChildren().add(pawn);
                if (index == 63){
                    if (!popup.isShowing()){
                        popup.show(_stage);
                    }
                }

            }
/*
                if (count == 4){

                    PauseTransition short_delay = new PauseTransition(Duration.seconds(1));
                    short_delay.setOnFinished(event2->{count++;stack_array[x][y].getChildren().add(pawn);});
                    short_delay.playFromStart();

                }
                if (count == 7){

                    if (!popup.isShowing()){
                        popup.show(_stage);
                    }
                    else {
                        popup.hide();
                    }
                }
            }
            */
        });
        container.getChildren().add(btn);
    }
}