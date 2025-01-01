package Controller;

import DAO.CahayaDAO;
import DAO.CurahHujanDAO;
import DAO.JenisTanahDAO;
import DAO.KetinggianDAO;
import DAO.SuhuDAO;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;

public class Pertanyaan4Controller implements Initializable {

    public static String selectedSuhu;
    
    @FXML
    private Button KlasifikasiBtn;

    @FXML
    private Button lanjutBtn;

    @FXML
    private Button kembaliBtn;

    @FXML
    private Button homeBtn;

    @FXML
    private ChoiceBox<String> suhuCheckbox;
    private String[] Suhu = {
        "Dingin: 15 - 25 Derajat Celcius",
        "Panas: 30 - 38 Derajat Celcius"
    };

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        suhuCheckbox.getItems().addAll(Suhu);
        suhuCheckbox.setOnAction(this::getSuhu);

        lanjutBtn.setOnAction((ActionEvent event) -> {
            if (SuhuDAO.suhu == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Anda belum memilh suhu");
                alert.show();
            } else {
                Fungsi.lastPage = "/UI/Pertanyaan5.fxml";
                Fungsi.ChangeScene(event, "/UI/Pertanyaan5.fxml", "EcoPlantMatch - Pilih Curah Hujan");
            }
        });

        KlasifikasiBtn.setOnAction((ActionEvent event) -> {
            Fungsi.ChangeScene(event, "/UI/Klasifikasi.fxml", "EcoPlantMatch - Klasifikasi");
        });

        homeBtn.setOnAction((ActionEvent event) -> {
            Dialog<ButtonType> dialog = new Dialog<>();
            dialog.setTitle("EcoPlantMatch");
            dialog.setHeaderText("Anda akan kembali ke halaman utama!");
            dialog.setContentText("Apakah anda yakin ingin membatalkan proses ini?");

            // Membuat tombol dengan teks kustom
            ButtonType yaBtn = new ButtonType("Ya");
            ButtonType tidakBtn = new ButtonType("Tidak");

            // Menambahkan tombol ke dialog
            dialog.getDialogPane().getButtonTypes().addAll(yaBtn, tidakBtn);

            // Menangani respons pengguna
            dialog.showAndWait().ifPresent(response -> {
                if (response == yaBtn) {
                    Fungsi.lastPage = "/UI/Start.fxml";
                    CahayaDAO.jenisCahaya = null;
                    KetinggianDAO.ketinggian = null;
                    SuhuDAO.suhu = null;
                    JenisTanahDAO.jenisTanah = null;
                    CurahHujanDAO.curahHujan = null;
                    Fungsi.ChangeScene(event, "/UI/Start.fxml", "EcoPlantMatch - Home");
                } else if (response == tidakBtn) {
                    System.out.println("You chose to Cancel!");
                }
            });
        });

        kembaliBtn.setOnAction((ActionEvent event) -> {
            Fungsi.lastPage = "/UI/Pertanyaan3.fxml";
            Fungsi.ChangeScene(event, "/UI/Pertanyaan3.fxml", "EcoPlantMatch - Pilih Jenis Tanah");
        });

    }

    private void getSuhu(ActionEvent t) {
        selectedSuhu = suhuCheckbox.getValue();
        System.out.println("Suhu yang di pilih: " + selectedSuhu);

        if (selectedSuhu.equals("Panas: 30 - 38 Derajat Celcius")) {
            SuhuDAO.suhu = "panas";
        } else if (selectedSuhu.equals("Dingin: 15 - 25 Derajat Celcius")) {
            SuhuDAO.suhu = "dingin";
        }
    }
}
