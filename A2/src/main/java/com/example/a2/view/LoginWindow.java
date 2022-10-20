package com.example.a2.view;
import com.example.a2.Sys;
import com.example.a2.User;

import com.example.a2.DBManage;
import com.example.a2.HelloApplication;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.text.Text;

public class LoginWindow implements Window {
    private Pane pane;
    private Scene scene;
    private Text text;
    private Text username;
    private Text password;
    private TextField captureUsername;
    private PasswordField capturePassword;
    private int width = 400;
    private int height = 300;
    private HelloApplication app;
    private Sys sys;

    public LoginWindow(HelloApplication app, Sys sys) {
        pane = new Pane();
        scene = new Scene(pane, width, height);
        text = new Text();
        username = new Text("Username:");
        password = new Text("Password:");

        //declare shapes here
        username.setLayoutX(130);
        username.setLayoutY(95);
        pane.getChildren().add(username);

        captureUsername = new TextField();
        pane.getChildren().add(captureUsername);

        captureUsername.setLayoutY(100);
        captureUsername.setLayoutX(130);

        password.setLayoutX(130);
        password.setLayoutY(145);
        pane.getChildren().add(password);

        capturePassword = new PasswordField();
        pane.getChildren().add(capturePassword);

        capturePassword.setLayoutY(150);
        capturePassword.setLayoutX(130);

        text.setText("");
        text.setLayoutY(200);
        text.setLayoutX(130);
        pane.getChildren().add(text);

        // action event
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                String username = captureUsername.getText();
                String password = capturePassword.getText();

                String result = sys.getDatabase().getUser(username);

                //if user exists, try and match the password
                if(result != null){
                    if(password.equals(result)){
                        text.setText("User matched");
                        app.setScene(app.getHomeWindow().getScene());
                    }
                    else{
                        text.setText("Wrong password");
                    }
                }
                else{//is user does not exist create it
                    sys.getDatabase().addUser(username, password, "User");
                    String displayText = "User added with username " + username;
                    text.setText(displayText);
                }
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
