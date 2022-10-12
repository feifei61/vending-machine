package com.example.a2;

import com.example.a2.view.LoginWindow;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    private LoginWindow loginWindow;
    private Stage stage;

    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        loginWindow = new LoginWindow();

        stage.setTitle("Lite Snacks");
        stage.setScene(loginWindow.getScene());
        stage.show();
    }

    public void setScene(Scene scene) {
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        System system = new System(); //use this for logic
        launch();
    }
}