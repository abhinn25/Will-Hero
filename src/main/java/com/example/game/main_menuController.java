package com.example.game;

import javafx.animation.*;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class main_menuController implements Initializable {
    gameController controller;
    Scene scene;
    @FXML
    private AnchorPane creditscreen;
    @FXML
    private ImageView greenorc;

    @FXML
    private ImageView hero;

    @FXML
    private ImageView redorc;

    @FXML
    private Button continue_button;

    @FXML
    private Button credits_button;

    @FXML
    private Button exit_button;

    @FXML
    private Button newgame_button;

    @FXML
    private Label welcomeText;

    @FXML
    private ListView<String> list_savedgames;


    String[] savedgames = {"Game1","Game2","Game3"};

    String currentGame;

    @FXML
    void continue_game(ActionEvent event) {
        list_savedgames.setPrefHeight(savedgames.length*25);
            Custom_animation.fade(list_savedgames,1,700).play();
    }

    @FXML
    void exit(ActionEvent event) {
        Stage stage = (Stage) exit_button.getScene().getWindow();
        stage.close();

    }

    @FXML
    void show_credits(ActionEvent event) {
        Custom_animation.fade(creditscreen,1,1000).play();
    }

    @FXML
    void start_new_game(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("game.fxml"));
        Parent root = fxmlLoader.load();
        controller = fxmlLoader.getController();
        scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();

        stage.setTitle("level");
        stage.setScene(scene);
        controller.setupGame(event);
        stage.setResizable(false);
        stage.show();

//        Timeline timeline = new Timeline();
//        timeline.setCycleCount(Timeline.INDEFINITE);
//        timeline.setAutoReverse(true);
//        KeyValue kv = new KeyValue(hero.yProperty(), -200);
//        KeyValue kv1 = new KeyValue(hero.yProperty(), +200);
//
//
//        KeyFrame kf = new KeyFrame(Duration.millis(500), kv);
//        KeyFrame kf2 = new KeyFrame(Duration.millis(500), kv1);
//        timeline.getKeyFrames().add(kf);
//        timeline.getKeyFrames().add(kf2);





        scene.setOnKeyPressed(event1 -> {

            if(event1.getCode()== KeyCode.D){
                controller.movescenery(event1);

            }
            if(event1.getCode()== KeyCode.W){
                controller.jump(event1);

            }
            if(event1.getCode()== KeyCode.Q){
                controller.player_dead(event1);

            }


        });



    }

    public void main_menu_animation(){

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), ev -> {
            new SequentialTransition(redorc,Custom_animation.translate(redorc,0,-20,300),Custom_animation.translate(redorc,0,20,200)).play();
            new SequentialTransition(greenorc,Custom_animation.translate(greenorc,0,-20,300),Custom_animation.translate(greenorc,0,20,200)).play();

        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();



    }


    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {



        list_savedgames.getItems().addAll(savedgames);

        list_savedgames.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {

                currentGame = list_savedgames.getSelectionModel().getSelectedItem();
                System.out.println(currentGame);
            }
            ;

        });


    }
}