package DAO;

public class KetinggianDAO {
    
    public static String idKetinggian, ketinggian;

    public KetinggianDAO(String idKetinggian, String ketinggian) {
        this.idKetinggian = idKetinggian;
        this.ketinggian = ketinggian;
    }

    public String getIdKetinggian() {
        return idKetinggian;
    }

    public void setIdKetinggian(String idKetinggian) {
        this.idKetinggian = idKetinggian;
    }

    public String getKetinggian() {
        return ketinggian;
    }

    public void setKetinggian(String ketinggian) {
        this.ketinggian = ketinggian;
    }
    
    
}
