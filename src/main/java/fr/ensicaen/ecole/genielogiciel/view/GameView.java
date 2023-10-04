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
import java.util.ArrayList;

public final class GameView {
    private GamePresenter _gamePresenter;
    private Stage _stage;

    @FXML
    private TilePane container;

    private final int MAX_LENGTH = 8;

    private final int MAX_HEIGHT = 1;

    private int count = 0;

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

    public void setPresenter(GamePresenter gamePresenter) {
        _gamePresenter = gamePresenter;
    }

    public void show() {
        _stage.show();
    }

    private void onKeyPressed(KeyCode code) {
        if (code == KeyCode.SPACE) {
            _gamePresenter.runGameLoop();
        }
    }

    private static int x = 0;
    private static int y = 0;

    private ArrayList<StackPane> stack_list;
    private Circle pawn;
    private Popup popup_txt;
    private Popup popup_dice;

    public void initialize() {
        // Code pour une grille 8*8
        container.setAlignment(Pos.CENTER);
        pawn = new Circle(30);
        pawn.setFill(Color.GREEN);
        int direction = 0; // 0 : right, 1 : down, 2 : left, 3 : up
        int max_length = MAX_LENGTH; // will vary during numbering
        int max_height = MAX_HEIGHT; // will vary during numbering
        int min_length = 0; // will vary during numbering
        int min_height = 0; // will vary during numbering
        stack_list = new ArrayList<>();
        for (int i = 0; i < MAX_LENGTH * MAX_HEIGHT; i++) {
            Rectangle tile = new Rectangle(80, 80);
            tile.setStroke(Color.BLACK);
            tile.setFill(Color.WHITE);
            Text text = new Text(Integer.toString(y * MAX_LENGTH + x));
            StackPane stack = new StackPane();
            stack.getChildren().addAll(tile, text);
            if (i == 0) {
                stack.getChildren().add(pawn);
            }
            if (i == 4) {
                tile.setStroke(Color.RED);
            }
            stack.setAlignment(Pos.CENTER);
            //TilePane.setColumnIndex(tile,x);
            //GridPane.setRowIndex(tile,y);
            //GridPane.setColumnIndex(text,x);
            //GridPane.setRowIndex(text,y);
            //GridPane.setHalignment(text,HPos.CENTER);
            container.getChildren().add(stack);
            stack_list.add(stack);
            switch (direction) {
                case 0:
                    //System.out.println("max_length" + max_length);
                    if (x < max_length - 1) {
                        x++;
                        //System.out.println("x : "+ x +" y " + y);
                    } else {
                        direction = (direction + 1) % 4;
                        max_length--;
                        y++;
                        //System.out.println("x : "+ x +" y " + y);
                    }
                    break;
                case 1:
                    if (y < max_height - 1) {
                        y++;
                    } else {
                        direction = (direction + 1) % 4;
                        max_height--;
                        x--;
                    }
                    break;
                case 2:
                    if (x > min_length) {
                        x--;
                    } else {
                        direction = (direction + 1) % 4;
                        min_length++;
                        y--;
                    }
                    break;
                case 3:
                    if (y > min_height) {
                        y--;
                    } else {
                        direction = (direction + 1) % 4;
                        min_height++;
                        x++;
                    }
                    break;
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
        Button btn = new Button("Dice Throw");
        popup_txt = new Popup();
        Text text = new Text("Victory !");
        popup_txt.getContent().add(text);

        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //AJOUT PAUL MVP1
                _gamePresenter.nextRound();
            }
        });
        container.getChildren().add(btn);

    }

    public void moveForward() {
        if (count < stack_list.size() - 1) {
            count++;
            stack_list.get(count).getChildren().add(pawn);
        }
/*
        if (count == 4){
            PauseTransition short_delay = new PauseTransition(Duration.seconds(1));
            short_delay.setOnFinished(event2->{count++;stack_list.get(count).getChildren().add(pawn);});
            short_delay.playFromStart();

        }*/
        if (count == 7) {

            if (!popup_txt.isShowing()) {
                popup_txt.show(_stage);
            } else {
                popup_txt.hide();
            }
        }
    }

    // peut afficher n'importe quelle value
    // est utilisée par le presenter pour afficher le dé avec displayValue(_game.getDiceValue());
    /*
    public void displayValue(int value) {
        popup_dice = new Popup();
        Text text = new Text("You got : " + value);
        popup_dice.getContent().add(text);
        if (!popup_dice.isShowing()){
            popup_dice.show(_stage);
        }
        else {
            popup_dice.hide();
        }

    }*/
    public void displayValue(int value) {
        Text diceText = new Text("You got : " + value);

        StackPane dicePane = new StackPane(diceText);
        dicePane.setAlignment(Pos.CENTER);

        popup_dice = new Popup();
        popup_dice.getContent().add(dicePane);

        popup_dice.setX(_stage.getWidth() / 2 - 50);
        popup_dice.setY(_stage.getHeight() / 2 - 100);
        popup_dice.show(_stage);

        PauseTransition pauseTransition = new PauseTransition(Duration.seconds(1));
        pauseTransition.setOnFinished(event -> popup_dice.hide());
        pauseTransition.play();
    }
}
