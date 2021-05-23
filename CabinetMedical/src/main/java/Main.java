import cabinet.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class Main {

    public static void main (String[] args) throws IOException, MyException, SQLException {


        System.out.println("Bine ai venit! Alege o optiune :");
        System.out.println("1. Administreaza medici");
        System.out.println("2. Administreaza clienti");
        System.out.println("3. Administreaza bonuri fiscale");
        System.out.println("4. Administreaza programari");
        Scanner scanner = new Scanner(System.in);
        int opt = scanner.nextInt();
        if ( opt == 1 )
        {

            System.out.println("Alege optiune : ");
            System.out.println("1.Afisare medici");
            System.out.println("2.Elimina medic");
            System.out.println("3.Adauga medic");
            System.out.println("4.Editeaza vechime medic");
            System.out.println("5.Schimba specializare medic");
            System.out.println("6.Obtine informatii medic dupa id");
            Scanner scanner1 = new Scanner(System.in);
            int optMedic = scanner1.nextInt();
            if (optMedic == 1 )
            {

                MedicService.afisareMedici();
            }
            else if (optMedic == 2)
            {
                boolean ok = false;
                do {
                    try {
                        MedicService.stergeMedic();
                        ok = true;
                    } catch (MyException e) {
                        e.printStackTrace();
                    }
                }while(!ok);
            }
            else if (optMedic == 3)
            {
                MedicService.adaugaMedic();
            }
            else if ( optMedic == 4)
            {
                boolean ok = false;
                do {
                    try {
                        MedicService.editareVechime();
                        ok = true;
                    } catch (MyException e) {
                        e.printStackTrace();
                    }
                }while(!ok);

            }
            else if ( optMedic == 5)
            {

                MedicService.schimbaSpecializare();
            }
            else if (optMedic == 6)
            {
                System.out.println("Introduceti id-ul medicului pe care vreti sa il cautati : ");
                int id = scanner1.nextInt();
                Database database = new Database();
                Connection connection = database.Connection();
                ArrayList<Medic> medici = new ArrayList<>();
                medici = database.getAllMedici();
                Medic medic = MedicService.obtineMedicById(medici, id);
            }
        }
        else if (opt == 2)
        {
            System.out.println("Alege optiune : ");
            System.out.println("1.Afisare clienti");
            System.out.println("2.Elimina client");
            System.out.println("3.Adauga client");
            System.out.println("4.Obtine informatii client dupa id");
            Scanner scanner2 = new Scanner(System.in);
            int optClient = scanner2.nextInt();
            if ( optClient == 1)
            {
                ClientService.afisareClienti();
            }
            else if ( optClient == 2)
            {
                boolean ok = false;
                do {
                    try {
                        ClientService.eliminaPacient();
                        ok = true;
                    } catch (MyException e) {
                        e.printStackTrace();
                    }
                }while(!ok);
            }
            else if (optClient == 3)
            {
                ClientService.adaugaClient();
            }
            else if (optClient == 4)
            {
                System.out.println("Introduceti id-ul pacientului pe care vreti sa il cautati : ");
                int id = scanner2.nextInt();
                Database database = new Database();
                Connection connection = database.Connection();
                ArrayList<Client> clienti = new ArrayList<>();
                clienti = database.getAllClienti();
                Client client = ClientService.obtineClientById(clienti, id);
                if (client != null) {
                    System.out.println(client.toString());
                }
            }
        }
        else if (opt==3)
        {
            System.out.println("Alege optiune : ");
            System.out.println("1.Afisare bonuri");
            System.out.println("2.Sterge bon");
            System.out.println("3.Adauga bon");
            System.out.println("4.Intoarce bonurile dintr-o anume data");
            Scanner scanner3 = new Scanner(System.in);
            int optBon = scanner3.nextInt();
            if(optBon == 1)
            {
                BonFiscalService.afisareBon();
            }
            else if (optBon == 2)
            {
                boolean ok = false;
                do {
                    try {
                        BonFiscalService.stergeBon();
                        ok = true;
                    } catch (MyException e) {
                        e.printStackTrace();
                    }
                }while(!ok);
            }
            else if (optBon == 3)
            {
                BonFiscalService.adaugareBon();
            }
            else if(optBon == 4)
            {
                BonFiscalService.afisareBonData();
            }
        }
        else if (opt ==4 )
        {
            System.out.println("Alege optiune : ");
            System.out.println("1.Afisare programari");
            System.out.println("2.Sterge programare");
            System.out.println("3.Adauga programare");
            System.out.println("4.Editare programare");
            Scanner scanner4 = new Scanner(System.in);
            int optProg = scanner4.nextInt();
            if ( optProg == 1 )
            {
                ProgramareService.afisareProgramari();
            }
            else if ( optProg == 2 )
            {
                boolean ok = false;
                do {
                    try {
                        ProgramareService.stergeProgramare();
                        ok = true;
                    } catch (MyException e) {
                        e.printStackTrace();
                    }
                }while(!ok);
            }
            else if ( optProg == 3 )
            {
                ProgramareService.adaugaProgramare();
            }
            else if (optProg == 4)
            {
                ProgramareService.editareProgramare();
            }
        }


    }
}
