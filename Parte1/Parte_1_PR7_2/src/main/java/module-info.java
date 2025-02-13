module com.example.parte_3 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens Main to javafx.fxml, javafx.graphics;  // <-- Asegura que se abre a javafx.graphics
    exports Main;  // <-- Exporta Main para que sea accesible
}