package com.proiect.services;

import com.proiect.domain.Angajat;
import com.proiect.persistence.AngajatRepository;

public class AngajatService {
    private AngajatRepository angajatRepository = new AngajatRepository();

    public String AngajatiCuSalariulMaxim(int salariu) {
        String string = "";
        for (Angajat angajat : angajatRepository.getAll()) {
            if (angajat.getSalariu() <= salariu) {
                string += angajat.toString() + '\n';
            }
        }
        return string;
    }
}
