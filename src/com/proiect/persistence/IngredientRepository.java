package com.proiect.persistence;

import com.proiect.domain.Ingredient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class IngredientRepository implements GenericRepository<Ingredient>{
    private static Vector<Ingredient> ingrediente = new Vector<>();

    @Override
    public void add(Ingredient entity) {
        ingrediente.add(entity);
    }

    @Override
    public Ingredient get(int id) {
        for (Ingredient ingredient : ingrediente) {
            if (ingredient.getIdIngredient() == id) {
                return ingredient;
            }
        }
        return null;
    }

    @Override
    public void update(Ingredient entity) {
//        nu am nevoie inca
    }

    @Override
    public void delete(Ingredient entity) {
//      nu am nevoie inca
    }

    @Override
    public int getSize() {
        return ingrediente.size();
    }

    @Override
    public List<Ingredient> getAll() {
//        List<Ingredient> listaIngrediente = new ArrayList<>();
//        for (Object ingredient : ingrediente) {
//            listaIngrediente.add(((Ingredient) ingredient));
//        }
//        return listaIngrediente;
        return new ArrayList<>(ingrediente);
    }
}
