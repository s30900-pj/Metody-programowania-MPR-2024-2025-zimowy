package pl.edu.pjwstk.s30900.s30900OrderService;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class OrderService {

    private final OrderStorage orderStorage;
    private final ProductsStorage productsStorage;

    public OrderService(OrderStorage orderStorage, ProductsStorage productsStorage) {
        this.orderStorage = orderStorage;
        this.productsStorage = productsStorage;
    }

    public Order createOrder(Long orderId, String orderAddress) {
        Order order = new Order();
        order.setOrderId(orderId);
        order.setAddress(orderAddress);
        orderStorage.addOrder(order);
        return order;
    }

    public void addProductToOrder(Long orderId, Product product, int quantity) {
        Order order = orderStorage.getOrder(orderId);
        if (order != null) {
            order.addProduct(product, quantity, productsStorage);
        } else {
            System.out.println("Error: Order with ID " + orderId + " does not exist.");
        }
    }

    public void removeProductFromOrder(Long orderId, Product product) {
        Order order = orderStorage.getOrder(orderId);
        if (order != null) {
            order.removeProduct(product);
        } else {
            System.out.println("Error: Order with ID " + orderId + " does not exist.");
        }
    }

    public Map<Product, Integer> getProductsInOrder(Long orderId) {
        Order order = orderStorage.getOrder(orderId);
        if (order != null) {
            return order.getProducts();
        } else {
            System.out.println("Error: Order with ID " + orderId + " does not exist.");
            return new HashMap<>();
        }
    }

    public OrderStorage getOrderStorage() {
        return orderStorage;
    }

    public ProductsStorage getProductsStorage() {
        return productsStorage;
    }
}
