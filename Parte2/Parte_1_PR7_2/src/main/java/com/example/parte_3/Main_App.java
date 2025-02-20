package com.example.parte_3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Main_App extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            // Cargar el archivo FXML
            VBox root = FXMLLoader.load(getClass().getResource("/com/example/parte_3/Calculadora.fxml"));

            // Crear la escena
            Scene scene = new Scene(root, 300, 400);

            // Vincular el archivo CSS a la escena
            scene.getStylesheets().add(getClass().getResource("/com/example/parte_3/estilos.css").toExternalForm());

            // Establecer la escena y el título de la ventana
            primaryStage.setTitle("Calculadora");
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        launch();
    }
}