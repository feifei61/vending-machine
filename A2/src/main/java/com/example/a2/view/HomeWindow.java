package com.example.a2.view;

import java.io.FileInputStream;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import com.example.a2.Product;
import com.example.a2.System;

public class HomeWindow implements Window {
    private Pane pane;
    private Scene scene;
    private int width = 500;
    private int height = 700;

    private Background bg;
    private BackgroundImage bImg;

    private ScrollPane scrollPane;
    private Button checkout;
    private Text recentTxt;
    private Text allTxt;

    private System sys;

    public HomeWindow(System system) {
        this.sys = system;

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

        cfgProductPane(); // need to cfg everything in the scrollpane b4 adding to renderqueue
        pane.getChildren().add(scrollPane);

        //checkout button
        checkout = new Button("Checkout");
        checkout.setTranslateX(415);
        checkout.setTranslateY(400);
        checkout.setStyle(
            "-fx-background-color: #e6cc00;"
        );
        pane.getChildren().add(checkout);
    }

    public void cfgProductPane() {
        scrollPane = new ScrollPane();
        scrollPane.setPrefSize(380, 480);
        scrollPane.relocate(20,60);

        allTxt = new Text("All Products");
        allTxt.setFont(new Font(30));
        VBox box = new VBox();
        box.getChildren().add(allTxt);
        
        for (Product product : sys.getVendingMachine().getProductInventroy()) {
            box.getChildren().add(new Text(String.format("%d %s %.2f",  
                        product.getCode(), product.getName(), product.getCost())));
        }
        
        scrollPane.setContent(box);
    }

    @Override
    public Scene getScene() {
        return scene;
    }

    @Override
    public void draw() {
        //TODO show recent

        //TODO show all products
        
    }

    @Override
    public void run() {
        // TODO get user if logged in
        
    }
    
}
