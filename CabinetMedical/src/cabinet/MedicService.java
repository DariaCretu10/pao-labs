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
        Medic medicNou = new Medic(specialitate, nume, prenume, varsta, vechime);
        medici.add(medicNou);
        writeMedici(medici);
        scrieInAudit("adaugareMedic");
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



    public static ArrayList<Medic> stergeMedic(ArrayList<Medic> medici)
    {
        Scanner scanner1 = new Scanner(System.in);
        Medic medicSters = new Medic();
        medicSters = null;
        while ( medicSters == null)
        {
            System.out.println("Introduceti id-ul medicului de sters : ");
            int id = scanner1.nextInt();
            medicSters = obtineMedicById(medici, id);
            if (medicSters == null)
                System.out.println("Introduceti un id valid!");
        }
        medici.remove(medicSters);
        writeMedici(medici);
        scrieInAudit("stergereMedic");
        return medici;

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

    public static Medic editareVechime(Medic medic, int vechime)
    {
        medic.setVechime(vechime);
        scrieInAudit("editareMedic");
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



}
