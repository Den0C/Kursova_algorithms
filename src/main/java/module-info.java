module com.example.kursovavisual {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.kursovavisual to javafx.fxml;
    exports com.example.kursovavisual;
    exports com.example.kursovavisual.data;
    opens com.example.kursovavisual.data to javafx.fxml;
}