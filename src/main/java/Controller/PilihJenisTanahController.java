package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import DAO.JenisTanahDAO;
import javafx.scene.control.Alert;

public class PilihJenisTanahController implements Initializable {

    @FXML
    private MenuButton jenisTanahBtn;
    @FXML
    private MenuItem latosol;
    @FXML
    private MenuItem kapur;
    @FXML
    private MenuItem humus;
    @FXML
    private MenuItem grumusol;
    @FXML
    private MenuItem entisol;
    @FXML
    private MenuItem andosol;
    @FXML
    private MenuItem aluvial;
    @FXML
    private Button lanjutBtn;
    @FXML
    private Button kembaliBtn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        lanjutBtn.setOnAction((ActionEvent event) -> {
            if (JenisTanahDAO.jenisTanah == null) {
                System.out.println("Please fill in all information");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Anda belum memilh jenis tanahnya");
                alert.show();
            } else {
                Fungsi.ChangeScene(event, "/UI/PilihCahaya.fxml", "Sistem Pakar");
            }
        });

        kembaliBtn.setOnAction((ActionEvent event) -> {
            Fungsi.ChangeScene(event, "/UI/Home.fxml", "Home");
        });

        for (MenuItem item : jenisTanahBtn.getItems()) {
            item.setOnAction(event -> {
                jenisTanahBtn.setText(item.getText());
                JenisTanahDAO.jenisTanah = item.getText();
            });
        }
    }
}
