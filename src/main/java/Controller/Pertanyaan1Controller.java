package Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
public class Pertanyaan1Controller implements Initializable {

    @FXML
    private Button KlasifikasiBtn;

    @FXML
    private ImageView homeBtn;
    
        @FXML
    private Button tanahBtn;

    @FXML
    private ChoiceBox<String> jenisTanahChoicebox;
        private String[] Tanah = {
        "Liat",
        "Lempung",
        "Berpasir",
        "Lempung berpasir",
        "Lempung liat berpasir",
        "Gembur",
        "Gambut"
    };
    
         @Override
    public void initialize(URL location, ResourceBundle resources) {
        jenisTanahChoicebox.getItems().addAll(Tanah);
        jenisTanahChoicebox.setOnAction(this::getTanah);
    }

    private void getTanah(ActionEvent event) {
        // Contoh aksi ketika memilih jenis tanah
        String selectedTanah = jenisTanahChoicebox.getValue();
        System.out.println("Jenis tanah yang dipilih: " + selectedTanah);
    }


    @FXML
    private void goToHomePage(ActionEvent event) {
        // Navigasi ke halaman home
        navigateToPage(event, "/fxml/Start.fxml");
    }

    @FXML
    private void goToKlasifikasiPage(ActionEvent event) {
        // Navigasi ke halaman klasifikasi
        navigateToPage(event, "/fxml/klasifikasiPage.fxml");
    }

    @FXML
    private void goToPertanyaan2Page(ActionEvent event) {
        // Navigasi ke halaman pertanyaan 2
        navigateToPage(event, "/fxml/pertanyaan2.fxml");
    }

    private void navigateToPage(ActionEvent event, String fxmlPath) {
        try {
            // Memuat file FXML baru
            Parent root = FXMLLoader.load(getClass().getResource(fxmlPath));
            // Mendapatkan stage saat ini
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            // Mengganti scene dengan file FXML baru
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

