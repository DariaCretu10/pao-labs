package cabinet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import static cabinet.BonFiscalService.scrieInAudit;

public class ClientService {



    public void readClienti (ArrayList<Client> clienti) throws IOException {
        BufferedReader csvReader = new BufferedReader(new FileReader("src/cabinet/Client.csv"));
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
            FileWriter csvWriter = new FileWriter("src/cabinet/Client.csv");
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

    }

    public static void afisareClienti (ArrayList<Client> clienti)
    {
        System.out.println("Lista clientilor este :");
        for ( Client client : clienti)
        {
            System.out.println(client.toString());
        }
        scrieInAudit("AfisareClienti");
    }

    public static void intoarcePacient (ArrayList<Client> clienti)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti numele pacientului : ");
        String nume = scanner.nextLine();
        System.out.println("Introduceti prenumele pacientului : ");
        String prenume = scanner.nextLine();
        for ( Client client : clienti)
        {
            if ( client.getNume().equals(nume) && client.getPrenume().equals(prenume) )
                System.out.println(client.toString());
                break;
        }

    }


    public static void adaugaClient(ArrayList<Client> clienti)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti numele clientului : ");
        String nume  = scanner.nextLine();
        System.out.println("Introduceti prenumele clientului : ");
        String prenume = scanner.nextLine();
        System.out.println("Introduceti varsta clientului : ");
        int varsta = scanner.nextInt();
        System.out.println("Introduceti interventia clientului : ");
        String interventie = scanner.next();
        int maxi = 0;
        for (Client client : clienti )
        {
            if  ( client.getIdClient() > maxi )
            {
                maxi = client.getIdClient();
            }
        }
        Client clientNou = new Client(maxi+1, nume, prenume, varsta, interventie);
        clienti.add(clientNou);
        writeClienti(clienti);
        scrieInAudit("adaugareClient");
        System.out.println("Lista acutalizata a clientilor :");
        for ( Client client : clienti )
            System.out.println(client.toString());
    }

    public static void eliminaPacient(ArrayList<Client> clienti) throws MyException {
        Scanner scanner1 = new Scanner(System.in);
        Client clientSters = new Client();
        System.out.println("Introduceti id-ul clientului de sters : ");
        int id = scanner1.nextInt();
        clientSters = obtineClientById(clienti, id);
        if ( clientSters != null)
        {
            clienti.remove(clientSters);
            writeClienti(clienti);
            scrieInAudit("EliminaPacient");
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
