package DAO;

public class SuhuDAO {
    
    public static String idSuhu, suhu;

    public SuhuDAO(String idSuhu, String suhu) {
        this.idSuhu = idSuhu;
        this.suhu = suhu;
    }

    public String getIdSuhu() {
        return idSuhu;
    }

    public void setIdSuhu(String idSuhu) {
        this.idSuhu = idSuhu;
    }

    public String getSuhu() {
        return suhu;
    }

    public void setSuhu(String suhu) {
        this.suhu = suhu;
    }
    
    
}
