package com.proiect.services;

import com.proiect.domain.Angajat;
import com.proiect.domain.OperatorComenzi;
import com.proiect.domain.SoferLivrari;
import com.proiect.services.io.OperatorComenziIO;
import com.proiect.services.io.SoferLivrariIO;
import com.proiect.persistence.AngajatRepository;

import java.io.IOException;

public class AngajatService {
    private AngajatRepository angajatRepository = new AngajatRepository();
    private OperatorComenziIO operatoriComenziIO = OperatorComenziIO.getInstance();
    private SoferLivrariIO soferLivrariIO = SoferLivrariIO.getInstance();

        // Partea de CSV
//    {
//        try {
//            for (OperatorComenzi ang : operatoriComenziIO.getAllFromCSV()) {
//                angajatRepository.add(ang);
//            }
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            System.exit(-1);
//        }
//        try {
//            for (SoferLivrari ang : soferLivrariIO.getAllFromCSV()) {
//                angajatRepository.add(ang);
//            }
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            System.exit(-1);
//        }
//    }

    public String AngajatiCuSalariulMaxim(int salariu) {
        String string = "";
        for (Angajat angajat : angajatRepository.getAll()) {
            if (angajat.getSalariu() <= salariu) {
                string += angajat.toString() + '\n';
            }
        }
        return string;
    }

    public void writeDataToFiles() throws IOException {
        operatoriComenziIO.writeAllToCSV(angajatRepository.getAll());
        soferLivrariIO.writeAllToCSV(angajatRepository.getAll());
    }
}
