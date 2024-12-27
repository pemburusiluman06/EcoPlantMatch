package DAO;

public class JenisTanahDAO {
    
    public static String idTanah, jenisTanah;

    public JenisTanahDAO(String idTanah, String jenisTanah) {
        this.idTanah = idTanah;
        this.jenisTanah = jenisTanah;
    }

    public static String getIdTanah() {
        return idTanah;
    }

    public static void setIdTanah(String idTanah) {
        JenisTanahDAO.idTanah = idTanah;
    }

    public static String getJenisTanah() {
        return jenisTanah;
    }

    public static void setJenisTanah(String jenisTanah) {
        JenisTanahDAO.jenisTanah = jenisTanah;
    }

    
    
}
