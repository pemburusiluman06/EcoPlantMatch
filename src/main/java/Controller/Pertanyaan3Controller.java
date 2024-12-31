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

public class Pertanyaan3Controller implements Initializable {

    @FXML
    private Button KlasifikasiBtn;

    @FXML
    private Button lanjutBtn;

    @FXML
    private Button kembaliBtn;

    @FXML
    private Button homeBtn;

    @FXML
    private Button PhBtn;

    @FXML
    private ChoiceBox<String> cahayaChoiceBox;
    private String[] KondisiCahaya = {
        "Terkena cahaya dengan sempurna",
        "Cahaya sedikit terhalang",
        "Cahaya sangat terhalang"};

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cahayaChoiceBox.getItems().addAll(KondisiCahaya);
        cahayaChoiceBox.setOnAction(this::getCahaya);

        lanjutBtn.setOnAction((ActionEvent event) -> {
            if (CahayaDAO.jenisCahaya == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Anda belum memilh kondisi cahaya");
                alert.show();
            } else {
                Fungsi.lastPage = "/UI/Pertanyaan4.fxml";
                Fungsi.ChangeScene(event, "/UI/Pertanyaan4.fxml", "EcoPlantMatch - Pilih Suhu");
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
            Fungsi.lastPage = "/UI/Pertanyaan2.fxml";
            Fungsi.ChangeScene(event, "/UI/Pertanyaan2.fxml", "EcoPlantMatch - Pilih Jenis Tanah");
        });
    }

    private void getCahaya(ActionEvent t) {
        String selectedCahaya = cahayaChoiceBox.getValue();
        System.out.println("Cahaya : " + selectedCahaya);

        CahayaDAO.jenisCahaya = selectedCahaya;
    }
}
