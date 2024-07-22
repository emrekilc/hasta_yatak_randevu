module com.example.hasta_yatak_randevu {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.hasta_yatak_randevu to javafx.fxml;
    exports com.example.hasta_yatak_randevu;
}