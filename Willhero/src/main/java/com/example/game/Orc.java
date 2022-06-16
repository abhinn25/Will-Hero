package com.example.game;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Orc {
        private ImageView Orc;

        Orc(double x,double y, double jump ){
            Orc = new ImageView();
            Orc.setX(x);
            Orc.setY(y);
            Image orc_icon = new Image("file:/C:/Users/utkarsh/IdeaProjects/Will/src/assets/Orc1.png");
            Orc.setImage(orc_icon);
            Orc.setPreserveRatio(true);
            Orc.scaleXProperty();
            Orc.setFitHeight(50);
            Orc.setFitWidth(50);
        }

    public ImageView getOrc() {
        return Orc;
    }
}

