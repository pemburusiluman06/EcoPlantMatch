package DAO;

public class TanamanDAO {
    
    String idTanaman, namaTanaman;

    public TanamanDAO(String idTanaman, String namaTanaman) {
        this.idTanaman = idTanaman;
        this.namaTanaman = namaTanaman;
    }

    public String getIdTanaman() {
        return idTanaman;
    }

    public void setIdTanaman(String idTanaman) {
        this.idTanaman = idTanaman;
    }

    public String getNamaTanaman() {
        return namaTanaman;
    }

    public void setNamaTanaman(String namaTanaman) {
        this.namaTanaman = namaTanaman;
    }
   
}
