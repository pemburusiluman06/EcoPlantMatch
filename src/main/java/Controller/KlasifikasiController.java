package Controller;

import DAO.CahayaDAO;
import DAO.CurahHujanDAO;
import DAO.JenisTanahDAO;
import DAO.KetinggianDAO;
import DAO.SuhuDAO;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class KlasifikasiController implements Initializable{

    @FXML
    private Button KlasifikasiBtn;

    @FXML
    private Button homeBtn;
    
    @FXML
    private Button kembaliBtn;

    @FXML
    void GoToKlasifiaksi(ActionEvent event) {
        try {
            // Load the KlasifikasiPage.fxml
            Parent klasifikasiPage = FXMLLoader.load(getClass().getResource("Klasifikasi.fxml"));
            Scene klasifikasiScene = new Scene(klasifikasiPage);

            // Get the current stage
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(klasifikasiScene);
            stage.setTitle("Halaman Klasifikasi");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void GoToStart(ActionEvent event) {
        try {
            // Load the StartPage.fxml
            Parent startPage = FXMLLoader.load(getClass().getResource("Start.fxml"));
            Scene startScene = new Scene(startPage);

            // Get the current stage
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(startScene);
            stage.setTitle("Halaman Start");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    String title;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        if(Fungsi.lastPage.equals("/UI/homepage.fxml")){
            title = "EcoPlantMatch - Home";
        }else if(Fungsi.lastPage.equals("/UI/Pertanyaan1.fxml")){
            title = "EcoPlantMatch - Pilih Jenis Tanah";
        }else if(Fungsi.lastPage.equals("/UI/Pertanyaan2.fxml")){
            title = "EcoPlantMatch - Pilih Ketinggian";
        }else if(Fungsi.lastPage.equals("/UI/Pertanyaan3.fxml")){
            title = "EcoPlantMatch - Pilih Intensitas Cahaya";
        }else if(Fungsi.lastPage.equals("/UI/Pertanyaan4.fxml")){
            title = "EcoPlantMatch - Pilih Kondisi Suhu";
        }else if(Fungsi.lastPage.equals("/UI/Pertanyaan5.fxml")){
            title = "EcoPlantMatch - Pilih Curah Hujan";
        }
        
        homeBtn.setOnAction((ActionEvent event) -> {
            Dialog<ButtonType> dialog = new Dialog<>();
            dialog.setTitle("EcoPlantMatch");
            dialog.setHeaderText("Anda akan kembali ke halaman utama!");
            dialog.setContentText("Apakah anda yakin ingin keluar?");

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
           Fungsi.ChangeScene(event, Fungsi.lastPage, title); 
        });
    }
}
