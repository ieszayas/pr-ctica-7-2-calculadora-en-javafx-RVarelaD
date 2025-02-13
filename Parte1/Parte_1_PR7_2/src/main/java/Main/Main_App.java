package Main;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main_App extends Application {
    private Label display;
    private StringBuilder input = new StringBuilder();
    private double num1 = 0;
    private String operator = "";

    @Override
    public void start(Stage primaryStage) {
        display = new Label("0");
        display.setStyle("-fx-font-size: 24px; -fx-padding: 10px;");

        VBox root = new VBox(10);
        root.setPadding(new Insets(10));
        root.setAlignment(Pos.CENTER);

        root.getChildren().add(display);

        String[][] buttons = {
                {"7", "8", "9", "/"},
                {"4", "5", "6", "*"},
                {"1", "2", "3", "+"},
                {"0", "C", "-", "="}
        };

        for (String[] row : buttons) {
            HBox hbox = new HBox(10);
            hbox.setAlignment(Pos.CENTER);
            for (String text : row) {
                Button button = new Button(text);
                button.setStyle("-fx-font-size: 18px; -fx-min-width: 50px; -fx-min-height: 50px;");
                button.setOnAction(e -> handleButtonPress(text));
                hbox.getChildren().add(button);
            }
            root.getChildren().add(hbox);
        }

        Scene scene = new Scene(root, 300, 400);
        primaryStage.setTitle("Calculadora");
        primaryStage.setScene(scene);

        primaryStage.setResizable(false);
        primaryStage.show();
    }

    private void handleButtonPress(String text) {

        if (text.matches("[0-9]") || text.equals(".")) {
            input.append(text);
            display.setText(input.toString());
        } else if (text.matches("[+\\-*/]") && input.length() > 0) {
            num1 = Double.parseDouble(input.toString());
            operator = text;
            input.setLength(0);
        } else if (text.equals("=")) {
            if (operator.isEmpty() || input.length() == 0) return;
            double num2 = Double.parseDouble(input.toString());
            double result = calculate(num1, num2, operator);
            display.setText(result == Double.POSITIVE_INFINITY ? "Error" : String.valueOf(result));
            input.setLength(0);
            operator = "";
        } else if (text.equals("C")) {
            input.setLength(0);
            display.setText("0");
            num1 = 0;
            operator = "";
        }
    }

    private double calculate(double num1, double num2, String operator) {
        switch (operator) {
            case "+": return num1 + num2;
            case "-": return num1 - num2;
            case "*": return num1 * num2;
            case "/": return num2 == 0 ? Double.POSITIVE_INFINITY : num1 / num2;
            default: return 0;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
