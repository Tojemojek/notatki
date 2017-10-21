package pl.sda.javawwa.sklepik.builder;

import pl.sda.javawwa.sklepik.domain.Money;
import pl.sda.javawwa.sklepik.domain.Product;

public class ProductBuilder {

    private int id;
    private String name;
    private Money price;

    private Product.ProductState productState;
    private Product.ProductType productType;


    public ProductBuilder id(int id) {
        this.id = id;
        return this;
    }

    public ProductBuilder name(String name) {
        this.name = name;
        return this;
    }

    public ProductBuilder price(Money price) {
        this.price = price;
        return this;
    }

    public ProductBuilder productState(Product.ProductState productState) {
        this.productState = productState;
        return this;
    }

    public ProductBuilder productType(Product.ProductType productType) {
        this.productType = productType;
        return this;
    }

    public Product build() {
        Product productTmp = new Product(name, price, productType);
        return productTmp;
    }
}