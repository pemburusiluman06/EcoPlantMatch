module com.ecoplantmatch.ecoplantmatch {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql; 
    requires java.logging; 

    opens Main to javafx.fxml;
    exports Main;
    
    opens Controller to javafx.fxml;
    exports Controller;
    
}