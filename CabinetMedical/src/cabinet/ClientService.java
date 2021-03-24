package cabinet;

public class ClientService {

    public static void afisareClienti (Client[] clienti)
    {
        for ( Client client : clienti)
        {
            System.out.println(client.toString());
        }
    }

    public static void intoarcePacient (Client[] clienti, String nume, String prenume)
    {
        for ( Client client : clienti)
        {
            if ( client.nume == nume && client.prenume == prenume )
                System.out.println(client.toString());
                break;
        }

    }
}