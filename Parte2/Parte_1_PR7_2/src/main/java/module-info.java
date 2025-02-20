module com.example.parte_3 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.parte_3 to javafx.fxml, javafx.graphics;  // <-- Asegura que se abre a javafx.graphics
    exports com.example.parte_3;  // <-- Exporta Main para que sea accesible
}