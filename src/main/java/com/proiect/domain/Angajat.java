package com.proiect.domain;

import java.util.Objects;

public abstract class Angajat {

    private static int contorId;
    private int idAngajat;

    protected String nume;
    protected String prenume;
    protected Integer salariu;
    protected char sex;
    protected String cnp;
    protected String telefon;


//    static {
//        contorId = 0;
//    }

    {
        idAngajat = ++contorId;
    }

    public Angajat(String nume, String prenume, Integer salariu, char sex, String cnp, String telefon) {
        this.nume = nume;
        this.prenume = prenume;
        this.salariu = salariu;
        this.sex = sex;
        this.cnp = cnp;
        this.telefon = telefon;
    }

    public Integer getSalariu() {
        return salariu;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    @Override
    public String toString() {
        return String.format("Id: %d, Nume complet: %s, Salariu: %d, Telefon: %s",idAngajat, nume + ' ' + prenume, salariu, telefon);
    }

    public int getIdAngajat() {
        return idAngajat;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Angajat angajat = (Angajat)obj;
        return this.nume.toLowerCase().equals(angajat.nume.toLowerCase()) && this.prenume.toLowerCase().equals(angajat.prenume.toLowerCase()) && this.cnp.equals(angajat.cnp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nume, prenume, cnp);
    }

    public String getNume() {
        return nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public char getSex() {
        return sex;
    }

    public String getCnp() {
        return cnp;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setIdAngajat(int idAngajat) {
        this.idAngajat = idAngajat;
    }

    public static void setContorId(int contorId) {
        Angajat.contorId = contorId;
    }
}
