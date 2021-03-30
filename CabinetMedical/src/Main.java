import cabinet.*;
import java.util.Arrays;
public class Main {

    public static void main (String[] args)
    {
        Stomatolog stomatolog1 = new Stomatolog("stomatologie", "Popescu", "Andreea",
                45,18, Program.DIMINEATA, Boolean.FALSE);
        Dermatolog dermatolog1 = new Dermatolog("dermatologie", "Andrei", "Mihai", 32, 2, Boolean.FALSE);

        Dermatolog dermatolog2 = new Dermatolog("dermatologie", "Bontea", "Ioana", 27, 2, Boolean.TRUE);

        BonFiscal bon1 = new BonFiscal("Ramascanu Ana", "Bontea Ioana", "consultatie", 1, 100, "12-02-2020");

        BonFiscal bon2 = new BonFiscal("Petru Alin", "Bontea Ioana", "consultatie", 2, 100, "12-03-2020");

        BonFiscal bon3 = new BonFiscal("Crangu Mihai", "Popescu Andreea", "plomba", 3, 200, "12-02-2020");

        BonFiscal bon4 = new BonFiscal("Popa Denis", "Andrei Mihai", "consultatie", 4, 110, "3-04-2020");

        Client client1 = new Client("Cretu", "Daria", 20, "consultatie");

        Client client2 = new Client("Doroftei", "Tudor", 25, "scoatere masea");

        Client client3 = new Client("Simion", "Cezar", 15, "consultatie");
        Client client4 = new Client("Simion", "Cezar", 15, "consultatie");

        //Sortam medicii dupa nume folosind comparator
        Medic[] medici = new Medic[]{stomatolog1, dermatolog1, dermatolog2};
        NameComparator nameCompare = new NameComparator();
        Arrays.sort(medici, nameCompare);
        MedicService.afisareMedici(medici);
        System.out.println("-------------------");
        /*Medic[] listaMedici = MedicService.stergeMedic(medici, dermatolog1);
        for (Medic medic : listaMedici )
        {
            System.out.println(medic.toString());
        }

        System.out.println("-------------------");
        BonFiscal[] bonuri = new BonFiscal[]{bon1, bon2, bon3};
        BonFiscalService.afisareBonData(bonuri,"12-02-2020");
        System.out.println("-------------------");
        BonFiscal[] bonuriNoi = BonFiscalService.adaugareBon(bonuri, bon4);
        for ( BonFiscal bon : bonuriNoi )
        {
            System.out.println(bon.toString());
        }


        System.out.println("-------------------");
        Client[] clienti = new Client[]{client1, client2, client3};
        ClientService.afisareClienti(clienti);
        System.out.println("-------------------");
        ClientService.intoarcePacient(clienti, "Cretu", "Daria");
        System.out.println("-------------------");
        System.out.println(client3.equals(client4));*/
        System.out.println(MedicService.editareVechime(stomatolog1, 17));
    }
}
