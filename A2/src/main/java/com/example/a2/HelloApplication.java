package com.example.a2;

import com.example.a2.view.Window;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    private Window window;
    private Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        window = new Window();

        stage.setTitle("Lite Snacks");
        stage.setScene(window.getScene());
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}