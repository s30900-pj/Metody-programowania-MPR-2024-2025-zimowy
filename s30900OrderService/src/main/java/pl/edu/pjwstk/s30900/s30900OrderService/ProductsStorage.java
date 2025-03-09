package pl.edu.pjwstk.s30900.s30900OrderService;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ProductsStorage {
    private Map<Product, Integer> products;

    public ProductsStorage() {
        this.products = new HashMap<>();
    }

    public boolean containsProduct(Product product) {
        return products.containsKey(product);
    }

    public void addProduct(Product product, int quantity) {
        if (products.containsKey(product)) {
            int currentQuantity = products.get(product);
            products.put(product, currentQuantity + quantity);
        } else {
            products.put(product, quantity);
        }
    }

    public void removeProduct(Product product, int quantity) {
        if (products.containsKey(product)) {
            int currentQuantity = products.get(product);
            if (currentQuantity <= quantity) {
                products.remove(product);
            } else {
                products.put(product, currentQuantity - quantity);
            }
        }
    }

    public Map<Product, Integer> getAllProducts() {
        return new HashMap<>(products);
    }
    public void clear() {
        products.clear();
    }
}
