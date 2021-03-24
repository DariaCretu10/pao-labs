package cabinet;

public class Programare {

    private String data;
    private String ora;
    private String client;
    private String medic;
    private int pret;

    public Programare()
    {

    }

    public Programare(String data, String ora, String client, String medic, int pret)
    {
        this.data = data;
        this.ora = ora;
        this.client = client;
        this.medic = medic;
        this.pret = pret;
    }

    public String getData()
    {
        return data;
    }
    public void setData(String data)
    {
        this.data = data;
    }

    public String getOra()
    {
        return ora;
    }
    public void setOra(String ora)
    {
        this.ora = ora;
    }

    public String getClient()
    {
        return client;
    }
    public void setClient(String client)
    {
        this.client = client;
    }

    public String getMedic()
    {
        return medic;
    }
    public void setMedic(String medic)
    {
        this.medic = medic;
    }

    public int getPret()
    {
        return pret;
    }

    public void setPret(int pret)
    {
        this.pret  = pret;
    }

    @Override
    public String toString() {
        return "Clientul " + client + " are o programare in data de " + data +
                " la ora " + ora + " cu doctorul " + medic;
    }

}
