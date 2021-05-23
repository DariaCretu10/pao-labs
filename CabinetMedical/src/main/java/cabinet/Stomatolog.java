package cabinet;

public class Stomatolog extends Medic {

    private Program program; //dimineata/dupa-amiaza
    private Boolean rezident;

    private Stomatolog()
    {

    }
    public Stomatolog(String specialitate, String nume, String prenume, int varsta, int vechime, Program program, Boolean rezident)
    {
        super(specialitate, nume, prenume, varsta, vechime);
        this.program = program;
        this.rezident = rezident;
    }

    public Program getProgram()
    {
        return program;
    }

    public void setProgram(Program program)
    {
        this.program = program;
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
        return super.toString() + ". Acest medic lucreaza in tura de " + program + Rezident();
    }
}
