package pl.kostrowski.spring.dto;

import pl.kostrowski.spring.entity.ProductType;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;

public class ProductDto {

    private Integer id;
    private String name;
    private String productType;
    private Integer quantity;

    public ProductDto() {
    }

    public ProductDto(Integer id, String name, String productType, Integer quantity) {
        this.id = id;
        this.name = name;
        this.productType = productType;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
