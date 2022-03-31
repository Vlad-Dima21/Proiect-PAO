package com.proiect.persistence;

import com.proiect.domain.Ingredient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class IngredientRepository implements GenericRepository<Ingredient>{
    private static Vector ingrediente = new Vector();

    static {
        ingrediente.addAll(Arrays.asList(
                new Ingredient("cacao", 100, 200, "EUROFOOD TRADING"),
                new Ingredient("lamaie", 45, 200, "EUROFOOD TRADING"),
                new Ingredient("vanilie", 100, 100, "ASIMENIA"),
                new Ingredient("lapte", 40, 100, "CARMO-LACT PROD"),
                new Ingredient("faina", 10, 200, "BCZL AGRICOLA")));
    }


    @Override
    public void add(Ingredient entity) {
        ingrediente.add(entity);
    }

    @Override
    public Ingredient get(int id) {
        for (Object ingredient : ingrediente) {
            if (((Ingredient)ingredient).getIdIngredient() == id) {
                return ((Ingredient) ingredient);
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
