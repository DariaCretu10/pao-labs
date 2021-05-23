package cabinet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.sql.PreparedStatement;
import static cabinet.BonFiscalService.scrieInAudit;

public class ClientService {



    /*public void readClienti (ArrayList<Client> clienti) throws IOException {
        BufferedReader csvReader = new BufferedReader(new FileReader("src/main/java/cabinet/Client.csv"));
        String row;
        while ((row = csvReader.readLine()) != null) {
            String[] data = row.split(",");
            if ( data.length == 5 )
            {
                Client client = new Client(Integer.parseInt(data[0]), data[1], data[2], Integer.parseInt(data[3]), data[4]);
                clienti.add(client);
            }
            else if (data.length == 4)
            {
                Client client = new Client(data[0], data[1], Integer.parseInt(data[2]), data[3]);
                clienti.add(client);
            }

        }
        csvReader.close();
        scrieInAudit("citireDinFisierClienti");
    }

    public static void writeClienti(ArrayList<Client> clienti)  {
        try {
            FileWriter csvWriter = new FileWriter("src/main/java/cabinet/Client.csv");
            for (Client client : clienti) {
                String elem = client.getIdClient() + "," + client.getNume() + "," + client.getPrenume() + "," +
                        client.getVarsta() + "," + client.getInterventie();
                csvWriter.write(elem);
                scrieInAudit("scrieInFisierClienti");
                csvWriter.write('\n');

            }
            csvWriter.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        //scrieInAudit("scrieInFisierClienti");

    }*/

    public static void afisareClienti ()
    {
        System.out.println("Lista clientilor : ");
        ArrayList<Client> clienti = new ArrayList<>();
        Database database = new Database();
        Connection connection = database.Connection();
        try {
            clienti = database.getAllClienti();
            for (Client client : clienti) {
                System.out.println(client.toString());
            }
            scrieInAudit("AfisareClienti");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void editeazaPacient ()
    {
        Database database = new Database();
        Connection connection = database.Connection();
        ArrayList<Client> clienti = new ArrayList<>();
        Scanner scanner3 = new Scanner(System.in);

    }


    public static void adaugaClient() throws SQLException {
        Database database = new Database();
        Connection connection = database.Connection();
        ArrayList<Client> clienti = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti numele clientului : ");
        String nume  = scanner.nextLine();
        System.out.println("Introduceti prenumele clientului : ");
        String prenume = scanner.nextLine();
        System.out.println("Introduceti varsta clientului : ");
        int varsta = scanner.nextInt();
        System.out.println("Introduceti interventia clientului : ");
        String interventie = scanner.next();
        String sql = "INSERT INTO client (nume, prenume, varsta, interventie) VALUES (?, ?, ?, ?)";

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, nume);
        statement.setString(2, prenume);
        statement.setInt(3, varsta);
        statement.setString(4, interventie);

        int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("Un nou client a fost inserat cu succes!");
        }
        clienti = database.getAllClienti();
        scrieInAudit("adaugareClient");
        System.out.println("Lista acutalizata a clientilor :");
        for ( Client client : clienti )
            System.out.println(client.toString());
    }

    public static void eliminaPacient() throws MyException, SQLException {
        Database database = new Database();
        Connection connection = database.Connection();
        ArrayList<Client> clienti = new ArrayList<>();
        clienti = database.getAllClienti();
        Scanner scanner1 = new Scanner(System.in);
        Client clientSters = new Client();
        System.out.println("Introduceti id-ul clientului de sters : ");
        int id = scanner1.nextInt();
        clientSters = obtineClientById(clienti, id);
        if ( clientSters != null)
        {
            String sql = "DELETE FROM client WHERE idClient=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Clientul a fost sters cu succes!");
            }
            clienti = database.getAllClienti();
            System.out.println("Lista actualizata a clientilor :");
            for ( Client client : clienti )
                System.out.println(client.toString());
        }
        else
        {
            throw new MyException ("Introduceti id valid!");
        }

    }

    public static Client obtineClientById(ArrayList<Client> clienti, int idCl)
    {
        for (Client client : clienti)
        {
            if ( client.getIdClient() == idCl )
                return client;
        }
        return null;
    }


}
