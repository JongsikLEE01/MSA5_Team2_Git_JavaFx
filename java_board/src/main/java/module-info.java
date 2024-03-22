module com.team2 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.team2 to javafx.fxml;
    exports com.team2;
}
