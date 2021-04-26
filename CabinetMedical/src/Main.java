import cabinet.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.io.FileWriter;
import java.io.IOException;
public class Main {

    public static void main (String[] args) throws IOException {

        ArrayList<Medic> medici = new ArrayList<>();
        ArrayList<Client> clienti = new ArrayList<>();


        MedicService medicService = new MedicService();
        medicService.readMedici(medici);
        MedicService medicService1 = new MedicService();
        medicService1.writeMedici(medici);
        //MedicService.stergeMedic(medici);
        //MedicService.adaugaMedic(medici);
        System.out.println(medici);

        /*ClientService clientService = new ClientService();
        clientService.readClienti(clienti);
        System.out.println(clienti);
        ClientService clientService1 = new ClientService();
        clientService1.writeClienti(clienti);*/


    }
}
