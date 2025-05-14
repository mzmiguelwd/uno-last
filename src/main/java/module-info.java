module org.example.unolast {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.example.unolast to javafx.fxml;
    opens org.example.unolast.controllers to javafx.fxml;

    exports org.example.unolast;
}