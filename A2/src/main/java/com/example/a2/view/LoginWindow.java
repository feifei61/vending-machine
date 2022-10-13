package com.example.a2.view;
import com.example.a2.User;
import com.example.a2.System;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class LoginWindow implements Window{
    private System system;
    private Pane pane;
    private Scene scene;
    private TextField captureUsername;
    private PasswordField capturePassword;
    private int width = 400;
    private int height = 300;

    public LoginWindow(System system) {
        this.system = system;
        pane = new Pane();
        scene = new Scene(pane, width, height);

        //declare shapes here
        captureUsername = new TextField();
        pane.getChildren().add(captureUsername);

        captureUsername.setLayoutY(100);
        captureUsername.setLayoutX(130);

        capturePassword = new PasswordField();
        pane.getChildren().add(capturePassword);

        capturePassword.setLayoutY(150);
        capturePassword.setLayoutX(130);

        // action event
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                // TODO username and password need to be given to the System
                User newUser = new User(captureUsername.getText(), capturePassword.getText());
                system.addUser(newUser);
            }
        };

        // press enter in either text box
        captureUsername.setOnAction(event);
        capturePassword.setOnAction(event);
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
