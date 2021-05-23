package cabinet;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.SQLException;
import static cabinet.BonFiscalService.scrieInAudit;
import java.sql.PreparedStatement;

public class ProgramareService {



    public static void afisareProgramari()
    {
        System.out.println("Lista programarilor : ");
        ArrayList<Programare> programs = new ArrayList<>();
        Database database = new Database();
        Connection connection = database.Connection();
        try {
            programs = database.getAllProgramari();
            for (Programare programare : programs) {
                System.out.println(programare.toString());
            }
            scrieInAudit("AfisareProgramari");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void stergeProgramare() throws MyException, SQLException {
        Database database = new Database();
        Connection connection = database.Connection();
        Scanner scanner1 = new Scanner(System.in);
        ArrayList<Programare> programs = new ArrayList<>();
        programs = database.getAllProgramari();
        Programare progSters = new Programare();
        System.out.println("Introduceti id-ul programarii de sters : ");
        int id = scanner1.nextInt();
        progSters = obtineProgById(programs, id);
        if ( progSters != null)
        {
            String sql = "DELETE FROM programare WHERE idProgram=?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Programarea a fost stearsa cu succes!");
            }
        }
        else
        {
            throw new MyException ("Introduceti id valid!");
        }

    }


    public static void adaugaProgramare() throws SQLException {
        Database database = new Database();
        Connection connection = database.Connection();
        Scanner scanner = new Scanner(System.in);
        ArrayList<Programare> programs = new ArrayList<>();
        //programs = database.getAllProgramari();
        System.out.println("Introduceti data programarii (YYYY-MM-DD) : ");
        String data = scanner.nextLine();
        System.out.println("Introduceti ora programarii (HH-MM) : ");
        String ora  = scanner.nextLine();
        System.out.println("Introduceti id-ul clientului : ");
        int idClient = scanner.nextInt();
        System.out.println("Introduceti id-ul medicului : ");
        int idMedic = scanner.nextInt();
        System.out.println("Introduceti pretul : ");
        int pret = scanner.nextInt();
        String sql = "INSERT INTO programare ( data, ora, idClient, idMedic, pret) VALUES ( ?, ?, ?, ?, ?)";

        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, data);
        statement.setString(2, ora);
        statement.setInt(3, idClient);
        statement.setInt(4, idMedic);
        statement.setInt(5, pret);

        int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("O noua programare a fost inserata cu succes!");
        }
    }


    public static void editareProgramare() throws SQLException {
        Database database = new Database();
        Connection connection = database.Connection();
        Scanner scanner5 = new Scanner(System.in);
        System.out.println("Introduceti id-ul programarii pe care doriti sa o editati :");
        int id = scanner5.nextInt();
        System.out.println("Introduceti data programarii (YYYY-MM-DD) :");
        String data = scanner5.next();
        System.out.println("Introduceti ora programarii (HH-MM) : ");
        String ora  = scanner5.next();
        System.out.println("Introduceti id-ul clientului : ");
        int idClient = scanner5.nextInt();
        System.out.println("Introduceti id-ul medicului : ");
        int idMedic = scanner5.nextInt();
        System.out.println("Introduceti pretul : ");
        int pret = scanner5.nextInt();
        String sql = "UPDATE programare SET data=?, ora=?, idClient=?, idMedic=?, pret=? WHERE idProgram=" + id;
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, data);
        statement.setString(2, ora);
        statement.setInt(3, idClient);
        statement.setInt(4, idMedic);
        statement.setInt(5, pret);

        int rowsUpdated = statement.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("Programarea a fost modificată cu succes!");
        }
    }
    public static Programare obtineProgById(ArrayList<Programare> programs, int idProg)
    {
        for (Programare prog : programs)
        {
            if ( prog.getIdProgram() == idProg )
                return prog;
        }
        return null;
    }

}
