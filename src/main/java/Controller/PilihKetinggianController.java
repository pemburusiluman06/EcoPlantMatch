package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import DAO.KetinggianDAO;

public class PilihKetinggianController implements Initializable {

    @FXML
    private MenuButton pilihKetinggianBtn;
    @FXML
    private MenuItem tinggi;
    @FXML
    private MenuItem sedang;
    @FXML
    private MenuItem rendah;
    @FXML
    private Button lanjutBtn;
    @FXML
    private Button kembaliBtn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        lanjutBtn.setOnAction((ActionEvent event) -> {
            Fungsi.ChangeScene(event, "/UI/PilihSuhu.fxml", "Sistem Pakar");
        });

        kembaliBtn.setOnAction((ActionEvent event) -> {
            Fungsi.ChangeScene(event, "/UI/PilihCahaya.fxml", "Sistem Pakar");
        });

        for (MenuItem item : pilihKetinggianBtn.getItems()) {
            item.setOnAction(event -> {
                pilihKetinggianBtn.setText(item.getText());
                KetinggianDAO.ketinggian = item.getText();
            });
        }
    }
}
