package Controller;

import DAO.CurahHujanDAO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;

public class PilihCurahHujanController implements Initializable {


    @FXML
    private MenuButton pilihCurahHujanBtn;
    @FXML
    private MenuItem tinggi;
    @FXML
    private MenuItem rendah;
    @FXML
    private Button lanjutBtn;
    @FXML
    private Button kembaliBtn;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        lanjutBtn.setOnAction((ActionEvent event) ->{
            Fungsi.ChangeScene(event, "/UI/Hasil.fxml", "Hasil");
        });
        
        kembaliBtn.setOnAction((ActionEvent event)->{
            Fungsi.ChangeScene(event, "/UI/PilihSuhu.fxml", "Pilih Suhu");
        });
        
        for (MenuItem item : pilihCurahHujanBtn.getItems()){
            item.setOnAction(event ->{
                pilihCurahHujanBtn.setText(item.getText());
                CurahHujanDAO.curahHujan = item.getText();
            });
        }
    }    
}