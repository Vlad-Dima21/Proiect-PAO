package com.proiect.domain;

import java.lang.reflect.Array;
import java.util.Arrays;

public class OperatorComenzi extends Angajat {

    private int[] program;
    private int[] zileLucratoare;
    private double coefiecientBonus;
    private String parolaAngajat;


    public OperatorComenzi(String nume, String prenume, Integer salariu, char sex, String cnp, String telefon, int[] program, int[] zileLucratoare, double coefiecientBonus, String parolaAngajat) {
        super(nume, prenume, salariu, sex, cnp, telefon);
        this.program = Arrays.copyOf(program, Array.getLength(program));
        this.zileLucratoare = Arrays.copyOf(zileLucratoare, Array.getLength(zileLucratoare));
        this.coefiecientBonus = coefiecientBonus;
        this.parolaAngajat = parolaAngajat;
    }

    public void setParolaAngajat(String parolaAngajat) {
        this.parolaAngajat = parolaAngajat;
    }

    public boolean parolaCorecta(String parolaInput) {
        return parolaAngajat.equals(parolaInput);
    }
}
