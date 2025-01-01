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

public class Pertanyaan2Controller implements Initializable {

    public static String selectedKetinggian;
    
    @FXML
    private Button KlasifikasiBtn;

    @FXML
    private Button homeBtn;

    @FXML
    private Button lanjutBtn;

    @FXML
    private Button kembaliBtn;

    @FXML
    private ChoiceBox<String> KetinggianChoicebox;
    private String[] Ketinggian = {
        "Rendah: 500-700 mdpl",
        "Sedang: 700-1000 mdpl",
        "Tinggi: 1000-1500 mdpl"};

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        KetinggianChoicebox.getItems().addAll(Ketinggian);
        KetinggianChoicebox.setOnAction(this::getKetinggian);

        lanjutBtn.setOnAction((ActionEvent event) -> {
            if (KetinggianDAO.ketinggian == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Anda belum memilh ketinggian");
                alert.show();
            } else {
                Fungsi.lastPage = "/UI/Pertanyaan3.fxml";
                Fungsi.ChangeScene(event, "/UI/Pertanyaan3.fxml", "EcoPlantMatch - Pilih Kondisi Cahaya");
            }
        });

        kembaliBtn.setOnAction((ActionEvent event) -> {
            Fungsi.lastPage = "/UI/Pertanyaan1.fxml";
            Fungsi.ChangeScene(event, "/UI/Pertanyaan1.fxml", "EcoPlantMatch - Pilih Jenis Tanah");
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

    private void getKetinggian(ActionEvent t) {
        selectedKetinggian = KetinggianChoicebox.getValue();
        System.out.println("Ketinggian yang dipilih: " + selectedKetinggian);

        if (selectedKetinggian.equals("Rendah: 500-700 mdpl")) {
            KetinggianDAO.ketinggian = "rendah";
        } else if (selectedKetinggian.equals("Sedang: 700-1000 mdpl")) {
            KetinggianDAO.ketinggian = "sedang";
        } else if (selectedKetinggian.equals("Tinggi: 1000-1500 mdpl")) {
            KetinggianDAO.ketinggian = "tinggi";
        }
    }

}
