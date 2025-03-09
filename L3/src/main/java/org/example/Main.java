package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Pizzeria pizzeria = new Pizzeria();
        List<Pizza> menu = pizzeria.getPizzas();

        System.out.println("Witamy w pizzerii! Dostępne pizze:");
        for (Pizza pizza : menu) {
            System.out.println("- " + pizza.getName() + " - " + pizza.getPrice() + " PLN");
        }

        List<Pizza> selectedPizzasCustomer1 = new ArrayList<>();
        selectedPizzasCustomer1.add(menu.get(0));
        selectedPizzasCustomer1.add(menu.get(2));

        Order order1 = new Order(1, 1, selectedPizzasCustomer1);
        double totalPrice1 = order1.calculatePrice();

        List<Pizza> selectedPizzasCustomer2 = new ArrayList<>();
        selectedPizzasCustomer2.add(menu.get(1));

        Order order2 = new Order(2, 2, selectedPizzasCustomer2);
        double totalPrice2 = order2.calculatePrice();

        System.out.println("\nZamówienie dla klienta 1:");
        for (Pizza pizza : selectedPizzasCustomer1) {
            System.out.println("- " + pizza.getName());
        }
        System.out.println("Cena całkowita zamówienia: " + totalPrice1 + " PLN");

        System.out.println("\nZamówienie dla klienta 2:");
        for (Pizza pizza : selectedPizzasCustomer2) {
            System.out.println("- " + pizza.getName());
        }
        System.out.println("Cena całkowita zamówienia: " + totalPrice2 + " PLN");
    }
}


//public class Main {
//    public static void main(String[] args) {
//        Pizzeria pizzeria = new Pizzeria();
//        List<Pizza> menu = pizzeria.getPizzas();
//
//        System.out.println("Witamy w pizzerii! Dostępne pizze:");
//        for (int i = 0; i < menu.size(); i++) {
//            Pizza pizza = menu.get(i);
//            System.out.println((i + 1) + ". " + pizza.getName() + " - " + pizza.getPrice() + " PLN");
//        }
//
//        Scanner scanner = new Scanner(System.in);
//        List<Pizza> selectedPizzas = new ArrayList<>();
//        String input;
//
//        System.out.println("Wpisz numer pizzy, aby dodać ją do zamówienia, lub 'q' aby zakończyć:");
//
//        while (true) {
//            input = scanner.nextLine();
//
//            if (input.equals("q")) {
//                break;
//            }
//
//            try {
//                int pizzaNumber = Integer.parseInt(input);
//                if (pizzaNumber > 0 && pizzaNumber <= menu.size()) {
//                    selectedPizzas.add(menu.get(pizzaNumber - 1));
//                    System.out.println("Dodano: " + menu.get(pizzaNumber - 1).getName());
//                } else {
//                    System.out.println("Niepoprawny numer pizzy.");
//                }
//            } catch (NumberFormatException e) {
//                System.out.println("Niepoprawny format, wpisz numer pizzy lub 'q' aby zakończyć.");
//            }
//        }
//
//        Order order = new Order(1, 123, selectedPizzas);
//        double totalPrice = order.calculatePrice();
//        System.out.println("Cena całkowita zamówienia: " + totalPrice + " PLN");
//    }
//}
