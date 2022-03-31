package com.proiect.persistence;

import com.proiect.domain.Angajat;
import com.proiect.domain.OperatorComenzi;
import com.proiect.domain.SoferLivrari;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AngajatRepository implements GenericRepository<Angajat>{

    private static List<Angajat> angajati = new ArrayList<>(Arrays.asList(
            new OperatorComenzi("Costica", "Ionel", 2000, 'm', "5011215341907", "072xx", new int[]{10, 18}, new int[]{1,2}, 0, "parola"),
            new SoferLivrari("Atanase", "Claudiu", 2100, 'm', "2921229127839", "073xx", 4, null, 5),
            new OperatorComenzi("Ionel", "Petronela", 2500, 'f', "1870412410853", "072xx", new int[]{10, 18}, new int[]{3,4}, 0, "petronela123")
            ));

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
