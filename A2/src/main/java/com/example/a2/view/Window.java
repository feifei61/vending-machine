package com.example.a2.view;

import javafx.scene.layout.Pane;
import javafx.scene.Scene;

public class Window {
    private Pane pane;
    private Scene scene;

    private int width = 400;
    private int height = 300;

    public Window() {
        pane = new Pane();
        scene = new Scene(pane, width, height);
    }

    public Scene getScene() { return scene; }
}
