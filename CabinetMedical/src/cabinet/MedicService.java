package cabinet;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import static cabinet.BonFiscalService.scrieInAudit;

public class MedicService

{


    public void readMedici (ArrayList<Medic> medici) throws IOException {
        BufferedReader csvReader = new BufferedReader(new FileReader("src/cabinet/Medic.csv"));
        String row;
        while ((row = csvReader.readLine()) != null) {
            String[] data = row.split(",");
            if ( data.length == 5 )
                {
                    Medic medic = new Medic(data[0], data[1], data[2], Integer.valueOf(data[3]), Integer.valueOf(data[4]));
                    medici.add(medic);
                }
            else
                {
                    Medic medic = new Medic(Integer.valueOf(data[0]), data[1], data[2], data[3], Integer.valueOf(data[4]), Integer.valueOf(data[5]));
                    medici.add(medic);
                }

        }
        scrieInAudit("citesteDinFisierMedici");
        csvReader.close();
    }

    public static void writeMedici(ArrayList<Medic> medici)  {
        try {
            FileWriter csvWriter = new FileWriter("src/cabinet/Medic.csv");
            for (Medic medic : medici) {
                String elem = medic.getIdMedic() + "," + medic.getSpecialitate() + "," + medic.getNume() + "," + medic.getPrenume() + "," +
                        medic.getVarsta() + "," + medic.getVechime();
                csvWriter.write(elem);
                csvWriter.write('\n');

            }
            csvWriter.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        scrieInAudit("ScrieInFisierMedici");
    }

    public static void adaugaMedic(ArrayList<Medic> medici)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti specialitatea medicului : ");
        String specialitate = scanner.nextLine();
        System.out.println("Introduceti numele medicului : ");
        String nume  = scanner.nextLine();
        System.out.println("Introduceti prenumele medicului : ");
        String prenume = scanner.nextLine();
        System.out.println("Introduceti varsta medicului : ");
        int varsta = scanner.nextInt();
        System.out.println("Introduceti vechimea medicului : ");
        int vechime = scanner.nextInt();
        int idNou = idMax(medici);
        Medic medicNou = new Medic( idNou+1,specialitate, nume, prenume, varsta, vechime);
        medici.add(medicNou);
        writeMedici(medici);
        scrieInAudit("adaugareMedic");
        System.out.println("Lista acutalizata a medicilor :");
        for ( Medic medic : medici )
            System.out.println(medic.toString());
    }

    public static void afisareMedici(ArrayList<Medic> medici)
    {
        System.out.println("Lista medicilor : ");
        for (Medic medic : medici)
        {
            System.out.println(medic.toString());
        }
        scrieInAudit("afisareMedici");
    }



    public static void stergeMedic(ArrayList<Medic> medici) throws MyException {
        Scanner scanner1 = new Scanner(System.in);
        Medic medicSters = new Medic();
        System.out.println("Introduceti id-ul medicului de sters : ");
        int id = scanner1.nextInt();
        medicSters = obtineMedicById(medici, id);
        if ( medicSters != null)
        {
            medici.remove(medicSters);
            writeMedici(medici);
            scrieInAudit("EliminaMedic");
            System.out.println("Lista actualizata a medicilor : ");
            for ( Medic medic : medici )
                System.out.println(medic.toString());
        }
        else
        {
            throw new MyException ("Introduceti id valid!");
        }

    }


    public static Medic schimbaSpecializare(Medic medic)
    {
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Introduceti noua specializare : ");
        String specializare = scanner2.nextLine();
        medic.setSpecialitate(specializare);
        scrieInAudit("editareMedic");
        return medic;
    }

    public static Medic editareVechime(Medic medic) throws MyException {
        System.out.println("Introduceti vechimea pe care vreti sa o setati : ");
        Scanner scanner3 = new Scanner(System.in);
        int vechime = scanner3.nextInt();
        if (medic.getVarsta() - vechime >=24 )
        {
            medic.setVechime(vechime);
            scrieInAudit("editareMedic");
        }
        else
        {
            throw new MyException ("Intre varsta medicului si vechime trebuie sa exista macar 24 de ani!");
        }

        return medic;
    }

    public static Medic obtineMedicById(ArrayList<Medic> medici, int idMed)
    {
        for (Medic medic : medici)
        {
            if ( medic.getIdMedic() == idMed )
                return medic;
        }
        return null;
    }

    public static int idMax(ArrayList<Medic> medici)
    {
        int maxi = 0;
        for (Medic medic : medici )
        {
            if  ( medic.getIdMedic() > maxi )
            {
                maxi = medic.getIdMedic();
            }
        }
        return maxi;
    }


}
