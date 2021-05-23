package cabinet;

public class Dermatolog extends Medic {

    private Boolean rezident;

    public Dermatolog()
    {

    }

    public Dermatolog(String specialitate, String nume, String prenume, int varsta, int vechime, Boolean rezident)
    {
        super(specialitate, nume, prenume, varsta, vechime);
        this.rezident = rezident;
    }

    public Boolean getRezident()
    {
        return rezident;
    }

    public void setRezident(Boolean rezident)
    {
        this.rezident = rezident;
    }

    private String Rezident(){
        if(this.rezident == Boolean.TRUE)
            return " si este medic rezident.";
        return " si nu este medic rezident.";
    }

    @Override
    public String toString()
    {
        return super.toString() + Rezident();
    }


}
