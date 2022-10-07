module com.example.a2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    opens com.example.a2 to javafx.fxml;
    exports com.example.a2;
}