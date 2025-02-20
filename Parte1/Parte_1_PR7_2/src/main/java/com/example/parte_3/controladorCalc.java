package com.example.parte_3;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class controladorCalc {
    @FXML
    private Label display;

    private double num1 = 0;
    private String operator = "";
    private boolean start = true;
    private double memory = 0;

    @FXML
    private void handleNumber(javafx.event.ActionEvent event) {
        if (start) {
            display.setText("");
            start = false;
        }
        Button btn = (Button) event.getSource();
        display.setText(display.getText() + btn.getText());
    }

    @FXML
    private void handleOperator(javafx.event.ActionEvent event) {
        Button btn = (Button) event.getSource();
        operator = btn.getText();
        num1 = Double.parseDouble(display.getText());
        start = true;
    }

    @FXML
    private void handleEquals() {
        double num2 = Double.parseDouble(display.getText());
        double result = switch (operator) {
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            case "/" -> (num2 == 0) ? Double.NaN : num1 / num2;
            default -> num2;
        };
        display.setText(String.valueOf(result));
        start = true;
    }

    @FXML
    private void handleClear() {
        display.setText("0");
        num1 = 0;
        operator = "";
        start = true;
    }

    @FXML
    private void handleDecimal() {
        if (!display.getText().contains(".")) {
            display.setText(display.getText() + ".");
        }
    }

    @FXML
    private void handleSignChange() {
        double value = Double.parseDouble(display.getText());
        display.setText(String.valueOf(value * -1));
    }

    @FXML
    private void handleMemoryAdd() {
        memory = Double.parseDouble(display.getText());
    }

    @FXML
    private void handleMemoryClear() {
        memory = 0;
    }
}