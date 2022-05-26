package com.proiect.services;

import com.proiect.domain.Client;
import com.proiect.services.io.ClientIO;
import com.proiect.persistence.ClientRepository;

import java.io.IOException;

public class ClientService {
    private ClientRepository clientRepository = new ClientRepository();
    private ClientIO clientIO = new ClientIO();

//    {
//        try {
//            for (Client client : clientIO.getAllFromCSV()) {
//                clientRepository.add(client);
//            }
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            System.exit(-1);
//        }
//    }

    public void AdaugareClient(String nume, String prenume, String email, String telefon) {
        nume = nume.trim();
        nume = nume.substring(0, 1).toUpperCase() + nume.substring(1).toLowerCase();
        prenume = prenume.trim();
        prenume = prenume.substring(0, 1).toUpperCase() + prenume.substring(1).toLowerCase();
        email = email.trim().toLowerCase();
        telefon = telefon.trim();
        clientRepository.add(new Client(nume, prenume, email, telefon));
    }

    public String GasireTelefonDupaNume(String nume) {
        nume = nume.substring(0,1).toUpperCase() + nume.substring(1).toLowerCase();
        for ( Client client : clientRepository.getAll()) {
            if (client.getNume().equals(nume)) {
                return client.getTelefon();
            }
        }
        return String.format("Nu a fost găsit clientul cu numele %s", nume);
    }

    public void stergereClient(int id) {
        clientRepository.delete(getClientById(id));
    }

    public String getClientiString() {
        String string = "";
        for (Client client : clientRepository.getAll()) {
            string += client.toString() + '\n';
        }
        return string;
    }

    public Client getClientById(int id) {
        return clientRepository.get(id);
    }

    public void writeDataToFiles() throws IOException {
        clientIO.writeAllToCSV(clientRepository.getAll());
    }
}
