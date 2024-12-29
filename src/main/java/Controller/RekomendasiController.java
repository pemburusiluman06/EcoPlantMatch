package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import java.io.IOException;

public class RekomendasiController {

    @FXML
    private Button keBeranda;

    @FXML
    private Button keDataketinggian;

    @FXML
    private Button keDataph;

    @FXML
    private Button keDatasuhu;

    @FXML
    private Button keDatatanah;

    @FXML
    void beranda(ActionEvent event) {
openBeranda(keBeranda, "Home.fxml");
    }

    private void openBeranda(Region region, String fxml) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(RekomendasiController.class.getResource(fxml));
            Parent root = fxmlLoader.load();
            Scene newScene = new Scene(root);

            Stage currentStage = (Stage) region.getScene().getWindow();
            currentStage.setFullScreen(true);
            currentStage.setScene(newScene);
            currentStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void dataKetinggian(ActionEvent event) {

    }

    @FXML
    void dataPh(ActionEvent event) {

    }

    @FXML
    void dataSuhu(ActionEvent event) {

    }

    @FXML
    void dataTanah(ActionEvent event) {

    }

}
