package cabinet;

import java.util.Objects;

public class Client {

    private int idClient;
    private static int id=0;
    protected String nume;
    protected String prenume;
    private int varsta;
    private String interventie;

    public Client()
    {

    }

    public Client(int idCl, String nume, String prenume, int varsta, String interventie)
    {
        this.idClient = idCl;
        this.nume = nume;
        this.prenume = prenume;
        this.varsta = varsta;
        this.interventie = interventie;
        ++id;
    }

    public Client(String nume, String prenume, int varsta, String interventie)
    {
        this.idClient = ++id;
        this.nume = nume;
        this.prenume = prenume;
        this.varsta = varsta;
        this.interventie = interventie;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getNume()
    {
        return nume;
    }

    public void setNume(String nume)
    {
        this.nume = nume;
    }

    public String getPrenume()
    {
        return prenume;
    }

    public void setPrenume(String prenume)
    {
        this.prenume = prenume;
    }

    public int getVarsta()
    {
        return varsta;
    }

    public void setVarsta(int varsta)
    {
        this.varsta = varsta;
    }

    public String getInterventie()
    {
        return interventie;
    }

    public void setInterventie(String interventie)
    {
        this.interventie = interventie;
    }

    @Override
    public String toString() {
        return "Clientul " + nume + " " + prenume + " cu varsta de " + varsta +
                " ani are o programare pentru " + interventie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return nume.equals(client.nume) && prenume.equals(client.prenume);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nume, prenume);
    }
}
