package pl.edu.pjwstk.s30900.s30900OrderService;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
@Component

public class Order {
    private long orderId;
    private String address;
    private State state;
    private Map<Product, Integer> products;

    public Order() {
        this.products = new HashMap<>();
        this.state = State.NOWE;
    }

    public void addProduct(Product product, int quantity, ProductsStorage productsStorage) {
        if (quantity > 0) {
            if (productsStorage.containsProduct(product)) {
                int currentQuantity = products.getOrDefault(product, 0);
                products.put(product, currentQuantity + quantity);
            } else {
                // Obsługa błędu - produkt nie istnieje w magazynie
                System.out.println("Error: Product does not exist in the storage.");
            }
        } else {
            // Obsługa błędu - ilość nieprawidłowa
            System.out.println("Error: Invalid quantity.");
        }
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public void cancelOrder(ProductsStorage productsStorage) {
        if (state == State.NOWE) {
            for (Map.Entry<Product, Integer> entry : products.entrySet()) {
                Product product = entry.getKey();
                int quantity = entry.getValue();
                productsStorage.addProduct(product, quantity);
            }
            state = State.ANULOWANE;
        } else {
            // Obsługa błędu - niemożliwe anulowanie w aktualnym stanie
            System.out.println("Error: Order cannot be canceled in the current state.");
        }
    }

    public Map<Product, Integer> getProducts() {
        return new HashMap<>(products);
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setProducts(Map<Product, Integer> products) {
        this.products = products;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

}
