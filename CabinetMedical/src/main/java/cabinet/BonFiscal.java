package cabinet;
import java.util.ArrayList;
import java.util.Objects;
import java.time.LocalDate;

public class BonFiscal  {


    private int idClient;
    private int idMedic;
    private String serviciu;
    private int idBon;
    private int pret;
    protected LocalDate data;
    private static int id = 0;

    public BonFiscal()
    {

    }

    public BonFiscal(int idCl, int idMed, String serviciu, int BonId, int pret, LocalDate data)
    {
        this.idClient = idCl;
        this.idMedic = idMed;
        this.serviciu = serviciu;
        this.idBon = BonId;
        this.pret = pret;
        this.data = data;
        ++id;

    }

    public BonFiscal(int idCl, int idMed, String serviciu, int pret, LocalDate data)
    {
        this.idClient = idCl;
        this.idMedic = idMed;
        this.serviciu = serviciu;
        this.idBon = ++id;
        this.pret = pret;
        this.data = data;

    }

    public static void stergeBon(ArrayList<BonFiscal> bonuri) {
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public int getIdMedic() {
        return idMedic;
    }

    public void setIdMedic(int idMedic) {
        this.idMedic = idMedic;
    }

    public String getServiciu()
    {
        return serviciu;
    }
    public void setServiciu(String serviciu)
    {
        this.serviciu = serviciu;
    }

    public int getIdBon() {
        return idBon;
    }

    public void setIdBon(int idBon) {
        this.idBon = idBon;
    }

    public int getPret()
    {
        return pret;
    }
    public void setPret(int pret) {
        this.pret = pret;
    }

    public LocalDate getData() { return data;}
    public void setData(LocalDate data) { this.data = data;}

    @Override
    public String toString(){
        return "Acest bon cu id-ul " + idBon + " din data de " + data + " apartine clientului " + idClient +
                " care a avut o programare pentru " + serviciu + " la medicul " + idMedic +
                " al carei cost a fost " + pret;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BonFiscal)) return false;
        BonFiscal bon = (BonFiscal) o;
        return Objects.equals(getData(), bon.getData()) && Objects.equals(getIdBon(), bon.getIdBon());
    }

}
