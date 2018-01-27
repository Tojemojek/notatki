package pl.javawwa.spring.entity;

import javax.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @Enumerated(EnumType.STRING)
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

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
