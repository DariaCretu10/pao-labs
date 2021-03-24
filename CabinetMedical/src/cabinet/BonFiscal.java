package cabinet;
import java.util.Objects;

public class BonFiscal  {
    private String numeClient;
    private String numeMedic;
    private String serviciu;
    private int id;
    private int pret;
    protected String data;

    public BonFiscal()
    {

    }

    public BonFiscal(String numeClient, String numeMedic, String serviciu, int id, int pret, String data)
    {
        this.numeClient = numeClient;
        this.numeMedic = numeMedic;
        this.serviciu = serviciu;
        this.id = id;
        this.pret = pret;
        this.data = data;

    }

    public String getnumeClient()
    {
        return numeClient;
    }
    public void setnumeClient(String numeClient)
    {
        this.numeClient  = numeClient;
    }

    public String getnumeMedic()
    {
        return numeMedic;
    }
    public void setnumeMedic(String numeMedic)
    {
        this.numeMedic = numeMedic;
    }

    public String getServiciu()
    {
        return serviciu;
    }
    public void setServiciu(String serviciu)
    {
        this.serviciu = serviciu;
    }

    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id  = id;
    }

    public int getPret()
    {
        return pret;
    }
    public void setPret(int pret) {
        this.pret = pret;
    }

    public String getData() { return data;}
    public void setData(String data) { this.data = data;}

    @Override
    public String toString(){
        return "Acest bon cu id-ul " + id +  " apartine clientului " + numeClient +
                " care a avut o programare pentru " + serviciu + " la medicul " + numeMedic +
                " al carei cost a fost " + pret;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BonFiscal)) return false;
        BonFiscal bon = (BonFiscal) o;
        return Objects.equals(getData(), bon.getData()) && Objects.equals(getId(), bon.getId());
    }

}
