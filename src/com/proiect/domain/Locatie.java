package com.proiect.domain;

public class Locatie {
    private static int contorId;
    private final int idLocatie;
    private String judet;
    private String oras;
    private Integer sector;
    private String numeStrada;
    private String numarAdresa;
    private boolean esteCapitala;

    static {
        contorId = 0;
    }

    {
        idLocatie = ++contorId;
    }

    public Locatie(String judet, String oras, Integer sector, String numeStrada, String numarAdresa, boolean esteCapitala) {
        this.judet = judet;
        this.oras = oras;
        this.sector = sector;
        this.numeStrada = numeStrada;
        this.numarAdresa = numarAdresa;
        this.esteCapitala = esteCapitala;
    }

    public int getIdLocatie() {
        return idLocatie;
    }

    public String getJudet() {
        return judet;
    }

    public String getOras() {
        return oras;
    }

    public String getNumeStrada() {
        return numeStrada;
    }

    public String getNumarAdresa() {
        return numarAdresa;
    }

    public boolean locatiaEsteInCapitala() { return esteCapitala; }

    @Override
    public String toString() {
        return String.format("Id: %d, Judet: %s, Oras: %s, Strada: %s Nr. %s", idLocatie, judet, oras, numeStrada, numarAdresa);
    }
}
