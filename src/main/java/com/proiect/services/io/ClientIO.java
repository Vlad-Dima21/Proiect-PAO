package com.proiect.services.io;

import com.proiect.domain.Client;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ClientIO implements GenericIO<Client>{
    private static final ClientIO INSTANCE = new ClientIO();
    private static final String pathToCSVfile = "D:\\Facultate\\An_2_Sem_2\\PAO\\Proiect\\src\\main\\java\\com\\proiect\\resources\\clienti.csv";

    public static ClientIO getInstance() {
        return INSTANCE;
    }

    @Override
    public List<Client> getAllFromCSV() throws CustomException {
        try (BufferedReader ClientReader = new BufferedReader(new FileReader(pathToCSVfile))) {
            int cnt = 0;    // used to ignore the header of the csv file
            String line;
            List<Client> clienti = new ArrayList<>();
            while ((line = ClientReader.readLine()) != null) {
                cnt++;
                if (cnt == 1) {
                    continue;
                }
                String[] values = line.split(",");
                try {
                    clienti.add(new Client(values[0], values[1], values[2], values[3]));

                } catch (Exception e) {
                    throw new CustomException(String.format("In fisierul de la %s linia %d este gresita!", pathToCSVfile, cnt));
                }
            }
            return clienti;
        }catch (IOException e){
            return new ArrayList<>();
        }
    }

    public void writeAllToCSV(List<Client> listOfEntities) throws IOException {
        BufferedWriter ClientWriter = new BufferedWriter(new FileWriter(pathToCSVfile));
        ClientWriter.write("nume,prenume,email,telefon\n");
        StringBuilder str = new StringBuilder();

        for (Client client : listOfEntities) {
                str.append(client.toCSVformat()).append('\n');
        }

        ClientWriter.write(str.toString().trim());
        ClientWriter.close();
    }
}
