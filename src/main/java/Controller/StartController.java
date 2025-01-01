package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class StartController implements Initializable {

    @FXML
    private Pane Pane;
    @FXML
    private Button startKlasifikasibtn;
    @FXML
    private Button homeBtn;
    @FXML
    private Button StartBtn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        StartBtn.setOnAction((ActionEvent event) -> {
            Fungsi.lastPage = "/UI/Pertanyaan1.fxml";
            Fungsi.ChangeScene(event, "/UI/Pertanyaan1.fxml", "EcoPlantMatch - Pilih Jenis Tanah");
        });
        startKlasifikasibtn.setOnAction((ActionEvent event) -> {
            Fungsi.lastPage = "/UI/Start.fxml";
            Fungsi.ChangeScene(event, "/UI/Klasifikasi.fxml", "EcoPlantMatch - Klasifikasi");
            
        });
        homeBtn.setOnAction((ActionEvent event) -> {
            Fungsi.ChangeScene(event, "/UI/Start.fxml", "EcoPlantMatch - Home");
        });
    }

}
