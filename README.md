## Tema aleasă
Aplicația se ocupă de gestiunea comenzilor online a unui lanț de cofetării. 

Cofetăriile ce aparțin lanțului se află în mai multe locații din țară, iar la fiecare cofetărie se gestionează activitatea operatorilor de comenzi online (cei care se ocupă de prelucrarea și preluarea comenzilor online) și a șoferilor (care se ocupă de livrarea comenzilor).
Comenzile sunt plasate de clienți, care pot alege ce produse să fie în comandă . Clientul poate alege una dintre locațiile deja „cunoscute”.
Produsele sunt de două tipuri: prăjituri și torturi. La prăjituri există un discount în cazul în care comanda conține **_n_** prăjituri de același tip. Produsele conțin ingrediente, iar entitățile de acest tip ajută angajații să țină evidența stocului. 

## Etapa 1
### Clase:
- Locație
- Cofetărie
- Angajat
- Șofer Livrări
- Operator Comenzi
- Client
- Comandă
- Produs
- Prăjitură
- Tort
- Ingredient

Dintre ele, **_Angajat_** și **_Produs_** sunt clase abstracte. 
Am folosit o structură asemănătoare cu cea de [aici](https://github.com/adrian-buturuga/pao_lab/tree/main/projectStructure).

Operațiile ce pot fi efectuate direct din meniul aplicației sunt: 
1.  Vizualizare cofetării
2.  Obținere listă cu cofetării deschise
3.  Adăugare client
4.  Interogare număr telefon client după nume
5.  Ingrediente cu stocul sub 50%
6.  Aprovizionare stoc
7.  Creare și adăugare prăjitură ( fără discount )
8.  Ștergere produs după ID
9.  Creare comandă
10. Afișare angajați cu salariul mai mic de..
11. Actualizare număr telefon șofer livrări
12. Schimbare parolă operator comenzi
13. Stergere client

## Etapa 2
### Stocare in fisiere CSV

Obiectele de tip **Client**, **Ingredient**, **Opeatator Comanda** și **Sofer Livrari** sunt stocate în fișiere separate de tip CSV.

### Auditing
Fiecare acțiune de la etapa 1 este înregistrată într-un fișier CSV. 

## Etapa 3
### Persistență
Operațiile CRUD pe obiectele de tip **Client**, **Ingredient**, **Opeatator Comanda** și **Sofer Livrari** folosesc operații pe o bază de date de tip MYSQL.
