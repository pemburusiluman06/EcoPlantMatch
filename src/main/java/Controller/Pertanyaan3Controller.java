
package Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;

public class Pertanyaan3Controller implements Initializable {

    @FXML
    private Button KlasifikasiBtn3;

    @FXML
    private Button PhBtn;

    @FXML
    private ChoiceBox<String> PhChoiceBox;
    private String [] Ph = {
        "5.0 - 6.0",
        "6.0 - 6.5",
        "6.5 - 7.0",
        "7.0 - 7.5"};
    
     @Override 
     public void initialize(URL location, ResourceBundle resources) {
        PhChoiceBox.getItems().addAll(Ph);
        PhChoiceBox.setOnAction(this::getPh);}
     
     private void getPh(ActionEvent t) {
         String selectedPh = PhChoiceBox.getValue();
         System.out.println("Ph : " + selectedPh);
    }

    @FXML
    private Button homeBtn3;

    @FXML
    void GoToKlasifikasi(ActionEvent event) {
    navigateToPage(event, "/fxml/Klasifikasi.fxml");
    }

    @FXML
    void GoToPertanyaan4(ActionEvent event) {
    navigateToPage(event, "/fxml/pertanyaan4.fxml");
    }

    @FXML
    void GoTohomePage(ActionEvent event) {
    navigateToPage(event, "/fxml/Start.fxml");

    }
    
        private void navigateToPage(ActionEvent event, String fxmlPath) {
    try {
        // Memuat file FXML berdasarkan path yang diberikan
        Parent root = FXMLLoader.load(getClass().getResource(fxmlPath));
        // Mendapatkan stage dari event saat ini
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        // Mengatur scene baru dengan file FXML yang dimuat
        stage.setScene(new Scene(root));
        stage.show();
    } catch (IOException e) {
        e.printStackTrace();
    }
}
}

