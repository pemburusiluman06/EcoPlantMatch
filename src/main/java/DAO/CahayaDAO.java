package DAO;

public class CahayaDAO {

    /**
     *
     */
    public static String idCahaya, jenisCahaya;

    public CahayaDAO(String idCahaya, String jenisCahaya) {
        this.idCahaya = idCahaya;
        this.jenisCahaya = jenisCahaya;
    }

    public String getIdCahaya() {
        return idCahaya;
    }

    public void setIdCahaya(String idCahaya) {
        this.idCahaya = idCahaya;
    }

    public String getJenisCahaya() {
        return jenisCahaya;
    }

    public void setJenisCahaya(String jenisCahaya) {
        this.jenisCahaya = jenisCahaya;
    }
    
    
}
