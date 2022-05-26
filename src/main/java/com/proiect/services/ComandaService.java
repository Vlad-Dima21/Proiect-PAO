package com.proiect.services;

import com.proiect.domain.*;
import com.proiect.persistence.ComandaRepository;

public class ComandaService {
    private ComandaRepository comandaRepository = new ComandaRepository();

//  pe viitor de adaugat si sofer si operator comanda
    public void CreareComanda(Client client, Locatie locatie, Produs[] produse) {
        double pretTotal = 0;
        for (Produs produs : produse) {
            pretTotal += produs.getPretProdus();
        }
        Comanda comandaNoua = new Comanda(client,locatie,null,null,produse);
        comandaNoua.setPretTotal(pretTotal);
        comandaRepository.add(comandaNoua);
    }
}
