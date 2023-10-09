package fr.ensicaen.ecole.genielogiciel.view;

import fr.ensicaen.ecole.genielogiciel.LoginMain;
import fr.ensicaen.ecole.genielogiciel.model.Model;
import fr.ensicaen.ecole.genielogiciel.presenter.GamePresenter;

import javafx.animation.PathTransition;
import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Group;
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
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Popup;
import javafx.stage.PopupWindow;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.*;


import static java.util.Objects.isNull;


public final class GameView {
    private GamePresenter _gamePresenter;
    private Stage _stage;
    @FXML
    private TilePane container ;
    @FXML
    private GridPane grid_anchor;
    private String nickName1;

    private String nickName2;

    private static final int MAX_LENGTH = 8;
    private static final int MAX_HEIGHT = 8;

    private int index1 = 0;

    private int index2 = 0;

    private boolean isPlayer1 = true;

    @FXML
    private Button _restart;

    @FXML
    private Button _lancer;

    public static GameView createView(String nickName1) throws IOException {
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

    public static GameView createView(String nickName1,String nickName2) throws IOException {
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
        this.nickName1 = _gamePresenter.getNickname1();
        this.nickName2 = _gamePresenter.getNickname2();
        Button btn_restart = new Button("Recommencer");
        btn_restart.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                restart();
            }
        });
        grid_anchor.getChildren().add(btn_restart);
        grid_anchor.setRowIndex(btn_restart,8);
        grid_anchor.setColumnIndex(btn_restart,0);
        grid_anchor.setAlignment(Pos.CENTER);
        container.setAlignment(Pos.CENTER);
        Circle pawn1 = new Circle(30);
        pawn1.setFill(Color.GREEN);
        Circle pawn2 = new Circle(30);
        pawn2.setFill(Color.RED);
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
                    stack.getChildren().add(pawn1);
                    if (!isNull(nickName2)){
                        stack.getChildren().add(pawn2);
                    }
                }
                stack_array.put(array[i][j],stack);
                container.getChildren().add(stack);
            }
        }
        Button btn_singlePlayer = new Button(LoginMain.getMessageBundle().getString("dice.button.text"));
        Popup popup = new Popup();
        Text text = new Text(LoginMain.getMessageBundle().getString("victory.text"));
        text.setFont(new Font("Arial",20));
        btn_singlePlayer.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (index1 == 63){
                    return;
                }
                index1++;
                stack_array.get(index1).getChildren().add(pawn1);
                if (index1 == 63){
                    if (!popup.isShowing()){
                        popup.show(_stage);
                    }
                }
            }

        });
        popup.getContent().add(text);
        Button btn_multiPlayer = new Button("Lancer");
        btn_multiPlayer.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                if (isPlayer1){
                    if (index1 == 63){
                        return;
                    }
                    index1++;
                    stack_array.get(index1).getChildren().add(pawn1);
                    if (index1 == 63){
                        if (!popup.isShowing()){
                            popup.show(_stage);
                        }
                    }
                    isPlayer1 = false;
                    return;
                }
                else {
                    if (index2 == 63){
                        return;
                    }
                    index2++;
                    stack_array.get(index2).getChildren().add(pawn2);
                    if (index2 == 63){
                        if (!popup.isShowing()){
                            popup.show(_stage);
                        }
                    }
                    isPlayer1 = true;
                    return;
                }
            }
        });
        Text player_name1 = new Text(this.nickName1);
        container.getChildren().add(player_name1);
        if (!isNull(this.nickName2)){
            Text player_name2 = new Text(this.nickName2);
            container.getChildren().add(player_name2);
        }
        if (isNull(nickName2)){
            _lancer = btn_singlePlayer;
        }
        else {
            _lancer = btn_multiPlayer;
        }
    }

    private void restart() {
        _stage.close();
        Platform.runLater(() -> {
            try {
                new LoginMain().start(new Stage());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }

    public void show() {
        _stage.show();
    }

    private void onKeyPressed( KeyCode code ) {
        if (code == KeyCode.SPACE) {
            _gamePresenter.runGameLoop();
        }
    }


}

