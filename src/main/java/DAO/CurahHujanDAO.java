package DAO;


public class CurahHujanDAO {
    
    public static String idCurahHujan, curahHujan;

    public CurahHujanDAO(String idCurahHujan, String curahHujan) {
        this.idCurahHujan = idCurahHujan;
        this.curahHujan = curahHujan;
    }

    public String getIdCurahHujan() {
        return idCurahHujan;
    }

    public void setIdCurahHujan(String idCurahHujan) {
        this.idCurahHujan = idCurahHujan;
    }

    public String getCurahHujan() {
        return curahHujan;
    }

    public void setCurahHujan(String curahHujan) {
        this.curahHujan = curahHujan;
    }
    
}
