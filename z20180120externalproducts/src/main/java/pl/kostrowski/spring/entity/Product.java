package pl.kostrowski.spring.entity;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity
public class Product {

    @Id
    private Integer id;

    private String name;

    @Enumerated
    private ProductType productType;

    private Integer quantity;

    public Product() {
    }

    public Product(Integer id, String name, ProductType productType, Integer quantity) {
        this.id = id;
        this.name = name;
        this.productType = productType;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ProductType getProductType() {
        return productType;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
