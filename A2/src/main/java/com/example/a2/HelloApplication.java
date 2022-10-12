package com.example.a2;

import com.example.a2.view.LoginWindow;
import com.example.a2.view.HomeWindow;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    private LoginWindow loginWindow;
    private HomeWindow homeWindow;
    private Stage stage;

    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        loginWindow = new LoginWindow();
        homeWindow = new HomeWindow();

        stage.setTitle("Lite Snacks");
        stage.setScene(homeWindow.getScene());
        stage.show();
    }

    public void setScene(Scene scene) {
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}