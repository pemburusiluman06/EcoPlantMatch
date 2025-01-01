package Controller;

import DAO.CahayaDAO;
import DAO.CurahHujanDAO;
import DAO.JenisTanahDAO;
import DAO.KetinggianDAO;
import DAO.SuhuDAO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Dialog;

public class Pertanyaan1Controller implements Initializable {

    @FXML
    private Button KlasifikasiBtn;
    @FXML
    private Button homeBtn;
    @FXML
    private Button tanahBtn;
    @FXML
    private Button lanjutBtn;
    @FXML
    private Button kembaliBtn;

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
        jenisTanahChoicebox.setOnAction(this::getJenisTanah);

        lanjutBtn.setOnAction((ActionEvent event) -> {
            if (JenisTanahDAO.jenisTanah == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Anda belum memilh jenis tanah");
                alert.show();
            } else {
                Fungsi.lastPage = "/UI/Pertanyaan2.fxml";
                Fungsi.ChangeScene(event, "/UI/Pertanyaan2.fxml", "EcoPlantMatch - Pilih Keringgian");
            }
        });

        kembaliBtn.setOnAction((ActionEvent event) -> {
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
                    Fungsi.ChangeScene(event, "/UI/Start.fxml", "EcoPlantMatch - Home");
                } else if (response == tidakBtn) {
                    System.out.println("You chose to Cancel!");
                }
            });
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
    }

    private void getJenisTanah(ActionEvent t) {
        String selectedTanah = jenisTanahChoicebox.getValue();
        System.out.println("Jenis tanah yang dipilih: " + selectedTanah);

        JenisTanahDAO.jenisTanah = jenisTanahChoicebox.getValue();
    }
}
