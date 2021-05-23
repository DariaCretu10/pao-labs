package cabinet;
/*import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;*/
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import static cabinet.BonFiscalService.scrieInAudit;

public class MedicService

{

    /*public void readMedici (ArrayList<Medic> medici) throws IOException {
        BufferedReader csvReader = new BufferedReader(new FileReader("src/main/java/cabinet/Medic.csv"));
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
            FileWriter csvWriter = new FileWriter("src/main/java/cabinet/Medic.csv");
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
    }*/

    public static void adaugaMedic() throws SQLException {

        Database database = new Database();
        Connection connection = database.Connection();
        Scanner scanner = new Scanner(System.in);
        ArrayList<Medic> medici = new ArrayList<>();
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
        String sql = "INSERT INTO medic ( specialitate, nume, prenume, varsta, vechime) VALUES ( ?, ?, ?, ?, ?)";

        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, specialitate);
        statement.setString(2, nume);
        statement.setString(3, prenume);
        statement.setInt(4, varsta);
        statement.setInt(5, vechime);

        int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("Un nou medic a fost inserat cu succes!");
        }
    }

    public static void afisareMedici()
    {
        System.out.println("Lista medicilor : ");
        ArrayList<Medic> medici = new ArrayList<>();
        Database database = new Database();
        Connection connection = database.Connection();
        try {
            medici = database.getAllMedici();
            for (Medic medic : medici) {
                System.out.println(medic.toString());
            }
            scrieInAudit("AfisareMedici");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }



    public static void stergeMedic() throws MyException, SQLException {
        Database database = new Database();
        Connection connection = database.Connection();
        ArrayList<Medic> medici = new ArrayList<>();
        medici = database.getAllMedici();
        Scanner scanner1 = new Scanner(System.in);
        Medic medicSters = new Medic();
        System.out.println("Introduceti id-ul medicului de sters : ");
        int id = scanner1.nextInt();
        medicSters = obtineMedicById(medici, id);
        if ( medicSters != null)
        {

            String sql = "DELETE FROM medic WHERE idMedic=" + id;

            PreparedStatement statement = connection.prepareStatement(sql);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Medicul a fost sters cu succes!");
            }

        }
        else
        {
            throw new MyException ("Introduceti id valid!");
        }

    }


    public static void schimbaSpecializare() throws SQLException {
        Database database = new Database();
        Connection connection = database.Connection();
        ArrayList<Medic> medici = new ArrayList<>();
        medici = database.getAllMedici();
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Introduceti id-ul medicului pe care doriti sa il editati: ");
        int id = scanner2.nextInt();
        System.out.println("Introduceti noua specializare : ");
        String specializare = scanner2.next();

        String sql = "UPDATE medic SET specialitate=?  WHERE idMedic=?";

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, specializare);
        statement.setInt(2, id);
        int rowsUpdated = statement.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("Specializare editata cu succes!");
        }
        scrieInAudit("editareMedic");

    }

    public static void editareVechime() throws MyException, SQLException {
        Database database = new Database();
        Connection connection = database.Connection();
        ArrayList<Medic> medici = new ArrayList<>();
        medici = database.getAllMedici();
        Scanner scanner3 = new Scanner(System.in);
        System.out.println("Introduceti id-ul medicului pe care vreti sa il editati");
        int id = scanner3.nextInt();
        System.out.println("Introduceti vechimea pe care vreti sa o setati : ");
        int vechime = scanner3.nextInt();
        Medic medic = obtineMedicById(medici, id);
        if (medic.getVarsta() - vechime >=24 )
        {
            medic.setVechime(vechime);
            scrieInAudit("editareMedic");
        }
        else
        {
            throw new MyException ("Intre varsta medicului si vechime trebuie sa exista macar 24 de ani!");
        }


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
