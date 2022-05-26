package com.proiect.persistence;

import com.proiect.domain.Locatie;

import java.util.ArrayList;
import java.util.List;

public class LocatieRepository implements GenericRepository<Locatie> {

    private static List<Locatie> locatii = new ArrayList<>();

    static {
        locatii.add(new Locatie(null, "Bucuresti", 5, "Sergent Major Cara Anghel", "19", true));
        locatii.add(new Locatie(null, "Bucuresti", 5, "Rezervelor", "190", true));
        locatii.add(new Locatie(null, "Bucuresti", 6, "Fibrei", "27", true));
    }

    @Override
    public void add(Locatie entity) {
        locatii.add(entity);
    }

    @Override
    public Locatie get(int id) {
        for (Locatie locatie : locatii) {
            if (locatie.getIdLocatie() == id) {
                return locatie;
            }
        }
        return null;
    }

    @Override
    public void update(Locatie entity) {
//      nu imi trebuie
    }

    @Override
    public void delete(Locatie entity) {
//      nu imi trebuie
    }

    @Override
    public int getSize() {
        return locatii.size();
    }

    @Override
    public List<Locatie> getAll() {
        return locatii;
    }
}
