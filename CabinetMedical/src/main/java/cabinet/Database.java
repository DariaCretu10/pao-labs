package cabinet;
import cabinet.*;
import java.sql.*;
import java.util.ArrayList;
public class Database {



    private static Connection connection = null;

    public Connection Connection() {
        if (connection != null) {
            return connection;
        } else {
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/MedicalOfficeApp", "root", "password");
                return connection;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }


            return null;
        }
    }

    public ArrayList<Programare> getAllProgramari() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from programare");
        ArrayList<Programare> progs = new ArrayList<>();
        while (resultSet.next()){
            Programare prog = new Programare(resultSet.getInt("idProgram"),resultSet.getString("data"), resultSet.getString("ora"), resultSet.getInt("idClient"),
                     resultSet.getInt("idMedic"), resultSet.getInt("pret") );
            progs.add(prog);
        }
        return progs;
    }

    public ArrayList<Medic> getAllMedici() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from medic");
        ArrayList<Medic> medici = new ArrayList<>();
        while (resultSet.next()){
            Medic medic = new Medic(resultSet.getInt("idMedic"),resultSet.getString("specialitate"), resultSet.getString("nume"), resultSet.getString("prenume"),
                    resultSet.getInt("varsta"), resultSet.getInt("vechime") );
            medici.add(medic);
        }
        return medici;
    }

    public ArrayList<Client> getAllClienti() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from client");
        ArrayList<Client> clienti = new ArrayList<>();
        while (resultSet.next()){
            Client client = new Client(resultSet.getInt("idClient"), resultSet.getString("nume"), resultSet.getString("prenume"),
                    resultSet.getInt("varsta"), resultSet.getString("interventie") );
            clienti.add(client);
        }
        return clienti;
    }

    public ArrayList<BonFiscal> getAllBonuri() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from bonfiscal");
        ArrayList<BonFiscal> bonuri = new ArrayList<>();
        while (resultSet.next()){
            BonFiscal bon = new BonFiscal(resultSet.getInt("idClient"),resultSet.getInt("idMedic"), resultSet.getString("serviciu"), resultSet.getInt("idBon"),
                    resultSet.getInt("pret"), resultSet.getDate("data").toLocalDate() );
            bonuri.add(bon);
        }
        return bonuri;
    }


}
