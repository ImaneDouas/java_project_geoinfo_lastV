module com.example.demo1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;
    requires mysql.connector.j;
    requires org.apache.pdfbox;



    opens com.example.demo1 to javafx.fxml;
    exports com.example.demo1;
    exports com.example.demo1.Model;
    opens com.example.demo1.Model to javafx.fxml;
    exports com.example.demo1.Controller;
    opens com.example.demo1.Controller to javafx.fxml;
    exports com.example.demo1.View;
    opens com.example.demo1.View to javafx.fxml;
}