package Controlador;

import Modelo.ModeloOperacion;
import Vista.VistaOperacion;
import javafx.stage.Stage;

public class ControladorOperacion {
    private VistaOperacion vista;

    public ControladorOperacion(Stage stage) {
        this.vista = new VistaOperacion(stage);

        // Configurar eventos
        vista.getBotonSumar().setOnAction(e -> realizarSuma());
        vista.getBotonResetear().setOnAction(e -> resetearCampos());

        stage.show();
    }

    private void realizarSuma() {
        try {
            // Obtener valores
            double num1 = Double.parseDouble(vista.getCampoNumero1().getText());
            double num2 = Double.parseDouble(vista.getCampoNumero2().getText());

            // Calcular resultado
            double resultado = ModeloOperacion.sumar(num1, num2);

            // Mostrar resultado
            vista.getCampoResultado().setText(String.valueOf(resultado));
            vista.getEtiquetaError().setText(""); // Limpiar errores
        } catch (NumberFormatException e) {
            vista.getEtiquetaError().setText("Error: Ingresa números válidos.");
        }
    }

    private void resetearCampos() {
        vista.getCampoNumero1().clear();
        vista.getCampoNumero2().clear();
        vista.getCampoResultado().clear();
        vista.getEtiquetaError().setText("");
    }
}
