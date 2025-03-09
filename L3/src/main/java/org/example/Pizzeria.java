// spraing

package org.example;

import java.util.ArrayList;
import java.util.List;

public class Pizzeria {
    private List<Pizza> pizzas;

    public Pizzeria() {
        this.pizzas = new ArrayList<>();
        pizzas.add(new Pizza(10.0d, "Margherita"));
        pizzas.add(new Pizza(12.0d, "Funghi"));
        pizzas.add(new Pizza(23.0d, "Hawajska"));
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }
}
