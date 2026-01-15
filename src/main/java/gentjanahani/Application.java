package gentjanahani;

import gentjanahani.entities.Customer;
import gentjanahani.entities.Order;
import gentjanahani.entities.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Application {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        //PRODOTTI
        Product primoProdotto = new Product("Ciuccio", "Baby", 5.9);
        System.out.println(primoProdotto);

        List<Product> prodotti = new ArrayList<>();
        prodotti.add(primoProdotto);
        prodotti.add(new Product("Sciarpa", "Abbigliamento", 35.9));
        prodotti.add(new Product("Biberon", "Baby", 10.5));
        prodotti.add(new Product("L'ultimo segreto", "Books", 32.9));
        prodotti.add(new Product("Pannolini", "Baby", 60.5));
        prodotti.add(new Product("Berretto", "Boys", 15.9));
        prodotti.add(new Product("Pomata", "Baby", 10.5));
        prodotti.add(new Product("Macchina telecomandata", "Boys", 35.9));
        prodotti.add(new Product("Donne che pensano troppo", "Books", 20.5));
        prodotti.add(new Product("Harry Potter", "Books", 17.9));
        prodotti.add(new Product("Passeggino", "Baby", 80.5));
        prodotti.add(new Product("Collana", "Accessori", 55.9));
        prodotti.add(new Product("Biberon Rosa", "Baby", 13.5));
        prodotti.add(new Product("Il piccolo principe", "Books", 12.9));
        prodotti.add(new Product("Fionda", "Boys", 6.5));
        prodotti.add(new Product("Gormiti", "Boys", 10.9));
        prodotti.add(new Product("Termometro", "Baby", 10.5));
        prodotti.add(new Product("Drone", "Boys", 305.9));
        prodotti.add(new Product("Il signore degli Anelli:tutta la saga", "Books", 200.5));
        prodotti.add(new Product("Orgoglio e pregiudizio", "Books", 107.9));
        prodotti.add(new Product("Copertina", "Baby", 20.5));
        prodotti.add(new Product("La divina Commedia", "Books", 100.5));
        prodotti.add(new Product("Il silenzio dei colpevoli", "Books", 110.5));

        //CLIENTI
        Customer primoCliente = new Customer("Mario", 2);
        System.out.println(primoCliente);
        List<Customer> clienti = new ArrayList<>();
        clienti.add(primoCliente);
        clienti.add(new Customer("Sara", 1));
        clienti.add(new Customer("Lucia", 2));
        clienti.add(new Customer("Mikol", 2));
        clienti.add(new Customer("Alfredo", 1));
        clienti.add(new Customer("Giangiorno", 2));
        clienti.add(new Customer("Pupo", 1));
        clienti.add(new Customer("Samira", 3));
        clienti.add(new Customer("Francesco", 3));
        clienti.add(new Customer("Marco", 1));
        clienti.add(new Customer("Sabrina", 2));
        System.out.println(clienti);

        //ORDINI
        //lista di ordini
        List<Product> carrello1 = List.of(
                prodotti.get(3),
                prodotti.get(7),
                prodotti.get(2)
        );
        List<Product> carrello2 = List.of(
                prodotti.get(4),
                prodotti.get(7),
                prodotti.get(3)
        );

        List<Product> carrelloBaby = List.of(
                prodotti.get(2),
                prodotti.get(4),
                prodotti.get(6)
        );
        List<Product> carrello4 = List.of(
                prodotti.get(1),
                prodotti.get(8),
                prodotti.get(10)
        );

        Order primoOrdine = new Order(
                "Spedito",
                LocalDate.now(),
                LocalDate.now().plusDays(3),
                carrello1,
                primoCliente);

        Order secondoOrdine = new Order(
                "In lavorazione",
                LocalDate.now(),
                LocalDate.now().plusDays(10),
                carrelloBaby,
                clienti.get(2));

        Order terzoOrdine = new Order(
                "In ritardo",
                LocalDate.now(),
                LocalDate.now().plusDays(15),
                carrello2,
                clienti.get(2));

        Order quartoOrdine = new Order(
                "Spedito",
                LocalDate.now(),
                LocalDate.now().plusDays(15),
                carrello4,
                clienti.get(3));

        System.out.println("PRIMO ORDINE:  " + primoOrdine);
        System.out.println("SECONDO ORDINE:  " + secondoOrdine);

        List<Order> ordini = new ArrayList<>();
        ordini.add(primoOrdine);
        ordini.add(secondoOrdine);
        ordini.add(terzoOrdine);
        ordini.add(quartoOrdine);


        System.out.println("-----ESERCIZI-----");

        //ES1-Raggruppa gli ordini per cliente utilizzando Stream e Lambda Expressions.
        // Crea una mappa in cui la chiave è il cliente e il valore è la lista di ordini effettuati da quel cliente.

        Map<Customer, List<Order>> ordiniPerCliente = ordini.stream().collect(Collectors.groupingBy(order -> order.getCustomer()));
        ordiniPerCliente.forEach((cliente, listaOrdini) -> {
            System.out.println("CLiente: " + cliente.getName());
            System.out.println(" -Ordine: " + listaOrdini);
        });


        //ES2-Dato un elenco di ordini, calcola il totale delle vendite per ogni cliente utilizzando Stream e Lambda Expressions.
        //Crea una mappa in cui la chiave è il cliente e il valore è l'importo totale dei suoi acquisti.
//
//        Map<Customer, Double> totaleVenditePerCliente = ordini.stream()
//                .collect(Collectors.groupingBy(order -> order.getCustomer(),
//                        Collectors.summingDouble()
//                ));


        //ES3-Dato un elenco di prodotti, trova i  più costosi utilizzando Stream e Lambda Expressions.
        List<Product> prodottiPiùCostosi = prodotti.stream()
                .sorted(Comparator.comparing(Product::getPrice).reversed())
                .toList();
        System.out.println("Prodotti più costosi: " + prodottiPiùCostosi);


        //ES4-Dato un elenco di ordini, calcola la media degli importi degli ordini utilizzando Stream e Lambda Expressions.

        //ES5-Dato un elenco di prodotti, raggruppa i prodotti per categoria e calcola la somma degli importi per categoria
        //utilizzando Stream e Lambda Expressions.

    }
}
