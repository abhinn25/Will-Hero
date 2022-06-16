package com.example.game;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Platform {
    private ImageView Platform;

    Platform(double x,double y, double jump ){
        Platform = new ImageView();
        Platform.setX(x);
        Platform.setY(y);
        Image orc_icon = new Image("file:/C:/Users/utkarsh/IdeaProjects/Will/src/assets/Islands1.png");
        Platform.setImage(orc_icon);
        Platform.setPreserveRatio(true);
        Platform.setFitHeight(250);
        Platform.setFitWidth(250);
    }

    public ImageView getPlatform() {
        return Platform;
    }
}

