package com.proiect.domain;

public class Cofetarie {
    private static int contorId;
    private final int idCofetarie;
    private Locatie locatieCofetarie;
    private int oraDeschidere;
    private int oraInchidere;
    private int nrLocuri;

    static {
        contorId = 0;
    }

    public Cofetarie(Locatie locatieCofetarie, int oraDeschidere, int oraInchidere, int nrLocuri) {
        this.idCofetarie = ++contorId;
        this.locatieCofetarie = locatieCofetarie;
        this.oraDeschidere = oraDeschidere;
        this.oraInchidere = oraInchidere;
        this.nrLocuri = nrLocuri;
    }

    @Override
    public String toString() {
        String cofetarie = "";

        cofetarie += "Id cofetărie: " + idCofetarie;
        cofetarie += "\nAdresă: " + (!locatieCofetarie.locatiaEsteInCapitala() ? ("\n\t" + locatieCofetarie.getJudet()) : "") +
                        "\n\t" +  locatieCofetarie.getOras() + "\n\t" + locatieCofetarie.getNumeStrada() +
                        " Nr. " + locatieCofetarie.getNumarAdresa();
        cofetarie += "\nProgram: " + oraDeschidere + " - " + oraInchidere;
        cofetarie += "\nNumărul de locuri disponibile: " + nrLocuri;
        return cofetarie;
    }

    public int getIdCofetarie() {
        return idCofetarie;
    }

    public int getOraInchidere() {
        return oraInchidere;
    }

    public int getOraDeschidere() {
        return oraDeschidere;
    }
}
