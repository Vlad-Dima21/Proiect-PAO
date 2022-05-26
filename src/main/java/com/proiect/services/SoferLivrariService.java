package com.proiect.services;

import com.proiect.domain.Angajat;
import com.proiect.domain.SoferLivrari;
import com.proiect.persistence.AngajatRepository;

import java.lang.ref.SoftReference;

public class SoferLivrariService {
    private AngajatRepository angajatRepository = new AngajatRepository();

    public String getAllSoferiString() {
        String string = "";
        for (Angajat angajat : angajatRepository.getAll()) {
            if (angajat instanceof SoferLivrari) {
                string += angajat.toString() + '\n';
            }
        }
        return string;
    }

    public void ActualizareTelefon(int idSofer, String numarNou) {
        SoferLivrari sofer = new SoferLivrari((SoferLivrari) angajatRepository.get(idSofer));
        sofer.setTelefon(numarNou.trim());
        angajatRepository.update(sofer);
    }
}
