/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import Controller.Fungsi;
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
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Dialog;

public class Pertanyaan5Controller implements Initializable {

    public static String selectedCurahHujan;
    
    @FXML
    private Button KlasifikasiBtn;

    @FXML
    private Button homeBtn;

    @FXML
    private Button lanjutBtn;

    @FXML
    private Button kembaliBtn;

    @FXML
    private ChoiceBox<String> curahHujanCheckbox;
    private String[] CurahHujan = {
        "Tinggi (300 – 500 mm)",
        "Sedang ( 100 – 300 mm)",
        "Rendah ( < 200 mm)"
    };

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        curahHujanCheckbox.getItems().addAll(CurahHujan);
        curahHujanCheckbox.setOnAction(this::getCurahHujan);

        lanjutBtn.setOnAction((ActionEvent event) -> {
            if (CurahHujanDAO.curahHujan == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Anda belum memilh curah hujan");
                alert.show();
            } else {
                Fungsi.lastPage = "/UI/akhir.fxml";
                Fungsi.ChangeScene(event, "/UI/akhir.fxml", "EcoPlantMatch - Rekomendasi");
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
            Fungsi.lastPage = "/UI/Pertanyaan4.fxml";
            Fungsi.ChangeScene(event, "/UI/Pertanyaan4.fxml", "EcoPlantMatch - Pilih Jenis Tanah");
        });
    }

    private void getCurahHujan(ActionEvent t) {
        selectedCurahHujan = curahHujanCheckbox.getValue();
        System.out.println("Curah hujan yang di pilih: " + selectedCurahHujan);

        if (selectedCurahHujan.equals("Tinggi (300 – 500 mm)")) {
            CurahHujanDAO.curahHujan = "Tinggi";
        } else if (selectedCurahHujan.equals("Sedang ( 100 – 300 mm)")) {
            CurahHujanDAO.curahHujan = "Sedang";
        } else if (selectedCurahHujan.equals("Rendah ( < 200 mm)")) {
            CurahHujanDAO.curahHujan = "Rendah";
        }
    }
}
