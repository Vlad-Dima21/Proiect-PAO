package com.proiect.domain;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Tort extends Produs{

    private Integer varstaSarbatorit;
    private String mesajSarbatorit;
    private String tematicaMartipan;

    public Tort(String numeProdus, double pretProdus, Ingredient[] ingredienteProdus, Integer varstaSarbatorit, String mesajSarbatorit, String tematicaMartipan) {
        super(numeProdus, pretProdus, ingredienteProdus);
        this.varstaSarbatorit = varstaSarbatorit;
        this.mesajSarbatorit = mesajSarbatorit;
        this.tematicaMartipan = tematicaMartipan;
    }

    public Tort(Tort tort) {
        super(tort);
//      celelalte campuri sunt completate cu ajutorul setterilor
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder(super.toString());
        string.append("\nVarsta sarbatoritului: ").append(varstaSarbatorit==null ? "clientul nu a setat varsta" : varstaSarbatorit);
        string.append("\nMesaj sarbatorit: ");
        if (mesajSarbatorit == null) {
            string.append("clientul nu a ales un mesaj");
        }
        string.append("\nTematica martipan: ");
        if (tematicaMartipan == null) {
            string.append("clientul nu a ales o tematica");
        }
        return string.toString();
    }

    public void setVarstaSarbatorit(Integer varstaSarbatorit) {
        this.varstaSarbatorit = varstaSarbatorit;
    }

    public void setMesajSarbatorit(String mesajSarbatorit) {
        this.mesajSarbatorit = mesajSarbatorit;
    }

    public void setTematicaMartipan(String tematicaMartipan) {
        this.tematicaMartipan = tematicaMartipan;
    }
}
