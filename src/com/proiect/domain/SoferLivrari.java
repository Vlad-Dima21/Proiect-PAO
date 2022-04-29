package com.proiect.domain;

public class SoferLivrari extends Angajat{

    private int numarLivrariZi;
    private String nrInmatriculareMasina;
    private int capacitateMaximaPachete;


    public SoferLivrari(String nume, String prenume, Integer salariu, char sex, String cnp, String telefon, int numarLivrariZi, String nrInmatriculareMasina, int capacitateMaximaPachete) {
        super(nume, prenume, salariu, sex, cnp, telefon);
        this.numarLivrariZi = numarLivrariZi;
        this.nrInmatriculareMasina = nrInmatriculareMasina;
        this.capacitateMaximaPachete = capacitateMaximaPachete;
    }

    public SoferLivrari(SoferLivrari angajat) {
        super(angajat.nume, angajat.prenume, angajat.salariu, angajat.sex, angajat.cnp, angajat.telefon);
        this.numarLivrariZi = angajat.numarLivrariZi;
        this.nrInmatriculareMasina = angajat.nrInmatriculareMasina;
        this.capacitateMaximaPachete = angajat.capacitateMaximaPachete;
    }

    public String toCSVformat() {
        StringBuilder str = new StringBuilder();
        str.append(this.nume).append(",")
                .append(this.prenume).append(',')
                .append(this.salariu).append(',')
                .append(this.sex).append(',')
                .append(this.cnp).append(',')
                .append(this.telefon).append(',')
                .append(this.numarLivrariZi).append(',')
                .append(this.nrInmatriculareMasina).append(',')
                .append(this.capacitateMaximaPachete);
        return str.toString();
    }
}
