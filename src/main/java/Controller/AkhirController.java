package Controller;

import DAO.CahayaDAO;
import DAO.CurahHujanDAO;
import DAO.DBController;
import DAO.JenisTanahDAO;
import DAO.KetinggianDAO;
import DAO.SuhuDAO;
import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import DAO.DBController;
import java.sql.PreparedStatement;
import javafx.geometry.Pos;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableRow;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class AkhirController implements Initializable {

    @FXML
    private Button KlasifikasiBtn;

    @FXML
    private Button homeBtn;

    @FXML
    private TableView<HasilInferensi> TabelRekomen;

    @FXML
    private TableColumn<HasilInferensi, Integer> No;

    @FXML
    private TableColumn<HasilInferensi, String> jenisTanaman;

    @FXML
    private TableColumn<HasilInferensi, String> keterangan;

    @FXML
    private TableColumn<HasilInferensi, String> nilaiBelief;

    @FXML
    private Label labelTanah;
    @FXML
    private Label labelKetinggian;
    @FXML
    private Label labelCahaya;
    @FXML
    private Label labelSuhu;
    @FXML
    private Label labelCurahHujan;

    @FXML
    private Button kembaliBtn;

    String query = null;

    private DBController db;
    private InferenceEngine ds;

    public static class HasilInferensi {

        private final Integer nomor;
        private final String namaTanaman;
        private final String beliefPercentage;
        private final String keterangan;

        public HasilInferensi(Integer nomor, String namaTanaman, String beliefPercentage, String keterangan) {
            this.nomor = nomor;
            this.namaTanaman = namaTanaman;
            this.beliefPercentage = beliefPercentage;
            this.keterangan = keterangan;
        }

        public Integer getNomor() {
            return nomor;
        }

        public String getNamaTanaman() {
            return namaTanaman;
        }

        public String getBeliefPercentage() {
            return beliefPercentage;
        }

        public String getKeterangan() {
            return keterangan;
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        db = new DBController();
        ds = new InferenceEngine();

        labelTanah.setText("Tanah : " + JenisTanahDAO.jenisTanah);
        labelKetinggian.setText("Ketinggian : " + Pertanyaan2Controller.selectedKetinggian);
        labelCahaya.setText(CahayaDAO.jenisCahaya);
        labelSuhu.setText("Suhu : " + Pertanyaan4Controller.selectedSuhu);
        labelCurahHujan.setText("Curah Hujan : " + Pertanyaan5Controller.selectedCurahHujan);

        // Inisialisasi kolom-kolom tabel
        No.setCellValueFactory(new PropertyValueFactory<>("nomor"));
        jenisTanaman.setCellValueFactory(new PropertyValueFactory<>("namaTanaman"));
        nilaiBelief.setCellValueFactory(new PropertyValueFactory<>("beliefPercentage"));
        keterangan.setCellValueFactory(new PropertyValueFactory<>("keterangan"));

        // Mencegah resize kolom
        TabelRekomen.getColumns().forEach(column -> column.setResizable(false));

        // Mencegah posisi kolom diubah-ubah
        TabelRekomen.getColumns().forEach(column -> column.setReorderable(false));

        // Set wrapping untuk kolom keterangan
        keterangan.setCellFactory(tc -> new TableCell<HasilInferensi, String>() {
            private final Label label;

            {
                label = new Label();
                label.setWrapText(true);
                label.setMaxWidth(Double.MAX_VALUE); // Memastikan label mengisi lebar sel
                setGraphic(label);
            }

            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setGraphic(null);
                } else {
                    label.setText(item);
                    setGraphic(label);

                    // Sesuaikan tinggi baris
                    double textHeight = computeTextHeight(label.getFont(), item, getTableColumn().getWidth());
                    setPrefHeight(textHeight + 20); // Tambahkan padding
                }
            }
        });

        // Nonaktifkan horizontal scrollbar
        TabelRekomen.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        // Set row factory untuk mengatur tinggi baris minimum
        TabelRekomen.setRowFactory(tv
                -> {
            TableRow<HasilInferensi> row = new TableRow<>();
            row.setMinHeight(40); // Tinggi minimum baris
            return row;
        }
        );

        KlasifikasiBtn.setOnAction(
                (ActionEvent event) -> {
                    Fungsi.ChangeScene(event, "/UI/Klasifikasi.fxml", "EcoPlantMatch - Klasifikasi");
                }
        );

        homeBtn.setOnAction(
                (ActionEvent event) -> {
                    Dialog<ButtonType> dialog = new Dialog<>();
                    dialog.setTitle("EcoPlantMatch");
                    dialog.setHeaderText("Anda akan kembali ke halaman utama!");
                    dialog.setContentText("Apakah anda yakin ingin keluar");

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
                }
        );

        kembaliBtn.setOnAction((ActionEvent event) -> {
            Dialog<ButtonType> dialog = new Dialog<>();
            dialog.setTitle("EcoPlantMatch");
            dialog.setHeaderText("Anda akan kembali ke halaman utama!");
            dialog.setContentText("Apakah anda yakin ingin keluar");

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
        try {
            Map<String, Double> hasil = hitungRekomendasi();
            tampilkanHasil(hasil);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Map<String, Double> hitungRekomendasi() {
        try {

            Map<String, Double> tanahBeliefs = new HashMap<>(db.getTanahBeliefs(JenisTanahDAO.jenisTanah));
            Map<String, Double> suhuBeliefs = new HashMap<>(db.getSuhuBeliefs(SuhuDAO.suhu));
            Map<String, Double> cahayaBeliefs = new HashMap<>(db.getCahayaBeliefs(CahayaDAO.jenisCahaya));
            Map<String, Double> ketinggianBeliefs = new HashMap<>(db.getKetinggianBeliefs(KetinggianDAO.ketinggian));
            Map<String, Double> curahHujanBeliefs = new HashMap<>(db.getCurahHujanBeliefs(CurahHujanDAO.curahHujan));

            // Gunakan metode dempster shafer untuk menggabungkan fakta yang ada
            return ds.gabunganFakta(
                    tanahBeliefs,
                    suhuBeliefs,
                    cahayaBeliefs,
                    ketinggianBeliefs,
                    curahHujanBeliefs
            );
        } catch (Exception e) {
            e.printStackTrace();
            return new HashMap<>();
        }
    }

    private void tampilkanHasil(Map<String, Double> results) {
        if (results == null || results.isEmpty()) {
            // Tampilkan pesan error dalam tabel
            ObservableList<HasilInferensi> errorData = FXCollections.observableArrayList(
                    new HasilInferensi(1, "Rekomendasi tidak ditemukan", "-", "-")
            );
            TabelRekomen.setItems(errorData);
            return;
        }

        List<Map.Entry<String, Double>> urutanHasil = new ArrayList<>(results.entrySet());
        Collections.sort(urutanHasil, (e1, e2) -> Double.compare(e2.getValue(), e1.getValue()));

        ObservableList<HasilInferensi> dataHasil = FXCollections.observableArrayList();

        int count = 0;
        for (Map.Entry<String, Double> entry : urutanHasil) {
            if (count >= 5) {
                break;
            }

            String namaTanaman = db.getNamaTanaman(entry.getKey());
            double belief = entry.getValue() * 100;
            String penjelasan = db.getKeterangan(namaTanaman);
            dataHasil.add(new HasilInferensi(
                    count + 1,
                    namaTanaman != null ? namaTanaman : entry.getKey(),
                    String.format("%.1f%%", belief),
                    penjelasan
            ));

            count++;
        }

        TabelRekomen.setItems(dataHasil);
    }

    private double computeTextHeight(Font font, String text, double wrappingWidth) {
        Text helper = new Text(text);
        helper.setFont(font);
        helper.setWrappingWidth(wrappingWidth - 20); // Sesuaikan margin
        return helper.getLayoutBounds().getHeight();
    }

}
