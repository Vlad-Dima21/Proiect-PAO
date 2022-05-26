package com.proiect.services;

import com.proiect.domain.Cofetarie;
import com.proiect.persistence.CofetarieRepository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CofetarieService {
    private CofetarieRepository cofetarieRepository = new CofetarieRepository();


    public String formatAfisareCofetarii() {
        StringBuilder stringCofetarii = new StringBuilder(String.format("Avem %d cofetării în toată țara:\n\n",cofetarieRepository.getSize()));
        for (Cofetarie cofetarie : cofetarieRepository.getAll()) {
            stringCofetarii.append(cofetarie.toString()).append("\n\n");
        }
        return stringCofetarii.toString();
    }

    public List getCofetariiDeschise() {
        int oraCurenta = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        List cofetariiDeschise = new ArrayList();
        for (Cofetarie cofetarie : cofetarieRepository.getAll())
            if (cofetarie.getOraDeschidere() <= oraCurenta && oraCurenta < cofetarie.getOraInchidere())
                cofetariiDeschise.add(cofetarie);
        return cofetariiDeschise;
    }
}
