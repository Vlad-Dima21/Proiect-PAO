package com.proiect.view;

import com.proiect.domain.*;
import com.proiect.services.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

import static java.lang.System.out;

public class ConsoleApp {
    private CofetarieService cofetarieService = new CofetarieService();
    private ClientService clientService = new ClientService();
    private IngredientService ingredienteService = new IngredientService();
    private ProdusService produsService = new ProdusService();
    private PrajituraService prajituraService = new PrajituraService();
    private LocatieService locatieService = new LocatieService();
    private ComandaService comandaService = new ComandaService();
    private AngajatService angajatService = new AngajatService();
    private SoferLivrariService soferLivrariService = new SoferLivrariService();
    private OperatorComenziService operatorComenziService = new OperatorComenziService();

    public void meniu() {
            String multeLinii = "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n";
            Scanner scanner = new Scanner(System.in);
            int optiune;
            do {
                out.print(multeLinii + """
                        Alege una dintre optiuni:
                        
                    1.  Vizualizare cofetarii
                    2.  Obtinere lista cu cofetarii deschise
                    3.  Adaugare client
                    4.  Interogare numar telefon client dupa nume
                    5.  Ingrediente cu stocul sub 50%
                    6.  Actualizare stoc reaprovizionare
                    7.  Creare si adaugare prajitura ( fara discount )
                    8.  Stergere produs dupa ID
                    9.  Creare comanda
                    10. Afisare angajati cu salariul mai mic de..
                    11. Actualizare numar telefon sofer livrari
                    12. Schimbare parola operator comenzi
                    13. Iesire
                                    
                    Optiune: """);
                optiune = scanner.nextInt();
                switch (optiune) {
                    case (1): {
                        out.println(multeLinii + cofetarieService.formatAfisareCofetarii());
                        scanner.nextLine();out.print("\nApasati enter...");scanner.nextLine();
                        break;
                    }
                    case (2): {
                        out.println(multeLinii + cofetarieService.getCofetariiDeschise());
                        scanner.nextLine();out.print("\nApasati enter...");scanner.nextLine();
                        break;
                    }
                    case (3): {
                        out.print(multeLinii + "Numele clientului: ");
                        String nume = scanner.next();
                        out.print("Prenumele clientului: ");
                        String prenume = scanner.next();
                        out.print("Email: ");
                        String email = scanner.next();
                        out.print("Telefon: ");
                        String telefon = scanner.next();
                        clientService.AdaugareClient(nume,prenume,email,telefon);
                        out.println("Clientul a fost adaugat!");
                        scanner.nextLine();out.print("\nApasati enter...");scanner.nextLine();
                        break;
                    }
                    case (4): {
                        out.println(multeLinii + "Numele clientului: ");
                        String nume = scanner.next();
                        out.println(clientService.GasireTelefonDupaNume(nume));
                        scanner.nextLine();out.print("\nApasati enter...");scanner.nextLine();
                        break;
                    }
                    case (5): {
                        out.println(multeLinii);
                        Vector numeIngrediente = ingredienteService.getStocMic();
                        if (numeIngrediente.isEmpty()) {
                            out.println("Toate ingredientele sunt in stoc peste 50%.");
                        }
                        else {
                            int contor = 1;
                            for (Object nume : numeIngrediente) {
                                out.println(contor + "." + nume);
                                contor++;
                            }
                        }
                        scanner.nextLine();out.print("\nApasati enter...");scanner.nextLine();
                        break;
                    }
                    case (6): {
                        ingredienteService.setStocReaprovizionare();
                        out.println(multeLinii + "Stocul a fost reaprovizionat.");
                        scanner.nextLine();out.print("\nApasati enter...");scanner.nextLine();
                    }
                    case (7): {
                        out.println(multeLinii);
                        out.print("Numele prajiturii: ");
                        String nume = scanner.next();
                        out.print("Pretul prajiturii: ");
                        double pret = scanner.nextDouble();
                        out.print("Numarul de ingrediente: ");
                        int nrIngrediente = scanner.nextInt();
                        while (nrIngrediente > ingredienteService.getNrIngredienteInStoc()) {
                            out.print(String.format("Exista doar %d ingrediente, alt numar: ", ingredienteService.getNrIngredienteInStoc()));
                            nrIngrediente = scanner.nextInt();
                        }
                        Ingredient[] ingredientePrajitura = new Ingredient[nrIngrediente];
                        out.println("Alege " + nrIngrediente + " ingrediente: ");
                        int contor = 1;
                        for (String numeIngredient : ingredienteService.getNume()) {
                            out.println(contor + ". " + numeIngredient);
                            contor++;
                        }
                        contor = 1;
                        while (contor <= nrIngrediente) {
                            out.print("(optiune " + contor + "): ");
                            int optiuneI = scanner.nextInt();
                            ingredientePrajitura[contor-1] = (Ingredient) ingredienteService.getIngredient(optiuneI-1);
                            contor++;
                        }
                        out.print("Gramaj prajitura: ");
                        double gramajPrajitura = scanner.nextDouble();
                        prajituraService.crearePrajitura(nume, pret, ingredientePrajitura, gramajPrajitura);
                        scanner.nextLine();out.print("\nApasati enter...");scanner.nextLine();
                        break;
                    }
                    case (8): {
                        out.print(multeLinii + "Introdu ID-ul produsului care trebuie sters: ");
                        int id = scanner.nextInt();
                        if (produsService.stergereProdus(id) == -1) {
                            out.println("Produsul cu id-ul " + id + " nu exista!");
                        }
                        else {
                            out.println("Produsul a fost sters.");
                        }
                        scanner.nextLine();out.print("\nApasati enter...");scanner.nextLine();
                        break;
                    }
                    case (9): {
                        out.println(multeLinii);
                        out.println(clientService.getClientiString());
                        out.print("Introduceti id-ul clientului: ");
                        int idClient = scanner.nextInt();
                        Client client = clientService.getClientById(idClient);
                        while (client == null) {
                            out.print("Id invalid, incearca din nou: ");
                            idClient = scanner.nextInt();
                            client = clientService.getClientById(idClient);
                        }
                        out.println(multeLinii);
                        out.println(locatieService.getLocatiiString());
                        out.print("Introduceti id-ul adresei la care sa se faca livrarea: ");
                        int idLocatie = scanner.nextInt();
                        Locatie locatie = locatieService.getLocatieById(idLocatie);
                        while (locatie == null) {
                            out.print("Id invalid, incearca din nou: ");
                            idLocatie = scanner.nextInt();
                            locatie = locatieService.getLocatieById(idLocatie);
                        }
                        out.println(multeLinii);
                        out.println("Alege produsele\n");
                        List<Produs> produse = new ArrayList<>();
                        int contorProdus = 1;
                        for (Produs produs : produsService.getProduse()) {
                            out.print(contorProdus + ". ");
                            out.print(String.format("Nume: %s, Pret: %f", produs.getNumeProdus(), produs.getPretProdus()));
                            out.print("\nAdaugi produsul la comanda(True/False): ");
                            boolean adauga = scanner.nextBoolean();
                            if (adauga) {
                                if (produs instanceof Tort) {
                                    Tort produs2 = new Tort((Tort) produs);
                                    out.print("Varsta sarbatorit: ");
                                    int varsta = scanner.nextInt();
                                    out.print("Mesaj \"La multi ani!\": ");
                                    String mesaj = scanner.next();
                                    out.print("Tematica martipan: ");
                                    String tematica = scanner.next();
                                    produs2.setVarstaSarbatorit(varsta);
                                    produs2.setMesajSarbatorit(mesaj);
                                    produs2.setTematicaMartipan(tematica);
                                    produse.add(produs2);
                                }
                                else {
                                    produse.add(produs);
                                }
                            }
                            contorProdus++;
                        }
                        Produs[] produseArray = new Produs[produse.size()];
                        produse.toArray(produseArray);
                        comandaService.CreareComanda(client, locatie, produseArray);
                        out.println("\nComanda a fost adaugata!");
                        scanner.nextLine();out.print("\nApasati enter...");scanner.nextLine();
                        break;
                    }
                    case (10): {
                        out.println(multeLinii);
                        out.print("Salariu: ");
                        int salariu = scanner.nextInt();
                        out.println(angajatService.AngajatiCuSalariulMaxim(salariu));
                        scanner.nextLine();out.print("\nApasati enter...");scanner.nextLine();
                        break;
                    }
                    case (11): {
                        out.println(multeLinii);
                        out.println(soferLivrariService.getAllSoferiString());
                        out.print("Id-ul soferului: ");
                        int idSofer = scanner.nextInt();
                        out.print("Numarul nou de telefon: ");;
                        String telefon = scanner.next();
                        soferLivrariService.ActualizareTelefon(idSofer, telefon);
                        out.println("Numarul a fost schimbat!");
                        scanner.nextLine();out.print("\nApasati enter...");scanner.nextLine();
                        break;
                    }
                    case (12): {
                        out.println(multeLinii);
                        out.println(operatorComenziService.getAllOperatori());
                        out.print("Id-ul operatorului: ");
                        int idOp = scanner.nextInt();
                        out.print("Parola veche: ");
                        String parolaVeche = scanner.next();
                        out.print("Parola noua: ");
                        String parolaNoua = scanner.next();
                        out.println(operatorComenziService.SchimbareParola(idOp, parolaVeche, parolaNoua));
                        scanner.nextLine();out.print("\nApasati enter...");scanner.nextLine();
                        break;
                    }
                }
            } while (optiune != 13);
        }

    public static void main(String[] args) {
        ConsoleApp app = new ConsoleApp();
        app.meniu();
    }
}
