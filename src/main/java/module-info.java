module files {
    requires javafx.controls;
    requires javafx.fxml;

    opens files to javafx.fxml;
    exports files;
    exports files.controllerGUI;
    opens files.controllerGUI to javafx.fxml;
}