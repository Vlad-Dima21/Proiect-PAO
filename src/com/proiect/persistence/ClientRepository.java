package com.proiect.persistence;

import com.proiect.domain.Client;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ClientRepository implements GenericRepository<Client>{

    private static Set<Client> clienti = new HashSet<>();

    @Override
    public void add(Client entity) {
        clienti.add(entity);
    }

    @Override
    public Client get(int id) {
        for (Client client : clienti) {
            if (client.getIdClient() == id) {
                return client;
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
        List<Client> listaClienti = new ArrayList<>(clienti);
        return listaClienti;
    }
}
