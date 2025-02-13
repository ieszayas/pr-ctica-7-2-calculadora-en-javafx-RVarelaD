package Vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class VistaOperacion {
    private TextField campoNumero1, campoNumero2, campoResultado;
    private Button botonSumar, botonResetear;
    private Label etiquetaError;

    public VistaOperacion(Stage stage) {
        stage.setTitle("Operaciones sencillas");

        // Etiqueta de título
        Label titulo = new Label("Suma de números");
        titulo.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        // Campos de entrada
        Label labelNum1 = new Label("Número 1");
        campoNumero1 = new TextField();

        Label labelNum2 = new Label("Número 2");
        campoNumero2 = new TextField();

        Label labelResultado = new Label("Resultado");
        labelResultado.setStyle("-fx-font-weight: bold;");
        campoResultado = new TextField();
        campoResultado.setEditable(false);

        // Botones
        botonSumar = new Button("Sumar");
        botonResetear = new Button("Resetear");

        // Etiqueta para errores
        etiquetaError = new Label();
        etiquetaError.setStyle("-fx-text-fill: red;");

        // Layout
        VBox layout = new VBox(10, titulo,
                labelNum1, campoNumero1,
                labelNum2, campoNumero2,
                labelResultado, campoResultado,
                etiquetaError,
                new HBox(10, botonSumar, botonResetear));
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));

        // Configurar escena
        Scene scene = new Scene(layout, 350, 300);
        stage.setScene(scene);
    }

    public TextField getCampoNumero1() { return campoNumero1; }
    public TextField getCampoNumero2() { return campoNumero2; }
    public TextField getCampoResultado() { return campoResultado; }
    public Button getBotonSumar() { return botonSumar; }
    public Button getBotonResetear() { return botonResetear; }
    public Label getEtiquetaError() { return etiquetaError; }
}
