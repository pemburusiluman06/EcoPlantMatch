
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
         KlasifikasiBtn4.setOnAction((ActionEvent event) -> {
             Fungsi.ChangeScene(event, "/UI/Klasifikasi.fxml", "SistemPakar");
         });
         homeBtn4.setOnAction((ActionEvent event) -> {
             Fungsi.ChangeScene(event, "/UI/Start.fxml", "SistemPakar");
         });
     }
     
      private void getSuhu(ActionEvent t) {
         String selectedSuhu = suhuCheckbox.getValue();
         System.out.println("Suhu yang di pilih: " + selectedSuhu);
    }


    }
