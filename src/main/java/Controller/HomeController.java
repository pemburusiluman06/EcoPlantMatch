package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class HomeController implements Initializable {

    @FXML
    private Button MulaiBtn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    MulaiBtn.setOnAction((ActionEvent event) -> {
        Fungsi.ChangeScene(event, "/UI/PilihJenisTanah.fxml", "SistemPakar");
    });
    }    
}
