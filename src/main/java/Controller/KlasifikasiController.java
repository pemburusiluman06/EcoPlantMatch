package Controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class KlasifikasiController {

    @FXML
    private Button KlasifikasiBtn;

    @FXML
    private Button homeBtn;

    @FXML
    private Text teks1;

    @FXML
    private Text teks11;

    @FXML
    void GoToKlasifiaksi(ActionEvent event) {
        try {
            // Load the KlasifikasiPage.fxml
            Parent klasifikasiPage = FXMLLoader.load(getClass().getResource("KlasifikasiPage.fxml"));
            Scene klasifikasiScene = new Scene(klasifikasiPage);

            // Get the current stage
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(klasifikasiScene);
            stage.setTitle("Halaman Klasifikasi");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void GoToStart(ActionEvent event) {
        try {
            // Load the StartPage.fxml
            Parent startPage = FXMLLoader.load(getClass().getResource("StartPage.fxml"));
            Scene startScene = new Scene(startPage);

            // Get the current stage
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(startScene);
            stage.setTitle("Halaman Start");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
