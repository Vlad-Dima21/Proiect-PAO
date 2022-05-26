package com.proiect.services;

import com.proiect.domain.Ingredient;
import com.proiect.domain.Prajitura;
import com.proiect.persistence.ProdusRepository;

public class PrajituraService {
    private ProdusRepository produsRepository = new ProdusRepository();

    public void crearePrajitura(String numeProdus, double pretProdus, Ingredient[] ingredienteProdus, double gramajPrajitura) {
        numeProdus = numeProdus.trim().toLowerCase();
        produsRepository.add(new Prajitura(numeProdus, pretProdus, ingredienteProdus, 0, 0, gramajPrajitura));
    }
}
