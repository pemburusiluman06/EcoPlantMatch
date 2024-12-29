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
        KetinggianChoicebox.setOnAction(this::getKetinggian);}
     
     private void getKetinggian(ActionEvent t) {
         String selectedKetinggian = KetinggianChoicebox.getValue();
         System.out.println("Ketinggian yang dipilih: " + selectedKetinggian);
    }
     

    @FXML
    void GoToKlasifikasi(ActionEvent event) {
    navigateToPage(event, "/fxml/Klasifikasi.fxml");
    }

    @FXML
    void GoToPertanyaan3(ActionEvent event) {
     navigateToPage(event, "/fxml/pertanyaan3.fxml");
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