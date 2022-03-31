package com.proiect.persistence;

import com.proiect.domain.Ingredient;
import com.proiect.domain.Prajitura;
import com.proiect.domain.Produs;
import com.proiect.domain.Tort;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class ProdusRepository implements GenericRepository<Produs> {
    private IngredientRepository ingredientRepository = new IngredientRepository();
    private static Vector<Produs> produse;
    private static Vector ingrediente = new Vector();

    {
        ingrediente.addAll(ingredientRepository.getAll());
        produse = new Vector<>(Arrays.asList(
                new Tort("Tort cu lamaie", 60, new Ingredient[]{
                        (Ingredient) ingrediente.get(1),
                        (Ingredient) ingrediente.get(2),
                        (Ingredient) ingrediente.get(3)},
                        null, null, null),
                new Prajitura("Briosa cu ciocolata", 5,
                        new Ingredient[]{
                                (Ingredient) ingrediente.get(1),
                                (Ingredient) ingrediente.get(3),
                                (Ingredient) ingrediente.get(4)
                        }, 10, 0.3, 80)));
    }


    @Override
    public void add(Produs entity) {
        produse.add(entity);
    }

    @Override
    public Produs get(int id) {
        for (Produs produs : produse) {
            if (produs.getIdProdus() == id) {
                return produs;
            }
        }
        return null;
    }

    @Override
    public void update(Produs entity) {
//      nu imi trebuie inca
    }

    @Override
    public void delete(Produs entity) {
        produse.remove(entity);
    }

    @Override
    public int getSize() {
        return produse.size();
    }

    @Override
    public List<Produs> getAll() {
        return produse;
    }
}
