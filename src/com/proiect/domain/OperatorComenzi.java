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

    public String toCSVFormat() {
        StringBuilder str = new StringBuilder();
        str.append(this.nume).append(",")
                .append(this.prenume).append(',')
                .append(this.salariu).append(',')
                .append(this.sex).append(',')
                .append(this.cnp).append(',')
                .append(this.telefon).append(',')
                .append('[').append(this.program[0]).append(' ')
                .append(this.program[1]).append("],")
                .append('[');

        int i;
        for (i = 0; i < Array.getLength(this.zileLucratoare) - 1; i++) {
            str.append(this.zileLucratoare[i]).append(' ');
        }
        str.append(this.zileLucratoare[i]).append("],")
                .append(this.coefiecientBonus).append(',')
                .append(this.parolaAngajat);
        return str.toString();
    }
}
