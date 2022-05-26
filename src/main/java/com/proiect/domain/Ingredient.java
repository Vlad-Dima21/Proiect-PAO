package com.proiect.domain;

public class Ingredient {

    private static int contorId;
    private int idIngredient;
    private String nume;
    private int stoc;
    private int stocLunar;
    private String numeFurnizor;

//    static {
//        contorId = 0;
//    }

    {
        idIngredient = ++contorId;
    }

    public Ingredient(String nume, int stoc, int stocLunar, String numeFurnizor) {
        this.nume = nume;
        this.stoc = stoc;
        this.stocLunar = stocLunar;
        this.numeFurnizor = numeFurnizor;
    }

    public String getNume() {
        return nume;
    }

    public void setStoc(int stoc) {
        this.stoc = stoc;
    }

    public static void setContorId(int contorId) {
        Ingredient.contorId = contorId;
    }

    public void setIdIngredient(int idIngredient) {
        this.idIngredient = idIngredient;
    }

    public int getIdIngredient() {
        return idIngredient;
    }

    public int getStocLunar() {
        return stocLunar;
    }

    public double getRaportStoc() {
        return (double)stoc/stocLunar;
    }

    public int getStoc() {
        return stoc;
    }

    public String getNumeFurnizor() {
        return numeFurnizor;
    }

    public String toCSVformat() {
        return nume + ',' +
                stoc + ',' +
                stocLunar + ',' +
                numeFurnizor;
    }
}
