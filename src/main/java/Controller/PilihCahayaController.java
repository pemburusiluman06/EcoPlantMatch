package Controller;

import DAO.CahayaDAO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;

public class PilihCahayaController implements Initializable {

    @FXML
    private MenuButton pilihCahayaBtn;
    @FXML
    private MenuItem sering;
    @FXML
    private MenuItem sedang;
    @FXML
    private MenuItem jarang;
    @FXML
    private Button lanjutBtn;
    @FXML
    private Button kembaliBtn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        lanjutBtn.setOnAction((ActionEvent event) -> {
            if (CahayaDAO.jenisCahaya == null) {
                System.out.println("Please fill in all information");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Anda belum memilh kondisi cahaya");
                alert.show();
            } else {
                Fungsi.ChangeScene(event, "/UI/PilihKetinggian.fxml", "Sistem Pakar");
            }
        });

        kembaliBtn.setOnAction((ActionEvent event) -> {
            Fungsi.ChangeScene(event, "/UI/PilihJenisTanah.fxml", "Sistem Pakar");
        });

        for (MenuItem item : pilihCahayaBtn.getItems()) {
            item.setOnAction(event -> {
                CahayaDAO.jenisCahaya = item.getText();
                pilihCahayaBtn.setText(item.getText());
            });
        }
    }
}
