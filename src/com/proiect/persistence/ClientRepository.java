package com.proiect.persistence;

import com.proiect.domain.Client;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ClientRepository implements GenericRepository<Client>{

    private static Set clienti = new HashSet();

    static {
        clienti.add(new Client("Dima", "Vlad", "vlad@email.ro", "072xx"));
        clienti.add(new Client("Oana", "Popescu", "oana@email.ro", "073xx"));
    }

    @Override
    public void add(Client entity) {
        clienti.add(entity);
    }

    @Override
    public Client get(int id) {
        for (Object client : clienti) {
            if (((Client)client).getIdClient() == id) {
                return ((Client)client);
            }
        }
        return null;
    }

    @Override
    public void update(Client entity) {
        //nu am nevoie momentan
    }

    @Override
    public void delete(Client entity) {
        //nu am nevoie momentan
    }

    @Override
    public int getSize() {
        return clienti.size();
    }

    @Override
    public List<Client> getAll() {
        List<Client> listaClienti = new ArrayList<>();
        listaClienti.addAll(clienti);
        return listaClienti;
    }
}
