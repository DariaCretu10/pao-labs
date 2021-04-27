import cabinet.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class Main {

    public static void main (String[] args) throws IOException, MyException {

        ArrayList<Medic> medici = new ArrayList<>();
        ArrayList<Client> clienti = new ArrayList<>();
        ArrayList<BonFiscal> bonuri = new ArrayList<>();
        ArrayList<Programare> programs = new ArrayList<>();
        MedicService medicService = new MedicService();
        medicService.readMedici(medici);
        MedicService medicService1 = new MedicService();
        medicService1.writeMedici(medici);
        ClientService clientService = new ClientService();
        clientService.readClienti(clienti);
        ClientService clientService1 = new ClientService();
        clientService1.writeClienti(clienti);
        BonFiscalService bonService = new BonFiscalService();
        bonService.readBonuri(bonuri);
        BonFiscalService bonService1 = new BonFiscalService();
        bonService1.writeBonuri(bonuri);
        ProgramareService programareService = new ProgramareService();
        programareService.readProgramari(programs);
        ProgramareService programareService1 = new ProgramareService();
        programareService1.writeProgramari(programs);
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

                MedicService.afisareMedici(medici);
            }
            else if (optMedic == 2)
            {
                boolean ok = false;
                do {
                    try {
                        MedicService.stergeMedic(medici);
                        ok = true;
                    } catch (MyException e) {
                        e.printStackTrace();
                    }
                }while(ok == false);
            }
            else if (optMedic == 3)
            {
                MedicService.adaugaMedic(medici);
            }
            else if ( optMedic == 4)
            {
                System.out.println("Introduceti id-ul medicului pe care vreti sa il editati : ");
                int id = scanner1.nextInt();
                Medic medic = MedicService.obtineMedicById(medici, id);
                boolean ok = false;
                do {
                    try {
                        MedicService.editareVechime(medic);
                        ok = true;
                    } catch (MyException e) {
                        e.printStackTrace();
                    }
                }while(ok == false);
                medicService1.writeMedici(medici);

            }
            else if ( optMedic == 5)
            {
                System.out.println("Introduceti id-ul medicului pe care vreti sa il editati : ");
                int id = scanner1.nextInt();
                Medic medic = MedicService.obtineMedicById(medici, id);
                MedicService.schimbaSpecializare(medic);
                medicService1.writeMedici(medici);
            }
            else if (optMedic == 6)
            {
                System.out.println("Introduceti id-ul medicului pe care vreti sa il cautati : ");
                int id = scanner1.nextInt();
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
                ClientService.afisareClienti(clienti);
            }
            else if ( optClient == 2)
            {
                boolean ok = false;
                do {
                    try {
                        ClientService.eliminaPacient(clienti);
                        ok = true;
                    } catch (MyException e) {
                        e.printStackTrace();
                    }
                }while(ok == false);
            }
            else if (optClient == 3)
            {
                ClientService.adaugaClient(clienti);
            }
            else if (optClient == 4)
            {
                System.out.println("Introduceti id-ul pacientului pe care vreti sa il cautati : ");
                int id = scanner2.nextInt();
                Client client = ClientService.obtineClientById(clienti, id);
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
                BonFiscalService.afisareBon(bonuri);
            }
            else if (optBon == 2)
            {
                boolean ok = false;
                do {
                    try {
                        BonFiscalService.stergeBon(bonuri);
                        ok = true;
                    } catch (MyException e) {
                        e.printStackTrace();
                    }
                }while(ok == false);
            }
            else if (optBon == 3)
            {
                BonFiscalService.adaugareBon(bonuri);
            }
            else if(optBon == 4)
            {
                BonFiscalService.afisareBonData(bonuri);
            }
        }
        else if (opt ==4 )
        {
            System.out.println("Alege optiune : ");
            System.out.println("1.Afisare programari");
            System.out.println("2.Sterge programare");
            System.out.println("3.Adauga programare");
            Scanner scanner4 = new Scanner(System.in);
            int optProg = scanner4.nextInt();
            if ( optProg == 1 )
            {
                ProgramareService.afisareProgramari(programs);
            }
            else if ( optProg == 2 )
            {
                boolean ok = false;
                do {
                    try {
                        ProgramareService.stergeProgramare(programs);
                        ok = true;
                    } catch (MyException e) {
                        e.printStackTrace();
                    }
                }while(ok == false);
            }
            else if ( optProg == 3 )
            {
                ProgramareService.adaugaProgramare(programs);
            }
        }


    }
}
