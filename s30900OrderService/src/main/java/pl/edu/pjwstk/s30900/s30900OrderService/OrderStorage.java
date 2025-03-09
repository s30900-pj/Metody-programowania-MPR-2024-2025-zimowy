package pl.edu.pjwstk.s30900.s30900OrderService;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component

public class OrderStorage {
    private List<Order> orders;

    public OrderStorage() {
        this.orders = new ArrayList<>();
    }

    public Order getOrder(Long orderId) {
        for (Order order : orders) {
            if (Objects.equals(order.getOrderId(), orderId)) {
                return order;
            }
        }
        return null;
    }
    public void addOrder(Order order) {
        orders.add(order);
    }

    public void removeOrder(Long orderId) {
        orders.removeIf(order -> Objects.equals(order.getOrderId(), orderId));
    }

    public void clear() {
        orders.clear();
    }
}
