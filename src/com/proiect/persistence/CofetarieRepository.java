package com.proiect.persistence;

import com.proiect.domain.Cofetarie;
import com.proiect.domain.Locatie;

import java.util.Arrays;
import java.util.List;

public class CofetarieRepository implements GenericRepository<Cofetarie> {

    private static List listaCofetarii = Arrays.asList(new Cofetarie(new Locatie("Bacău", "Onesti", null, "Emil Rebreanu", "7", false), 7, 16, 20),
            new Cofetarie(new Locatie("Bacău", "Moinesti", null, "Emil Rebreanu", "7", false), 7, 16, 20),
            new Cofetarie(new Locatie(null, "București", 2, "Intrarea Domnita Florica", "15", true), 9, 18, 15));

    @Override
    public void add(Cofetarie entity) {
        listaCofetarii.add(entity);
    }

    @Override
    public Cofetarie get(int id) {
        for (Object cofetarie : listaCofetarii) {
            if (((Cofetarie)cofetarie).getIdCofetarie() == id) {
                return (Cofetarie)cofetarie;
            }
        }
        return null;
    }

    @Override
    public void update(Cofetarie entity) {
        //nu am nevoie momentan
    }

    @Override
    public void delete(Cofetarie entity) {
        //nu am nevoie momentan
    }

    @Override
    public int getSize() {
        return listaCofetarii.size();
    }

    @Override
    public List<Cofetarie> getAll() {
        return listaCofetarii;
    }
}
