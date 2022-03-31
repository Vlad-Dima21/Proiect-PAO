package com.proiect.services;

import com.proiect.domain.Ingredient;
import com.proiect.persistence.IngredientRepository;

import java.util.Vector;

public class IngredientService {
    private IngredientRepository ingredienteRepository = new IngredientRepository();

    public Vector getStocMic() {
        Vector numeIngrediente = new Vector();
        for (Ingredient ingredient : ingredienteRepository.getAll()) {
            if (ingredient.getRaportStoc() < 0.5) {
                numeIngrediente.add(ingredient.getNume());
            }
        }
        return numeIngrediente;
    }
    public void setStocReaprovizionare() {
        for (Ingredient ingredient : ingredienteRepository.getAll()) {
            ingredient.setStoc(ingredient.getStocLunar());
        }
    }

    public Vector<String> getNume() {
        Vector<String> nume = new Vector<>();
        for (Ingredient ingredient : ingredienteRepository.getAll()) {
            nume.add(ingredient.getNume());
        }
        return nume;
    }

    public int getNrIngredienteInStoc() {
        return ingredienteRepository.getSize();
    }

    public Ingredient getIngredient(int idx) {
        return ingredienteRepository.getAll().get(idx);
    }
}
