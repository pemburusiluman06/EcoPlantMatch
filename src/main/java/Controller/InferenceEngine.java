package Controller;

import java.util.*;

public class InferenceEngine {

    public Map<String, Double> gabunganFakta(Map<String, Double>... faktaPengguna) {
    if (faktaPengguna.length == 0) {
        return new HashMap<>();
    }

    // Filter fakta yang kosong
    List<Map<String, Double>> fakta = new ArrayList<>();
    for (Map<String, Double> e : faktaPengguna) {
        if (e != null && !e.isEmpty()) {
            fakta.add(new HashMap<>(e));  // masukkan fakta
        }
    }

    if (fakta.isEmpty()) {
        return new HashMap<>();
    }


    // Mulai dari 0
    Map<String, Double> hasil = new HashMap<>(fakta.get(0));
    

    // gabungkan hasil fakta yang ada dengan hasil fakta sebelumnya
    for (int i = 1; i < fakta.size(); i++) {
       
        hasil = GabunganDuaFakta(hasil, faktaPengguna[i]);
        
        //cek hasil di terminal
        //System.out.println("Result: " + result);
    }


    return NormalisasiHasil(hasil);
}

    private Map<String, Double> GabunganDuaFakta(Map<String, Double> m1, Map<String, Double> m2) {
        Map<String, Double> gabungan = new HashMap<>();
        double k = 0.0; // nilai konflik

        // Buat variabel baru untuk menyimpan nilai yang akan diproses (mencegah perubahan pada nilai asli) 
        List<Map.Entry<String, Double>> masukan1 = new ArrayList<>(m1.entrySet());
        List<Map.Entry<String, Double>> masukan2 = new ArrayList<>(m2.entrySet());

        // Menghitung nilai gabungan
        for (Map.Entry<String, Double> e1 : masukan1) {
            String tanaman1 = e1.getKey();
            double bel1 = e1.getValue();

            for (Map.Entry<String, Double> e2 : masukan2) {
                String tanaman2 = e2.getKey();
                double bel2 = e2.getValue();

                if (tanaman1.equals(tanaman2)) {
                    // jika tanaman sama gabungkan nilai belief
                    double gabunganBelief = bel1 * bel2;
                    gabungan.merge(tanaman1, gabunganBelief, Double::sum);
                } else {
                    // Jika tanaman berbeda hitung ulang nilai konflik
                    k += bel1 * bel2;
                }
            }
        }

        // Normalisasi dengan aturan kombinasi Dempster
        if (k < 1.0) {
            double faktor = 1.0 / (1.0 - k);
            Map<String, Double> normalized = new HashMap<>();
            for (Map.Entry<String, Double> entry : gabungan.entrySet()) {
                normalized.put(entry.getKey(), entry.getValue() * faktor);
            }
            return normalized;
        }

        return gabungan;
    }

    private Map<String, Double> NormalisasiHasil(Map<String, Double> results) {
        // Buat map baru untuk hasil setelah dinormalisasi
        Map<String, Double> normalized = new HashMap<>();

        // hitung total nilai belief
        double sum = 0.0;
        for (double value : results.values()) {
            sum += value;
        }

        // normalisasi jika jumlahnya tidak 0 atau 1
        if (sum > 0 && Math.abs(sum - 1.0) > 0.0001) {
            for (Map.Entry<String, Double> entry : results.entrySet()) {
                normalized.put(entry.getKey(), entry.getValue() / sum);
            }
            return normalized;
        }

        return results;
    }
}
