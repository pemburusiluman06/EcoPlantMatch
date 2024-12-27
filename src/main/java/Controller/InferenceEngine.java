package Controller;

import java.util.*;

public class InferenceEngine {

    public Map<String, Double> combineEvidence(Map<String, Double>... evidence) {
        if (evidence.length == 0) {
            return new HashMap<>();
        }

        Map<String, Double> result = new HashMap<>(evidence[0]);

        for (int i = 1; i < evidence.length; i++) {
            result = combineTwoEvidences(result, evidence[i]);
        }

        return result;
    }

    private Map<String, Double> combineTwoEvidences(Map<String, Double> m1, Map<String, Double> m2) {
        Map<String, Double> combined = new HashMap<>();
        double conflictFactor = 0.0;

        // Calculate intersection and conflict
        for (Map.Entry<String, Double> e1 : m1.entrySet()) {
            for (Map.Entry<String, Double> e2 : m2.entrySet()) {
                String plant = e1.getKey();
                if (plant.equals(e2.getKey())) {
                    double intersectionBelief = e1.getValue() * e2.getValue();
                    combined.merge(plant, intersectionBelief, Double::sum);
                } else {
                    conflictFactor += e1.getValue() * e2.getValue();
                }
            }
        }

        // Normalize beliefs
        if (conflictFactor < 1.0) {
            double normalizationFactor = 1.0 / (1.0 - conflictFactor);
            for (Map.Entry<String, Double> entry : combined.entrySet()) {
                combined.put(entry.getKey(), entry.getValue() * normalizationFactor);
            }
        }

        return combined;
    }
}
