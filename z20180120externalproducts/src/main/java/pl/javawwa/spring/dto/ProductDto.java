package pl.javawwa.spring.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ProductDto {

    private Integer id;

    @NotNull
    @Size(min = 3, max = 10)
    private String name;

    private String productType;

    @NotNull
    @Min(0)
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
