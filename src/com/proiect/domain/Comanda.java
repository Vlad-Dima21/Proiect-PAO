package com.proiect.domain;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Comanda {

    private static int contorId;
    private final int idComanda;
    private final Client client;
    private Locatie locatie;
    private SoferLivrari soferLivrari;
    private OperatorComenzi operatorComenzi;
    private Produs[] produse;
    private double pretTotal;

    static {
        contorId = 0;
    }

    {
        idComanda = ++contorId;
    }

    public Comanda(Client client, Locatie locatie, SoferLivrari soferLivrari, OperatorComenzi operatorComenzi, Produs[] produse) {
        this.client = client;
        this.locatie = locatie;
        this.soferLivrari = soferLivrari;
        this.operatorComenzi = operatorComenzi;
        this.produse = Arrays.copyOf(produse, Array.getLength(produse));
    }

    public Comanda(Client client) {
        this.client = client;
    }

    public int getIdComanda() {
        return idComanda;
    }

    public void setPretTotal(double pretTotal) {
        this.pretTotal = pretTotal;
    }
}
