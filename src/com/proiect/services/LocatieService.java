package com.proiect.services;

import com.proiect.domain.Locatie;
import com.proiect.persistence.LocatieRepository;

public class LocatieService {
    private LocatieRepository locatieRepository = new LocatieRepository();

    public String getLocatiiString() {
        String string = "";
        for (Locatie locatie : locatieRepository.getAll()) {
            string += locatie.toString() + '\n';
        }
        return string;
    }

    public Locatie getLocatieById(int id) {
        return locatieRepository.get(id);
    }
}
