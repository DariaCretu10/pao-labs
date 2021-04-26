package cabinet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import static cabinet.BonFiscalService.scrieInAudit;

public class ProgramareService {



    public void readProgramari (ArrayList<Programare> programs) throws IOException {
        BufferedReader csvReader = new BufferedReader(new FileReader("src/cabinet/Programare.csv"));
        String row;
        while ((row = csvReader.readLine()) != null) {
            String[] data = row.split(",");
            if ( data.length == 6 )
            {
                Programare programare = new Programare(Integer.valueOf(data[0]), data[1], data[2], data[3], data[4], Integer.valueOf(data[5]));
                programs.add(programare);
            }
            else
            {
                Programare programare = new Programare(data[0], data[1], data[2], data[3], Integer.valueOf(data[4]));
                programs.add(programare);
            }
        }
        scrieInAudit("CitesteDinFisierProgramari");
        csvReader.close();
    }

    public static void writeProgramari(ArrayList<Programare>programs)  {
        try {
            FileWriter csvWriter = new FileWriter("src/cabinet/Medic.csv");
            for (Programare programare : programs) {
                String elem = programare.getIdProgram() + "," + programare.getData() + "," + programare.getOra() + "," +
                              programare.getClient() + "," + programare.getMedic() + "," + programare.getPret();
                csvWriter.write(elem);
                csvWriter.write('\n');

            }
            csvWriter.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        scrieInAudit("ScrieInFisierProgramari");

    }

    public static void afisareProgramari(ArrayList<Programare> programs)
    {
        System.out.println("Lista programarilor : ");
        for (Programare programare : programs)
        {
            System.out.println(programare.toString());
        }
        scrieInAudit("AfisareProgramari");
    }

    public static ArrayList<Programare> stergeProgramare(ArrayList<Programare> programs)
    {
        Scanner scanner1 = new Scanner(System.in);
        Programare progSters = new Programare();
        progSters = null;
        while ( progSters == null)
        {
            System.out.println("Introduceti id-ul programarii de sters : ");
            int id = scanner1.nextInt();
            progSters = obtineProgById(programs, id);
            if (progSters == null)
                System.out.println("Introduceti un id valid!");
        }
        programs.remove(progSters);
        writeProgramari(programs);
        scrieInAudit("StergereProgramare");
        return programs;

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
