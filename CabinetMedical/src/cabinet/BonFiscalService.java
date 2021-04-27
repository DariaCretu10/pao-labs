package cabinet;

import java.io.*;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class BonFiscalService {



    public static void scrieInAudit(String actiune) {
        try {
            FileWriter writer1 = new FileWriter("src/cabinet/servAudit.csv", true);
            LocalDateTime timp = LocalDateTime.now();
            DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            String timpFormatat = timp.format(format);
            String actiuneFinal = actiune + "," + timpFormatat;
            writer1.write(actiuneFinal);
            writer1.write('\n');
            writer1.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readBonuri(ArrayList<BonFiscal> bonuri) throws IOException {
        BufferedReader csvReader = new BufferedReader(new FileReader("src/cabinet/Bon.csv"));
        String row;
        while ((row = csvReader.readLine()) != null) {
            String[] data = row.split(",");
            if (data.length == 6) {
                BonFiscal bon = new BonFiscal(Integer.valueOf(data[0]), Integer.valueOf(data[1]), data[2], Integer.valueOf(data[3]), Integer.valueOf(data[4]), LocalDate.parse(data[5]));
                bonuri.add(bon);
            } else {
                BonFiscal bon = new BonFiscal(Integer.valueOf(data[0]), Integer.valueOf(data[1]), data[2], Integer.valueOf(data[3]), LocalDate.parse(data[4]));
                bonuri.add(bon);
            }


        }
        csvReader.close();
    }

    public static void writeBonuri(ArrayList<BonFiscal> bonuri) {
        try {
            FileWriter csvWriter = new FileWriter("src/cabinet/Bon.csv");
            for (BonFiscal bon : bonuri) {
                String elem = bon.getIdClient() + "," + bon.getIdMedic() + "," + bon.getServiciu() + "," +
                        bon.getIdBon() + "," + bon.getPret() + "," + bon.getData();
                csvWriter.write(elem);
                csvWriter.write('\n');

            }
            csvWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        scrieInAudit("CitireDinFisierBonuri");

    }


    public static void afisareBonData(ArrayList<BonFiscal> bonuri) {
        System.out.println("Introduceti data dorita : ");
        Scanner scanner1 = new Scanner(System.in);
        String date = scanner1.nextLine();
        LocalDate data = LocalDate.parse(date);
        for (BonFiscal bon : bonuri) {
            if (bon.getData().equals(data))
                System.out.println(bon.toString());
        }
    }

    public static ArrayList<BonFiscal> adaugareBon(ArrayList<BonFiscal> bonuri)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti id-ul clientului :");
        int idCl = scanner.nextInt();
        System.out.println("Introduceti id-ul medicului :");
        int idMed = scanner.nextInt();
        System.out.println("Introduceti serviciul furnizat :");
        String serviciu = scanner.next();
        System.out.println("Introduceti pretul serviciului : ");
        int pret = scanner.nextInt();
        System.out.println("Introduceti data bonului : ");
        String date = scanner.next();
        LocalDate data = LocalDate.parse(date);
        int idBonMaxi = 0;
        for (BonFiscal bon : bonuri )
        {
            if ( bon.getIdBon() > idBonMaxi )
                idBonMaxi = bon.getIdBon();
        }
        BonFiscal bonNou = new BonFiscal(idCl,idMed,serviciu,idBonMaxi+1, pret, data);
        bonuri.add(bonNou);
        writeBonuri(bonuri);
        scrieInAudit("adaugareBon");
        return bonuri;
    }

    public static void afisareBon(ArrayList<BonFiscal> bonuri) {
        System.out.println("Lista bonurilor curente este : ");
        for (BonFiscal bon : bonuri) {
            System.out.println(bon.toString());
        }
        scrieInAudit("AfisareBonuri");
    }

    public static void stergeBon(ArrayList<BonFiscal> bonuri) throws MyException {
        Scanner scanner1 = new Scanner(System.in);
        BonFiscal bonSters = new BonFiscal();
        System.out.println("Introduceti id-ul bonului de sters : ");
        int id = scanner1.nextInt();
        bonSters = obtineBonById(bonuri, id);
        if ( bonSters != null)
        {
            bonuri.remove(bonSters);
            writeBonuri(bonuri);
            scrieInAudit("EliminaBonFiscal");
            System.out.println("Lista actualizata a bonurilor :");
            for ( BonFiscal bon : bonuri )
                System.out.println(bon.toString());
        }
        else
        {
            throw new MyException ("Introduceti id valid!");
        }
    }

    public static BonFiscal obtineBonById(ArrayList<BonFiscal> bonuri, int idBon)
    {
        for (BonFiscal bon :bonuri)
        {
            if ( bon.getIdBon() == idBon )
                return bon;
        }
        return null;
    }

}
