package cabinet;

public class MedicService
{   public static void afisareMedici(Medic[] medici)
    {
        for (Medic medic : medici)
        {
            System.out.println(medic.toString());
        }
    }



    public static Medic[] stergeMedic(Medic[] medici, Medic medicSters)
    {
        Medic[] mediciNou = new Medic[medici.length-1];
        for ( int i=0; i<mediciNou.length; i++)
        {
            if ( medici[i].equals(medicSters))
                {
                    for (int j=i; j<mediciNou.length; j++)
                    {
                        medici[j] = medici[j+1];
                    }
                }

            mediciNou[i] = medici[i];
        }
        return mediciNou;
    }
}
