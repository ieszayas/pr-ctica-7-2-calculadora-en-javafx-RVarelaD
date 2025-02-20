module com.example.parte_3 {
    requires javafx.controls;
    requires javafx.fxml;

    opens Controlador to javafx.fxml;  // ✅ Permite que FXML acceda al controlador

    exports Main;
    exports Controlador;  // ✅ Exportar para que otras clases puedan usarlo
}