package com.proiect.services.io;

import com.proiect.domain.Angajat;
import com.proiect.domain.SoferLivrari;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SoferLivrariIO implements GenericIO<SoferLivrari> {
    private static final SoferLivrariIO INSTANCE = new SoferLivrariIO();
    private static final String pathToCSVfile = "D:\\Facultate\\An_2_Sem_2\\PAO\\Proiect\\src\\main\\java\\com\\proiect\\resources\\soferiLivrari.csv";

    public static SoferLivrariIO getInstance() {
        return INSTANCE;
    }


    @Override
    public List<SoferLivrari> getAllFromCSV() throws CustomException {
        try (BufferedReader AngajatReader = new BufferedReader(new FileReader(pathToCSVfile))) {
            int cnt = 0;    // used to ignore the header of the csv file
            String line;
            List<SoferLivrari> angajati = new ArrayList<>();
            while ((line = AngajatReader.readLine()) != null) {
                cnt++;
                if (cnt == 1) {
                    continue;
                }
                String[] values = line.split(",");
                try {
                    angajati.add(new SoferLivrari(values[0], values[1], Integer.parseInt(values[2]),
                            values[3].charAt(0), values[4], values[5], Integer.parseInt(values[6]) , values[7],
                            Integer.parseInt(values[8])));

                } catch (Exception e) {
                    throw new CustomException(String.format("In fisierul de la %s linia %d este gresita!", pathToCSVfile, cnt));
                }
            }
            return angajati;
        }catch (IOException e){
            return new ArrayList<>();
        }
    }
    public void writeAllToCSV(List<Angajat> listOfEntities) throws IOException {
        BufferedWriter AngajatiWriter = new BufferedWriter(new FileWriter(pathToCSVfile));
        AngajatiWriter.write("nume,prenume,salariu,sex,cnp,telefon,numarLivrariZi,nrInmatriculareMasina,capacitateMaximaPachete\n");
        StringBuilder str = new StringBuilder();

        for (Angajat angajat : listOfEntities) {
            if (angajat instanceof SoferLivrari angajatAux) {
                str.append(angajatAux.toCSVformat()).append("\n");
            }
        }
        AngajatiWriter.write(str.toString().trim());
        AngajatiWriter.close();
    }
}
