package cabinet;

public class Programare {

    private int idProgram ;
    private String data;
    private String ora;
    private int idClient;
    private int idMedic;
    private int pret;
    private static int id=0;

    public Programare()
    {

    }

    public Programare(int idProg, String data, String ora, int client, int medic, int pret)
    {
        this.idProgram = idProg;
        this.data = data;
        this.ora = ora;
        this.idClient = client;
        this.idMedic = medic;
        this.pret = pret;
        ++id;
    }

    public Programare(String data, String ora, int client, int medic, int pret)
    {
        this.idProgram = ++id;
        this.data = data;
        this.ora = ora;
        this.idClient = client;
        this.idMedic = medic;
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
        return "Clientul cu id-ul " + idClient + " are o programare in data de " + data +
                " la ora " + ora + " cu doctorul cu id-ul " + idMedic + ". Costul este de : " + pret + " ; idProgramare: " + getIdProgram();
    }

}
