package Main;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main_App extends Application {
    private Label display;
    private double memoria = 0;
    private String operador = "";
    private boolean start = true;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Calculadora");

        display = new Label("0");
        display.setStyle("-fx-font-size: 32px; -fx-padding: 10px; -fx-background-color: #FAD7A0; -fx-min-width: 200px;");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setAlignment(Pos.CENTER);

        String[][] botones = {
                {"M+", "MC", "C", "/"},
                {"7", "8", "9", "*"},
                {"4", "5", "6", "+"},
                {"1", "2", "3", "-"},
                {"0", ".", "±", "="}
        };

        for (int i = 0; i < botones.length; i++) {
            for (int j = 0; j < botones[i].length; j++) {
                Button btn = new Button(botones[i][j]);
                btn.setStyle("-fx-font-size: 20px; -fx-min-width: 50px; -fx-min-height: 50px; -fx-background-radius: 10px;");
                btn.setOnAction(e -> manejarEntrada(btn.getText()));
                grid.add(btn, j, i);
            }
        }

        VBox root = new VBox(10, display, grid);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(10));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/com/example/parte_3/estilos.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void manejarEntrada(String valor) {
        if (valor.matches("[0-9]") || valor.equals(".")) {
            if (start) {
                display.setText(valor);
                start = false;
            } else {
                display.setText(display.getText() + valor);
            }
        } else if (valor.matches("[+\\-*/]") && !start) {
            operador = valor;
            memoria = Double.parseDouble(display.getText());
            start = true;
        } else if (valor.equals("=")) {
            double resultado = calcular(memoria, Double.parseDouble(display.getText()), operador);
            display.setText(String.valueOf(resultado));
            start = true;
        } else if (valor.equals("C")) {
            // Reinicia todo, incluyendo la memoria
            display.setText("0");
            memoria = 0;
            start = true;
        } else if (valor.equals("M+")) {
            memoria = Double.parseDouble(display.getText());
        } else if (valor.equals("MC")) {
            memoria = 0;
        } else if (valor.equals("±")) {
            double num = Double.parseDouble(display.getText());
            display.setText(String.valueOf(-num));
        }
    }

    private double calcular(double a, double b, String operador) {
        switch (operador) {
            case "+":
                // Si el número b es negativo, lo tratamos como una resta
                if (b < 0) {
                    return a - Math.abs(b);
                }
                return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": return (b != 0) ? a / b : Double.NaN;
            default: return b;
        }
    }


    public static void main(String[] args) {

        launch(args);
    }
}
