package com.nolan.calculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.stage.*;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane root = FXMLLoader.<GridPane>load(getClass().getResource("/fxml/main.fxml"));
        root.getStylesheets().add("/styles/main.css");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.setTitle("Калькулятор");
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
