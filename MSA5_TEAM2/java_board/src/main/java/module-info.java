module com.team2 {
    requires javafx.base;
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.team2 to javafx.base, javafx.graphics, javafx.fxml;
    opens com.team2.Controller to javafx.fxml;
    opens com.team2.DTO to javafx.base;
}