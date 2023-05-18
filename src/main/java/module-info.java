module com.solovev.calculatorfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.solovev.calculatorfx to javafx.fxml;
    exports com.solovev.calculatorfx;
}