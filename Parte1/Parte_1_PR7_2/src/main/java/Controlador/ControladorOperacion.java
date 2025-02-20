package Controlador;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ControladorOperacion {

    @FXML
    private Label display;

    // Botones numéricos y operaciones
    @FXML private Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    @FXML private Button btnSuma, btnResta, btnMultiplicacion, btnDivision, btnIgual, btnResetear;
    @FXML private Button btnPunto;

    // Para realizar las operaciones
    private double operando1 = 0;
    private double operando2 = 0;
    private String operador = "";

    @FXML
    public void initialize() {
        // Eventos de los botones numéricos
        btn0.setOnAction(e -> appendNumber("0"));
        btn1.setOnAction(e -> appendNumber("1"));
        btn2.setOnAction(e -> appendNumber("2"));
        btn3.setOnAction(e -> appendNumber("3"));
        btn4.setOnAction(e -> appendNumber("4"));
        btn5.setOnAction(e -> appendNumber("5"));
        btn6.setOnAction(e -> appendNumber("6"));
        btn7.setOnAction(e -> appendNumber("7"));
        btn8.setOnAction(e -> appendNumber("8"));
        btn9.setOnAction(e -> appendNumber("9"));

        // Operadores
        btnSuma.setOnAction(e -> setOperator("+"));
        btnResta.setOnAction(e -> setOperator("-"));
        btnMultiplicacion.setOnAction(e -> setOperator("*"));
        btnDivision.setOnAction(e -> setOperator("/"));

        // Botón de igual
        btnIgual.setOnAction(e -> calculate());

        // Botón de reset
        btnResetear.setOnAction(e -> reset());

        // Botón de punto
        btnPunto.setOnAction(e -> appendPoint());
    }

    private void appendNumber(String num) {
        display.setText(display.getText() + num);
    }

    private void setOperator(String operator) {
        if (!display.getText().isEmpty()) {
            operando1 = Double.parseDouble(display.getText());
            operador = operator;
            display.setText("");
        }
    }

    private void calculate() {
        if (!display.getText().isEmpty()) {
            try {
                operando2 = Double.parseDouble(display.getText());
                double resultado = 0;

                switch (operador) {
                    case "+":
                        resultado = operando1 + operando2;
                        break;
                    case "-":
                        resultado = operando1 - operando2;
                        break;
                    case "*":
                        resultado = operando1 * operando2;
                        break;
                    case "/":
                        if (operando2 != 0) {
                            resultado = operando1 / operando2;
                        } else {
                            display.setText("Error: Div 0");
                            return;
                        }
                        break;
                }

                display.setText(String.valueOf(resultado));
            } catch (NumberFormatException e) {
                display.setText("Error");
            }
        }
    }

    private void reset() {
        display.setText("");
        operando1 = 0;
        operando2 = 0;
        operador = "";
    }

    private void appendPoint() {
        if (!display.getText().contains(".")) {
            display.setText(display.getText() + ".");
        }
    }
}
