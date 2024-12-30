
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

public class Pertanyaan4Controller implements Initializable {

    @FXML
    private Button KlasifikasiBtn4;

    @FXML
    private Button hasilBtn;

    @FXML
    private Button homeBtn4;

    @FXML
    private ChoiceBox<String> suhuCheckbox;
    private String[] Suhu = {
        "Dingin: 15 - 25 Derajat Celcius",
        "Panas: 30 - 38 Derajat Celcius"
    };
    
     @Override 
     public void initialize(URL location, ResourceBundle resources) {
        suhuCheckbox.getItems().addAll(Suhu);
        suhuCheckbox.setOnAction(this::getSuhu);
        hasilBtn.setOnAction((ActionEvent event) -> {
            Fungsi.ChangeScene(event, "/UI/akhir.fxml", "SistemPakar");
        });
     }
     
      private void getSuhu(ActionEvent t) {
         String selectedSuhu = suhuCheckbox.getValue();
         System.out.println("Suhu yang di pilih: " + selectedSuhu);
    }

    @FXML
    void GoToAkhir(ActionEvent event) {
    navigateToPage(event, "/fxml/akhir.fxml");
    }

    @FXML
    void GoToHomePage(ActionEvent event) {
    navigateToPage(event, "/fxml/homePage.fxml");

    }

    @FXML
    void GoToKlasifikasi(ActionEvent event) {
    navigateToPage(event, "/fxml/Klasifikasi.fxml");

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
        e.printStackTrace();}}}
