package Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class Pertanyaan5Controller implements Initializable {

    @FXML
    private Button KlasifikasiBtn4;

    @FXML
    private Button hasilBtn;

    @FXML
    private Button homeBtn4;

    @FXML
    private ChoiceBox<String> curahHujanCheckbox;

    private String[] curahHujan = {
            "Tinggi (300 – 500 mm)",
            "Sedang ( 100 – 300 mm)",
            "Rendah (< 200 mm)"
    };

    // Implement the initialize method from Initializable interface
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        curahHujanCheckbox.getItems().addAll(curahHujan);
        curahHujanCheckbox.setOnAction(this::getcurahHujan);

        hasilBtn.setOnAction(event -> Fungsi.ChangeScene(event, "/UI/akhir.fxml", "SistemPakar"));
        KlasifikasiBtn4.setOnAction(event -> Fungsi.ChangeScene(event, "/UI/Klasifikasi.fxml", "SistemPakar"));
        homeBtn4.setOnAction(event -> Fungsi.ChangeScene(event, "/UI/Start.fxml", "SistemPakar"));
    }

    private void getcurahHujan(ActionEvent event) {
        String selectedcurahHujan = curahHujanCheckbox.getValue();
        if (selectedcurahHujan != null) {
            System.out.println("Curah hujan yang dipilih: " + selectedcurahHujan);
        } else {
            System.out.println("Tidak ada pilihan curah hujan.");
        }
    }
}
