package DAO;

import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBController {

    protected static final String DB_NAME = "ecoplantmatchDB";
    protected static final String DB_HOST = "localhost";
    protected static final String DB_USER = "root";
    protected static final String DB_PASS = "12345";
    private static Connection conn;
    private static Statement statement;
    // Constructor to establish a connection

    public static Connection getConn() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://" + DB_HOST + ":3306/" + DB_NAME, DB_USER, DB_PASS);
            System.out.println("Database connected");
            return conn;
        } catch (SQLException ex) {
            Logger.getLogger(DBController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }

    public static void closeConn(Connection conn) {
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Map<String, Double> getTanahBeliefs(String soilType) {
        Map<String, Double> beliefs = new HashMap<>();
        String query = "SELECT kode_tanaman, nilai FROM relasi_jenis_tanah "
                + "JOIN jenis_tanah ON relasi_jenis_tanah.kode_tanah = jenis_tanah.kode_tanah "
                + "WHERE nama_tanah = ?";

        try (Connection conn = getConn(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, soilType.toLowerCase());
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                beliefs.put(rs.getString("kode_tanaman"), rs.getDouble("nilai"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return beliefs;
    }

    public Map<String, Double> getSuhuBeliefs(String temperature) {
        Map<String, Double> beliefs = new HashMap<>();
        String query = "SELECT kode_tanaman, nilai FROM relasi_jenis_suhu "
                + "JOIN jenis_suhu ON relasi_jenis_suhu.kode_suhu = jenis_suhu.kode_suhu "
                + "WHERE jenis_suhu = ?";

        try (Connection conn = getConn(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, temperature);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                beliefs.put(rs.getString("kode_tanaman"), rs.getDouble("nilai"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return beliefs;
    }

    public Map<String, Double> getCahayaBeliefs(String sunlight) {
        Map<String, Double> beliefs = new HashMap<>();
        String query = "SELECT kode_tanaman, nilai FROM relasi_jenis_cahaya "
                + "JOIN cahaya ON relasi_jenis_cahaya.kode_cahaya = cahaya.kode_cahaya "
                + "WHERE jenis_cahaya = ?";

        try (Connection conn = getConn(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, sunlight);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                beliefs.put(rs.getString("kode_tanaman"), rs.getDouble("nilai"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return beliefs;
    }

    public Map<String, Double> getKetinggianBeliefs(String height) {
        Map<String, Double> beliefs = new HashMap<>();
        String query = "SELECT kode_tanaman, nilai FROM relasi_ketinggian_tanah "
                + "JOIN ketinggian_tanah ON relasi_ketinggian_tanah.kode_ketinggian = ketinggian_tanah.kode_ketinggian "
                + "WHERE jenis_ketinggian_tanah = ?";

        try (Connection conn = getConn(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, height);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                beliefs.put(rs.getString("kode_tanaman"), rs.getDouble("nilai"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return beliefs;
    }

    public Map<String, Double> getCurahHujanBeliefs(String height) {
        Map<String, Double> beliefs = new HashMap<>();
        String query = "SELECT kode_tanaman, nilai FROM relasi_curah_hujan "
                + "JOIN curah_hujan ON relasi_curah_hujan.kode_curah_hujan = curah_hujan.kode_curah_hujan "
                + "WHERE jenis_curah_hujan = ?";

        try (Connection conn = getConn(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, height);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                beliefs.put(rs.getString("kode_tanaman"), rs.getDouble("nilai"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return beliefs;
    }

    public String getNamaTanaman(String plantCode) {
        String query = "SELECT nama_tanaman FROM tanaman WHERE kode_tanaman = ?";

        try (Connection conn = getConn(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, plantCode);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getString("nama_tanaman");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return plantCode;
    }

    public String getKeterangan(String namaTanaman) {
        String query = "SELECT keterangan FROM tanaman WHERE nama_tanaman = ?";

        try (Connection conn = getConn(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, namaTanaman);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getString("keterangan");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return namaTanaman;
    }

}
