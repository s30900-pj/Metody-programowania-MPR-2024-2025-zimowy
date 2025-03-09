package org.example;

import java.util.List;

public class Order {
    private int id;
    private int customerId;
    private List<Pizza> orderedPizzas;

    public Order(int id, int customerId, List<Pizza> orderedPizzas) {
        this.id = id;
        this.customerId = customerId;
        this.orderedPizzas = orderedPizzas;
    }

    public double calculatePrice() {
        double totalPrice = 0;
        for (Pizza pizza : orderedPizzas) {
            totalPrice += pizza.getPrice();
        }
        return totalPrice;
    }
}
