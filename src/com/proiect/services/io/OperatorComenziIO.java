package com.proiect.services.io;

import com.proiect.domain.Angajat;
import com.proiect.domain.OperatorComenzi;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


public class OperatorComenziIO implements GenericIO<OperatorComenzi> {
    private static final OperatorComenziIO INSTANCE = new OperatorComenziIO();
    private static final String pathToCSVfile = "D:/Facultate/An_2_Sem_2/PAO/Proiect/src/com/proiect/resources/operatoriComenzi.csv";

    public static OperatorComenziIO getInstance() {
        return INSTANCE;
    }

    @Override
    public List<OperatorComenzi> getAllFromCSV() throws CustomException {
        try (BufferedReader AngajatReader = new BufferedReader(new FileReader(pathToCSVfile))) {
            int cnt = 0;    // used to ignore the header of the csv file
            String line;
            List<OperatorComenzi> angajati = new ArrayList<>();
            while ((line = AngajatReader.readLine()) != null) {
                cnt++;
                if (cnt == 1) {
                    continue;
                }
                String[] values = line.split(",");
                try {
                    String[] programString = values[6].substring(1, values[6].length() - 1).split(" ");
                    int[] program = new int[]{Integer.parseInt(programString[0]), Integer.parseInt(programString[1])};

                    String[] zileLucratoareString = values[7].substring(1, values[7].length() - 1).split(" ");
                    int[] zileLucratoare = new int[Array.getLength(zileLucratoareString)];
                    for (int i = 0; i < Array.getLength(zileLucratoareString); i++) {
                        zileLucratoare[i] = Integer.parseInt(zileLucratoareString[i]);
                    }
                    angajati.add(new OperatorComenzi(values[0], values[1], Integer.parseInt(values[2]),
                            values[3].charAt(0), values[4], values[5], program, zileLucratoare,
                            Double.parseDouble(values[8]), values[9]));

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
        AngajatiWriter.write("nume,prenume,salariu,sex,cnp,telefon,program,zileLucratoare,coefiecientBonus,parolaAngajat\n");
        StringBuilder str = new StringBuilder();

        for (Angajat angajat : listOfEntities) {
            if (angajat instanceof OperatorComenzi angajatAux) {
                str.append(angajatAux.toCSVFormat()).append('\n');
            }
        }
        AngajatiWriter.write(str.toString().trim());
        AngajatiWriter.close();
    }
}
