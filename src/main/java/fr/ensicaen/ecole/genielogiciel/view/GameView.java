package fr.ensicaen.ecole.genielogiciel.view;

import fr.ensicaen.ecole.genielogiciel.LoginMain;
import fr.ensicaen.ecole.genielogiciel.presenter.GamePresenter;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Popup;
import javafx.stage.Stage;

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

    private Color[] colorList = new Color[]{Color.RED, Color.PURPLE, Color.WHITE, Color.TURQUOISE, Color.PINK, Color.BROWN, Color.ORANGE, Color.WHITE,
            Color.PURPLE, Color.PINK, Color.WHITE, Color.TURQUOISE, Color.WHITE, Color.YELLOW, Color.BROWN, Color.PINK,Color.WHITE, Color.WHITE, Color.WHITE,
            Color.WHITE, Color.YELLOW, Color.PINK, Color.WHITE, Color.WHITE,Color.WHITE, Color.WHITE, Color.LIGHTBLUE, Color.WHITE, Color.WHITE,
            Color.GREEN, Color.WHITE,Color.WHITE, Color.PINK, Color.WHITE, Color.GREY, Color.WHITE, Color.WHITE, Color.WHITE, Color.BLACK,Color.WHITE,
            Color.LIGHTBLUE, Color.WHITE, Color.WHITE, Color.WHITE, Color.GREY, Color.WHITE, Color.WHITE,Color.YELLOW,
            Color.LIGHTGREEN, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.DARKGREEN, Color.WHITE,Color.LIGHTBLUE,
            Color.WHITE, Color.WHITE, Color.MEDIUMVIOLETRED, Color.WHITE, Color.WHITE, Color.BLACK, Color.WHITE, Color.TEAL};

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
        Button btn_restart = new Button(LoginMain.getMessageBundle().getString("restart.button.text"));
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
        drawBoard(array,stack_array,pawn1,pawn2);
        Text whosturn = new Text(LoginMain.getMessageBundle().getString("whosturn.text"));
        placeNode(grid_anchor,whosturn,0,9);
        Button btn_singlePlayer = new Button(LoginMain.getMessageBundle().getString("dice.button.text"));
        Popup popup = new Popup();
        Text text = new Text(LoginMain.getMessageBundle().getString("victory.text"));
        text.setFont(new Font("Arial",20));
        popup.getContent().add(text);
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
        Text player = new Text();
        player.setText(nickName1);
        grid_anchor.getChildren().add(player);
        grid_anchor.setRowIndex(player,0);
        grid_anchor.setColumnIndex(player,10);
        Button btn_multiPlayer = new Button(LoginMain.getMessageBundle().getString("dice.button.text"));
        btn_multiPlayer.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                if (isPlayer1){
                //    index1 = _gamePresenter.executePlayer();
                    player.setText(nickName1);
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
                    player.setText(nickName2);
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

        Text player_name1 = new Text(LoginMain.getMessageBundle().getString("player1.text") + this.nickName1);
        player_name1.setFill(Color.GREEN);
        grid_anchor.getChildren().add(player_name1);
        grid_anchor.setRowIndex(player_name1,1);
        grid_anchor.setColumnIndex(player_name1,9);

        if (!isNull(this.nickName2)){
            Text player_name2 = new Text(LoginMain.getMessageBundle().getString("player2.text") + this.nickName2);
            player_name2.setFill(Color.RED);
            grid_anchor.getChildren().add(player_name2);
            grid_anchor.setRowIndex(player_name2,2);
            grid_anchor.setColumnIndex(player_name2,9);

        }
        if (isNull(nickName2)){
            grid_anchor.getChildren().add(btn_singlePlayer);
            grid_anchor.setRowIndex(btn_singlePlayer,8);
            grid_anchor.setColumnIndex(btn_singlePlayer,2);

        }
        else {
            grid_anchor.getChildren().add(btn_multiPlayer);
            grid_anchor.setRowIndex(btn_multiPlayer,8);
            grid_anchor.setColumnIndex(btn_multiPlayer,1);

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

    private void drawBoard(int[][] array,Map<Integer,StackPane> stack_array,Circle pawn1,Circle pawn2){
        for (int i = 0;i < MAX_LENGTH;i++){
            for (int j = 0;j < MAX_HEIGHT;j++){
                Rectangle rect = new Rectangle(80,80);
                rect.setFill(colorList[array[i][j]]);
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
    }

    public void placeNode(GridPane gridpane, Node node,int row,int col){
        grid_anchor.getChildren().add(node);
        grid_anchor.setRowIndex(node,row);
        grid_anchor.setColumnIndex(node,col);
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

