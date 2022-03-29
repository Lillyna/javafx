module com.example.bulsandcows1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.bulsandcows1 to javafx.fxml;
    exports com.example.bulsandcows1;
}