package cabinet;
import java.util.Objects;
public class Medic implements Comparable<Medic> {

    private int idMedic;
    private String specialitate;
    private String nume;
    private String prenume;
    private int varsta;
    private int vechime;
    private static int id=0;

    public Medic()
    {

    }

    public Medic(int idMed, String specialitate, String nume, String prenume, int varsta, int vechime)
    {
        ++id;
        this.idMedic = idMed;
        this.specialitate = specialitate;
        this.nume = nume;
        this.prenume = prenume;
        this.varsta = varsta;
        this.vechime = vechime;

    }

    public Medic(String specialitate, String nume, String prenume, int varsta, int vechime)
    {
        this.idMedic = ++id;
        this.specialitate = specialitate;
        this.nume = nume;
        this.prenume = prenume;
        this.varsta = varsta;
        this.vechime = vechime;
    }

    public int getIdMedic() {
        return idMedic;
    }

    public void setIdMedic(int idMedic) {
        this.idMedic = idMedic;
    }

    public String getSpecialitate()
    {
        return specialitate;
    }

    public void setSpecialitate(String specialitate)
    {
        this.specialitate = specialitate;
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

    public int getVechime()
    {
        return vechime;
    }

    public void setVechime(int vechime)
    {
        this.vechime = vechime;
    }

    @Override
    public String toString() {
        return "Medicul " + nume + " " + prenume + " cu varsta de " +
                varsta + " ani are o vechime de " + vechime + " ani si lucreaza in domeniul " + specialitate + " ;idMedic " + idMedic;
    }

    @Override
    public int compareTo(Medic medic) {

        return this.vechime - medic.vechime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Medic)) return false;
        Medic medic = (Medic) o;
        return Objects.equals(getNume(), medic.getNume()) && Objects.equals(getSpecialitate(), medic.getSpecialitate());
    }

}