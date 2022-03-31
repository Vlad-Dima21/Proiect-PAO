package com.proiect.services;

import com.proiect.domain.Produs;
import com.proiect.persistence.ProdusRepository;

import java.util.List;
import java.util.Vector;

public class ProdusService {
    private ProdusRepository produsRepository = new ProdusRepository();

    public int stergereProdus(int idProdus) {
        Produs deSters = produsRepository.get(idProdus);
        if (deSters == null) {
            return -1;
        }
        produsRepository.delete(deSters);
        return 0;
    }

    public List<Produs> getProduse() {
        return produsRepository.getAll();
    }
}
