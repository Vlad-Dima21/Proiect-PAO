package com.proiect.domain;

public class Prajitura extends Produs{

    private int nrPrajituriDiscount;
    private double procentDiscount;
    private double gramajPrajitura;

    public Prajitura(String numeProdus, double pretProdus, Ingredient[] ingredienteProdus, int nrPrajituriDiscount, double procentDiscount, double gramajPrajitura) {
        super(numeProdus, pretProdus, ingredienteProdus);
        this.nrPrajituriDiscount = nrPrajituriDiscount;
        this.procentDiscount = procentDiscount;
        this.gramajPrajitura = gramajPrajitura;
    }

    @Override
    public String toString() {
        String string = super.toString();
        string += '\n' + String.format("""
                Numar prajituri pentru discount: %d
                Procent discount: %f
                Gramaj prajitura: %f""", nrPrajituriDiscount, procentDiscount, gramajPrajitura);
        return string;
    }
}
