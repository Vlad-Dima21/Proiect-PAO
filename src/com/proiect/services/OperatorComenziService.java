package com.proiect.services;

import com.proiect.domain.Angajat;
import com.proiect.domain.OperatorComenzi;
import com.proiect.persistence.AngajatRepository;

public class OperatorComenziService {

    private AngajatRepository angajatRepository = new AngajatRepository();

    public String getAllOperatori() {
        String string = "";
        for (Angajat angajat : angajatRepository.getAll()) {
            if (angajat instanceof OperatorComenzi) {
                string += angajat.toString() + '\n';
            }
        }
        return string;
    }

    public String SchimbareParola(int idOperator, String parolaVeche, String parolaNoua) {
        OperatorComenzi op = (OperatorComenzi) angajatRepository.get(idOperator);
        if (op.parolaCorecta(parolaVeche.trim())) {
            op.setParolaAngajat(parolaNoua);
            return "Parola schimbata!";
        }
        return "Parola gresita!";
    }
}
