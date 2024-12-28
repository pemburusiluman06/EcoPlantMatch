package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import DAO.CahayaDAO;
import DAO.CurahHujanDAO;
import DAO.DBController;
import DAO.JenisTanahDAO;
import DAO.KetinggianDAO;
import DAO.SuhuDAO;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.scene.control.TextArea;

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
    private Label curahHujan;
    @FXML
    private Button homeBtn;
    @FXML
    private TextArea hasilInferensi;

    private DBController db;
    private InferenceEngine ds;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        db = new DBController();
        ds = new InferenceEngine();

        homeBtn.setOnAction((ActionEvent event) -> {
            Fungsi.ChangeScene(event, "/UI/Home.fxml", "Home");
            CahayaDAO.jenisCahaya = null;
            KetinggianDAO.ketinggian = null;
            SuhuDAO.suhu = null;
            JenisTanahDAO.jenisTanah = null;
            CurahHujanDAO.curahHujan = null;
        });

        cahaya.setText(CahayaDAO.jenisCahaya);
        ketinggian.setText(KetinggianDAO.ketinggian);
        suhu.setText(SuhuDAO.suhu);
        tanah.setText(JenisTanahDAO.jenisTanah);
        curahHujan.setText(CurahHujanDAO.curahHujan);

        try {
            Map<String, Double> hasil = hitungRekomendasi();
            tampilkanHasil(hasil);
        } catch (Exception e) {
            hasilInferensi.setText("Error calculating recommendations: " + e.getMessage());
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
            hasilInferensi.setText("Rekomendasi tidak ditemukan");
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("Rekomendasi tanaman:\n\n");

        // Create a new list for sorting to avoid concurrent modification
        List<Map.Entry<String, Double>> urutanHasil = new ArrayList<>(results.entrySet());

        // Buat urutan
        Collections.sort(urutanHasil, (e1, e2) -> Double.compare(e2.getValue(), e1.getValue()));

        // Tampilkan hasil
        int count = 0;
        for (Map.Entry<String, Double> entry : urutanHasil) {
            if (count >= 5) {
                break;  
            }
            String namaTanaman = db.getNamaTanaman(entry.getKey());
            double belief = entry.getValue() * 100;

            sb.append(String.format("%d. %s: %.1f%%\n",
                    count + 1,
                    namaTanaman != null ? namaTanaman : entry.getKey(),
                    belief));
            count++;
        }

        hasilInferensi.setText(sb.toString());
    }
}
