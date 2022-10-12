package com.example.a2.view;

import java.io.FileInputStream;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class HomeWindow implements Window {
    private Pane pane;
    private Scene scene;
    private int width = 500;
    private int height = 700;
    private Background bg;

    private BackgroundImage bImg;

    public HomeWindow() {
        pane = new Pane();
        scene = new Scene(pane, width, height);

        // System.out.println("Working Directory = " + System.getProperty("user.dir"));
        Image img = new Image(getClass().getResource("/background.png").toString());
        bImg = new BackgroundImage(img,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                new BackgroundSize(width, height, true, true, true, true)
            );
        bg = new Background(bImg);
        pane.setBackground(bg);
    }

    @Override
    public Scene getScene() {
        // TODO Auto-generated method stub
        return scene;
    }

    @Override
    public void draw() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        
    }
    
}
