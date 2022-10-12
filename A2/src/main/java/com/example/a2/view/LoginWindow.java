package com.example.a2.view;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class LoginWindow implements Window{
    private Pane pane;
    private Scene scene;
    private TextField captureUsername;
    private TextField capturePassword;
    private int width = 400;
    private int height = 300;

    public LoginWindow() {
        pane = new Pane();
        scene = new Scene(pane, width, height);

        //declare shapes here
        captureUsername = new TextField("Username");
        pane.getChildren().add(captureUsername);

        captureUsername.setLayoutY(125);
        captureUsername.setLayoutX(130);

        capturePassword = new TextField("Password");
        pane.getChildren().add(capturePassword);

        capturePassword.setLayoutY(150);
        capturePassword.setLayoutX(130);

        // action event
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                // TODO username and password need to be given to the System
            }
        };

        // when enter is pressed
        captureUsername.setOnAction(event);

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
