package com.proiect.domain;

import java.util.Objects;

public class Client {
    private static int contorId;
    private final int idClient;
    private String nume;
    private String prenume;
    private String email;
    private String telefon;


    static {
        contorId = 0;
    }

    {
        idClient = ++contorId;
    }

    public Client(String nume, String prenume, String email, String telefon) {
        this.nume = nume;
        this.prenume = prenume;
        this.email = email;
        this.telefon = telefon;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nume, prenume, email);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (this == obj) {
            return true;
        }
        if (obj.getClass() == getClass()) {
            boolean rez = true;
            rez = rez && (this.nume.equals(((Client) obj).nume));
            rez = rez && (this.prenume.equals(((Client) obj).prenume));
            rez = rez && (this.email.equals(((Client) obj).email));
            return rez;
        }
        return false;
    }

    public String getNume() {
        return nume;
    }

    public String getTelefon() {
        return telefon;
    }

    @Override
    public String toString() {
        return String.format("Id: %d, Nume: %s, Prenume: %s, Email: %s, Telefon: %s ", idClient, nume, prenume, email, telefon);
    }

    public int getIdClient() {
        return idClient;
    }

    public String toCSVformat() {
        StringBuilder str = new StringBuilder();
        str.append(this.nume).append(',')
                .append(this.prenume).append(',')
                .append(this.email).append(',')
                .append(this.telefon);
        return str.toString();
    }
}
