package com.example.a2.view;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class LoginWindow implements Window{
    private Pane pane;
    private Scene scene;

    private int width = 400;
    private int height = 300;

    public LoginWindow() {
        pane = new Pane();
        scene = new Scene(pane, width, height);

        //declare shapes here
    }

    public Scene getScene() { return scene; }

    @Override
    public void draw() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        
    }
}
