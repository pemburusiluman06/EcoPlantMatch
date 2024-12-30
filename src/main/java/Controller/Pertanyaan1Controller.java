package Controller;

import DAO.JenisTanahDAO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;

public class Pertanyaan1Controller implements Initializable {

    @FXML
    private Button KlasifikasiBtn;
    @FXML
    private Button homeBtn;
    @FXML
    private Button tanahBtn;

    @FXML
    private ChoiceBox<String> jenisTanahChoicebox;
    private String[] JenisTanah = {
        "aluvial",
        "andosol",
        "entisol",
        "grumusol",
        "humus",
        "kapur",
        "latosol",};

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        jenisTanahChoicebox.getItems().addAll(JenisTanah);
        jenisTanahChoicebox.setOnAction(this::getKetinggian);

        tanahBtn.setOnAction((ActionEvent event) -> {
            Fungsi.ChangeScene(event, "/UI/Pertanyaan2.fxml", "SistemPakar");
        });
        KlasifikasiBtn.setOnAction((ActionEvent event) -> {
            Fungsi.ChangeScene(event, "/UI/Klasifikasi.fxml", "SistemPakar");
        });
        homeBtn.setOnAction((ActionEvent event) -> {
            Fungsi.ChangeScene(event, "/UI/Start.fxml", "SistemPakar");
        });
    }

    private void getKetinggian(ActionEvent t) {
        String selectedKetinggian = jenisTanahChoicebox.getValue();
        System.out.println("Jenis tanah yang dipilih: " + selectedKetinggian);

        JenisTanahDAO.jenisTanah = jenisTanahChoicebox.getValue();
    }
}
