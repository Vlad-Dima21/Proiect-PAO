package com.proiect.persistence;

import com.proiect.domain.Comanda;

import java.util.List;
import java.util.Vector;

public class ComandaRepository implements GenericRepository<Comanda>{
    private static Vector<Comanda> comenzi;

    static {
        comenzi = new Vector<>();
    }

    @Override
    public void add(Comanda entity) {
        comenzi.add(entity);
    }

    @Override
    public Comanda get(int id) {
        for (Comanda comanda : comenzi) {
            if (comanda.getIdComanda() == id) {
                return comanda;
            }
        }
        return null;
    }

    @Override
    public void update(Comanda entity) {
//        nu folosesc inca
    }

    @Override
    public void delete(Comanda entity) {
//        nu folosesc inca
    }

    @Override
    public int getSize() {
        return comenzi.size();
    }

    @Override
    public List<Comanda> getAll() {
        return comenzi;
    }
}
