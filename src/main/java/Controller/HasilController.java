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
        });

        cahaya.setText(CahayaDAO.jenisCahaya);
        ketinggian.setText(KetinggianDAO.ketinggian);
        suhu.setText(SuhuDAO.suhu);
        tanah.setText(JenisTanahDAO.jenisTanah);
        curahHujan.setText(CurahHujanDAO.curahHujan);

        try {
            Map<String, Double> results = calculateRecommendations();
            displayResults(results);
        } catch (Exception e) {
            hasilInferensi.setText("Error calculating recommendations: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private Map<String, Double> calculateRecommendations() {
        // Get belief values from database for each factor
        Map<String, Double> tanahBeliefs = db.getTanahBeliefs(JenisTanahDAO.jenisTanah);
        Map<String, Double> suhuBeliefs = db.getSuhuBeliefs(SuhuDAO.suhu);
        Map<String, Double> cahayaBeliefs = db.getCahayaBeliefs(CahayaDAO.jenisCahaya);
        Map<String, Double> ketinggianBeliefs = db.getKetinggianBeliefs(KetinggianDAO.ketinggian);
        Map<String, Double> curahHujanBeliefs = db.getCurahHujanBeliefs(CurahHujanDAO.curahHujan);

        // Combine evidence using Dempster-Shafer
        Map<String, Double> combinedBeliefs = ds.combineEvidence(
                tanahBeliefs, suhuBeliefs, cahayaBeliefs, ketinggianBeliefs, curahHujanBeliefs
        );

        return combinedBeliefs;
    }

    private void displayResults(Map<String, Double> results) {
        if (results == null || results.isEmpty()) {
            hasilInferensi.setText("No recommendations found.");
            return;
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("Plant Recommendations:\n\n");
        
        // Sort results by belief value
        List<Map.Entry<String, Double>> sortedResults = new ArrayList<>(results.entrySet());
        sortedResults.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));
        
        for (Map.Entry<String, Double> entry : sortedResults) {
            String plantName = db.getNamaTanaman(entry.getKey());
            double belief = entry.getValue() * 100;
            sb.append(String.format("%s: %.2f%%\n", plantName, belief));
        }
        
        hasilInferensi.setText(sb.toString());
    }
}
