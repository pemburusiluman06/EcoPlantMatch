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

public class Pertanyaan2Controller implements Initializable {

    @FXML
    private Button KetinggianBtn;
    
        @FXML
    private Button KlasifikasiBtn2;

    @FXML
    private Button homeBtn2;

    @FXML
    private ChoiceBox<String> KetinggianChoicebox;
    private String[] Ketinggian = {
        "Rendah: 500-700 mdpl",
        "Sedang: 700-1000 mdpl",
        "Tinggi: 1000-1500 mdpl"};
    
    @Override 
     public void initialize(URL location, ResourceBundle resources) {
        KetinggianChoicebox.getItems().addAll(Ketinggian);
        KetinggianChoicebox.setOnAction(this::getKetinggian);
        KetinggianBtn.setOnAction((ActionEvent event) -> {
            Fungsi.ChangeScene(event, "/UI/Pertanyaan3.fxml", "SistemPakar");
        });
        KlasifikasiBtn2.setOnAction((ActionEvent event) -> {
            Fungsi.ChangeScene(event, "/UI/Klasifikasi.fxml", "SistemPakar");
        });
        homeBtn2.setOnAction((ActionEvent event) -> {
            Fungsi.ChangeScene(event, "/UI/Start.fxml", "SistemPakar");
        });
     }
     
     private void getKetinggian(ActionEvent t) {
         String selectedKetinggian = KetinggianChoicebox.getValue();
         System.out.println("Ketinggian yang dipilih: " + selectedKetinggian);


    }

}