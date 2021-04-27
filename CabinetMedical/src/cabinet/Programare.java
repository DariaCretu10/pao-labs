package cabinet;

public class Programare {

    private int idProgram ;
    private String data;
    private String ora;
    private String client;
    private String medic;
    private int pret;
    private static int id=0;

    public Programare()
    {

    }

    public Programare(int idProg,String data, String ora, String client, String medic, int pret)
    {
        this.idProgram = idProg;
        this.data = data;
        this.ora = ora;
        this.client = client;
        this.medic = medic;
        this.pret = pret;
        ++id;
    }

    public Programare(String data, String ora, String client, String medic, int pret)
    {
        this.idProgram = ++id;
        this.data = data;
        this.ora = ora;
        this.client = client;
        this.medic = medic;
        this.pret = pret;
    }


    public int getIdProgram() {
        return idProgram;
    }

    public void setIdProgram(int idProgram) {
        this.idProgram = idProgram;
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
