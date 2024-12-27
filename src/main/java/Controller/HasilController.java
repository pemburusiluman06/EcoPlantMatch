package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import DAO.CahayaDAO;
import DAO.JenisTanahDAO;
import DAO.KetinggianDAO;
import DAO.SuhuDAO;

public class HasilController implements Initializable {


    @FXML
    private Label cahaya;
    @FXML
    private Label ketinggian;
    @FXML
    private Label suhu;
    @FXML
    private Label tanah;
    @FXML
    private Button homeBtn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        homeBtn.setOnAction((ActionEvent event) -> {
            Fungsi.ChangeScene(event, "/UI/Home.fxml", "Home");
        });
        
        cahaya.setText(CahayaDAO.jenisCahaya);
        ketinggian.setText(KetinggianDAO.ketinggian);
        suhu.setText(SuhuDAO.suhu);
        tanah.setText(JenisTanahDAO.jenisTanah);
    }    
    
}
