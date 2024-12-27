package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import DAO.SuhuDAO;

public class PilihSuhuController implements Initializable {

    @FXML
    private MenuButton pilihSuhuBtn;
    @FXML
    private MenuItem panas;
    @FXML
    private MenuItem sedang;
    @FXML
    private MenuItem dingin;
    @FXML
    private Button lanjutBtn;
    @FXML
    private Button kembaliBtn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        lanjutBtn.setOnAction((ActionEvent event) -> {
            Fungsi.ChangeScene(event, "/UI/Hasil.fxml", "Hasil");
        });

        kembaliBtn.setOnAction((ActionEvent event) -> {
            Fungsi.ChangeScene(event, "/UI/PilihKetinggian.fxml", "Sistem Pakar");
        });

        for (MenuItem item : pilihSuhuBtn.getItems()) {
            item.setOnAction(event -> {
                pilihSuhuBtn.setText(item.getText());
                SuhuDAO.suhu = item.getText();
            });
        }
    }
}
