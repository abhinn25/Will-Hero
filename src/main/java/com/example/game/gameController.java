package com.example.game;

import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class gameController implements Initializable {


    private static Stage stage;
    private static Scene gamescene;
    private  ArrayList<ImageView> Orcs_list = new ArrayList<>();
    private  ArrayList<ImageView> Platform_list = new ArrayList<>();




    @FXML
    private ImageView mainmenu_button_playerdead;

    @FXML
    private ImageView resurrect_button;
    @FXML
    private Group dead_menu;

    @FXML
    private ImageView hero;

    @FXML
    private ImageView pause_button;

    @FXML
    private Button mainmenu_button;

    @FXML
    private Button resume_button;

    @FXML
    private Button save_button;

    void movescenery(KeyEvent event){

        for(ImageView x : Platform_list){
            Custom_animation.translate(x,-55,0,80).play();
        }

        for(ImageView x : Orcs_list){
            Custom_animation.translate(x,-55,0,80).play();
        }
    }
    void setupGame(ActionEvent event){
        gamescene= hero.getScene();
        Orc[] orcs = new Orc[16];


        Platform p1 = new Platform(500,550,10);
        Platform p2 = new Platform(820 , 500,10 );
        Platform p3 = new Platform(1100,500, 10);
        Platform p4 = new Platform(1410,400,10);
        Platform p5 = new Platform(1740,605,10);
        Platform p6 = new Platform(2100,580,10);
        Platform p7 = new Platform(2400,500,10);
        Platform p8 = new Platform(2780,400,10);
        Platform p9 = new Platform(50,560,10);

        Platform_list.add(p1.getPlatform());
        Platform_list.add(p2.getPlatform());
        Platform_list.add(p3.getPlatform());
        Platform_list.add(p4.getPlatform());
        Platform_list.add(p5.getPlatform());
        Platform_list.add(p6.getPlatform());
        Platform_list.add(p7.getPlatform());
        Platform_list.add(p8.getPlatform());
        Platform_list.add(p9.getPlatform());

        ArrayList<Platform> list_of_platforms = new ArrayList<Platform>();
        list_of_platforms.add(p1);
        list_of_platforms.add(p2);
        list_of_platforms.add(p3);
        list_of_platforms.add(p4);
        list_of_platforms.add(p5);
        list_of_platforms.add(p6);
        list_of_platforms.add(p7);
        list_of_platforms.add(p8);
        int i = 0 ;
        for(Platform temp : list_of_platforms){
            double r1 = Math.random();
            orcs[i] = new Orc(temp.getPlatform().getX()+110+90*r1, temp.getPlatform().getY()-50, 10);
            double r2 = Math.random();
            orcs[i+1] = new Orc(temp.getPlatform().getX()+80*r2, temp.getPlatform().getY()-50, 10);
            Orcs_list.add(orcs[i].getOrc());
            Orcs_list.add(orcs[i+1].getOrc());
            i=i+2;
        }
        ((AnchorPane)gamescene.getRoot()).getChildren().addAll(Orcs_list);
        ((AnchorPane)gamescene.getRoot()).getChildren().addAll(Platform_list);
    }
    void player_dead(KeyEvent event){
        Custom_animation.translate(dead_menu,0,-700,400).play();
        for(ImageView x : Platform_list){
            x.setOpacity(0.04);
        }

        for(ImageView x : Orcs_list){
            x.setOpacity(0.04);
        }
        hero.setOpacity(0.04);
    }
    @FXML
    void mainmenu(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("main_menu.fxml"));
        Parent root = fxmlLoader.load();
        main_menuController controller = fxmlLoader.getController();
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("level");
        stage.setResizable(false);
        stage.setScene(scene);
        controller.main_menu_animation();

    }

    @FXML
    void resume(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("game.fxml"));
        stage.setTitle("game");
        stage.setResizable(false);
        stage.setScene(gamescene);


    }

    @FXML
    void save(ActionEvent event) {

    }

    @FXML
    void pause_game(MouseEvent event) throws IOException {
        gamescene = hero.getScene();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("pause_menu.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("pause_menu");
        stage.setScene(scene);
        stage.setResizable(false);
        System.out.println(stage);

    }


    public void jump(KeyEvent event) {
        System.out.println("rsthgh");
//        System.out.printf("level");
//        TranslateTransition translate = new TranslateTransition();
//        translate.setNode(hero);
//        translate.setDuration(Duration.millis(250));
//        translate.setCycleCount(TranslateTransition.INDEFINITE);
//        translate.setByY(-100);
//        translate.setAutoReverse(true);
//        translate.play();

//        Timeline timeline = new Timeline();
//        timeline.setCycleCount(Timeline.INDEFINITE);
//        timeline.setAutoReverse(true);
        //Custom_animation.translate(hero,0,-250,1000);
      // Custom_animation.translate(hero,0,250,1000)
    new SequentialTransition(hero,Custom_animation.translate(hero,0,-100,400),Custom_animation.translate(hero,0,100,300)).play();


//        KeyValue kv = new KeyValue(hero.yProperty(), -200);
//        KeyValue kv1 = new KeyValue(hero.yProperty(), +200);
//        KeyFrame kf = new KeyFrame(Duration.millis(500), kv);
//        KeyFrame kf2 = new KeyFrame(Duration.millis(500), kv1);
//        timeline.getKeyFrames().add(kf);
//        timeline.getKeyFrames().add(kf2);
//
//        timeline.play();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}


