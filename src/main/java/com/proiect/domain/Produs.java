package com.proiect.domain;

import java.lang.reflect.Array;
import java.util.Arrays;

public abstract class Produs {

    private static int contorId;
    private final int idProdus;
    protected String numeProdus;
    protected double pretProdus;
    protected Ingredient[] ingredienteProdus;

    static {
        contorId = 0;
    }

    {
        idProdus = ++contorId;
    }

    public Produs(String numeProdus, double pretProdus, Ingredient[] ingredienteProdus) {
        this.numeProdus = numeProdus;
        this.pretProdus = pretProdus;
        this.ingredienteProdus = Arrays.copyOf(ingredienteProdus, Array.getLength(ingredienteProdus));
    }

    public Produs(Produs produs) {
        this.numeProdus = produs.numeProdus;
        this.pretProdus = produs.pretProdus;
        this.ingredienteProdus = Arrays.copyOf(produs.ingredienteProdus, Array.getLength(produs.ingredienteProdus));
    }

    public String getNumeProdus() {
        return numeProdus;
    }

    public double getPretProdus() {
        return pretProdus;
    }

    public int getIdProdus() {
        return idProdus;
    }

    @Override
    public String toString() {
        String string = String.format("""
                Id produs: %d
                Nume: %s
                Pret: %f
                Ingrediente: """, idProdus, numeProdus, pretProdus);
        for (Ingredient ingredient : ingredienteProdus) {
            string += ingredient.getNume() + ' ';
        }
        return string;
    }
}
