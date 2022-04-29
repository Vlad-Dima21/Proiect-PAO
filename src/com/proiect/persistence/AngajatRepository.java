package com.proiect.persistence;

import com.proiect.domain.Angajat;
import com.proiect.domain.OperatorComenzi;
import com.proiect.domain.SoferLivrari;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AngajatRepository implements GenericRepository<Angajat>{

    private static List<Angajat> angajati = new ArrayList<>();

    @Override
    public void add(Angajat entity) {
        angajati.add(entity);
    }

    @Override
    public Angajat get(int id) {
        for (Angajat angajat : angajati) {
            if (angajat.getIdAngajat() == id) {
                return  angajat;
            }
        }
        return null;
    }

    @Override
    public void update(Angajat entity) {
        for (Angajat angajat : angajati) {
            if (angajat.equals(entity)) {
                delete(angajat);
                add(entity);
                return;
            }
        }
    }

    @Override
    public void delete(Angajat entity) {
        angajati.remove(entity);
    }

    @Override
    public int getSize() {
        return angajati.size();
    }

    @Override
    public List<Angajat> getAll() {
        return angajati;
    }
}
