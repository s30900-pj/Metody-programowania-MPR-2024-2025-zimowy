package pl.edu.pjwstk.s30900.s30900OrderService;

import org.springframework.stereotype.Component;

@Component
public class Product {
    private Long productId;
    private String name;
    private double basicPrice;

    public Product(Long id, String name, double basicPrice) {
        this.productId = id;
        this.name = name;
        this.basicPrice = basicPrice;
    }

    public Product() {

    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBasicPrice() {
        return basicPrice;
    }

    public void setBasicPrice(double basicPrice) {
        this.basicPrice = basicPrice;
    }
}
