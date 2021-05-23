package cabinet;

import javax.xml.crypto.Data;
import java.io.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.sql.PreparedStatement;

public class BonFiscalService {



    public static void scrieInAudit(String actiune) {
        try {
            FileWriter writer1 = new FileWriter("src/main/java/cabinet/servAudit.csv", true);
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

   /* public void readBonuri(ArrayList<BonFiscal> bonuri) throws IOException {
        BufferedReader csvReader = new BufferedReader(new FileReader("src/main/java/cabinet/Bon.csv"));
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
            FileWriter csvWriter = new FileWriter("src/main/java/cabinet/Bon.csv");
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

    }*/


    public static void afisareBonData() throws SQLException {
        Database database = new Database();
        Connection connection = database.Connection();
        ArrayList<BonFiscal> bonuri = new ArrayList<>();
        bonuri = database.getAllBonuri();
        System.out.println("Introduceti data dorita : ");
        Scanner scanner1 = new Scanner(System.in);
        String date = scanner1.nextLine();
        LocalDate data = LocalDate.parse(date);
        for (BonFiscal bon : bonuri) {
            if (bon.getData().equals(data))
                System.out.println(bon.toString());
        }
    }

    public static void adaugareBon() throws SQLException {
        Database database = new Database();
        Connection connection = database.Connection();
        ArrayList<BonFiscal> bonuri = new ArrayList<>();
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
        String sql = "INSERT INTO bonfiscal (idClient, idMedic, serviciu, pret, data) VALUES (?, ?, ?, ?, ?)";

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, idCl);
        statement.setInt(2, idMed);
        statement.setString(3, serviciu);
        statement.setInt(4, pret);
        statement.setDate(5, Date.valueOf(data));

        int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("Un nou bon a fost inserat cu succes!");
        }
        scrieInAudit("adaugareBon");
        bonuri = database.getAllBonuri();
        System.out.println("Lista actualizata a bonurilor :");
        for ( BonFiscal bon : bonuri )
            System.out.println(bon.toString());
    }

    public static void afisareBon() {
        System.out.println("Lista bonurilor curente este : ");
        ArrayList<BonFiscal> bonuri = new ArrayList<>();
        Database database = new Database();
        Connection connection = database.Connection();
        try {
            bonuri = database.getAllBonuri();
            for (BonFiscal bon : bonuri) {
                System.out.println(bon.toString());
            }
            scrieInAudit("AfisareBonuri");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void stergeBon() throws MyException, SQLException {
        Database database = new Database();
        Connection connection = database.Connection();
        ArrayList<BonFiscal> bonuri = new ArrayList<>();
        bonuri = database.getAllBonuri();
        Scanner scanner1 = new Scanner(System.in);
        BonFiscal bonSters = new BonFiscal();
        System.out.println("Introduceti id-ul bonului de sters : ");
        int id = scanner1.nextInt();
        bonSters = obtineBonById(bonuri, id);
        if ( bonSters != null)
        {

            scrieInAudit("EliminaBonFiscal");
            String sql = "DELETE FROM bonfiscal WHERE idBon=?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Bonul a fost sters cu succes!");
            }
            bonuri = database.getAllBonuri();
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
