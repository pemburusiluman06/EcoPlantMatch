package Controller;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

import java.util.HashMap;
import java.util.Map;

public class InferenceViewController {

    @FXML
    private ComboBox<String> soilTypeComboBox;

    @FXML
    private ComboBox<String> temperatureComboBox;

    @FXML
    private ComboBox<String> lightConditionComboBox;

    @FXML
    private ComboBox<String> rainfallComboBox;

    @FXML
    private ComboBox<String> altitudeComboBox;

    @FXML
    private Button recommendButton;

    @FXML
    private Label resultLabel;

    @FXML
    public void initialize() {
        // Initialize combo box values
        soilTypeComboBox.getItems().addAll("latosol", "kapur", "humus", "grumusol", "entisol", "andosol", "aluvial");
        temperatureComboBox.getItems().addAll("panas", "sedang", "dingin");
        lightConditionComboBox.getItems().addAll("Terkena cahaya dengan sempurna", "Cahaya sedikit terhalang", "Cahaya sangat terhalang");
        rainfallComboBox.getItems().addAll("rendah", "sedang", "tinggi");
        altitudeComboBox.getItems().addAll("600 -700mdpl", "700-1000mdpl", "1000-1500mdpl");
    }

    @FXML
    private void handleGetRecommendation() {
        // Get input values
        String soilType = soilTypeComboBox.getValue();
        String temperature = temperatureComboBox.getValue();
        String lightCondition = lightConditionComboBox.getValue();
        String rainfall = rainfallComboBox.getValue();
        String altitude = altitudeComboBox.getValue();

        // Validate input
        if (soilType == null || temperature == null || lightCondition == null || rainfall == null || altitude == null) {
            resultLabel.setText("Please select all inputs to get a recommendation.");
            return;
        }

        // Call inference engine
        String recommendation = inferRecommendation(soilType, temperature, lightCondition, rainfall, altitude);
        resultLabel.setText(recommendation);
    }

    private String inferRecommendation(String soilType, String temperature, String lightCondition, String rainfall, String altitude) {
        // Example Dempster-Shafer implementation
        Map<String, Double> beliefMass = new HashMap<>();

        // Example: Assign belief masses for conditions (these should come from your knowledge base)
        if (soilType.equals("humus")) {
            beliefMass.put("Plant A", 0.6);
            beliefMass.put("Plant B", 0.4);
        } else if (soilType.equals("latosol")) {
            beliefMass.put("Plant C", 0.7);
            beliefMass.put("Plant D", 0.3);
        }

        if (temperature.equals("sedang")) {
            beliefMass.put("Plant A", beliefMass.getOrDefault("Plant A", 0.0) + 0.5);
            beliefMass.put("Plant C", beliefMass.getOrDefault("Plant C", 0.5));
        }

        // Combine beliefs using Dempster's rule (simplified example)
        String bestPlant = null;
        double maxBelief = 0;
        for (Map.Entry<String, Double> entry : beliefMass.entrySet()) {
            if (entry.getValue() > maxBelief) {
                maxBelief = entry.getValue();
                bestPlant = entry.getKey();
            }
        }

        return bestPlant != null ? "Recommended Plant: " + bestPlant : "No suitable plant found based on the inputs.";
    }
}
