module com.example.kursovavisual {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.kursovavisual to javafx.fxml;
    exports com.example.kursovavisual;
}