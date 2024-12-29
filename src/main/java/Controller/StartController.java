package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class StartController implements Initializable {

    @FXML
    private Button StartBtn;

    @FXML
    private Button homeBtn;

    @FXML
    private Button startKlasifikasibtn;

    @FXML
    void GoToKlasifiksai(ActionEvent event) {
        navigateToPage(event, "/fxml/klasifikasiPage.fxml");
    }

    @FXML
    void GoToPertanyaan1(ActionEvent event) {
        navigateToPage(event, "/fxml/pertanyaan1.fxml");
    }

    @FXML
    void GoToStart(ActionEvent event) {
        navigateToPage(event, "/fxml/Start.fxml");
    }

    private void navigateToPage(ActionEvent event, String fxmlPath) {
        try {
            // Load the new FXML file
            Parent root = FXMLLoader.load(getClass().getResource(fxmlPath));
            // Get the current stage
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            // Change the scene to the new FXML file
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Initialization logic can be added here if needed
    }
}