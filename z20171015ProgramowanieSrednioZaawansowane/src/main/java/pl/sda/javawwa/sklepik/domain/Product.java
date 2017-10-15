package pl.sda.javawwa.sklepik.domain;

public class Product {

    private int id;
    private String name;
    private Money price;

    private ProductState productState;
    private ProductType productType;

    public Product(String name, Money price, ProductType productType) {
        this.name = name;
        this.price = price;
        this.productType = productType;
    }

    public enum ProductState{
        AVAILABLE,EXPIRED;
    }

    public enum ProductType{
        FOOD,DRINK,ELECTRONICS;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Money getPrice() {
        return price;
    }

    public void setPrice(Money price) {
        this.price = price;
    }

    public ProductState getProductState() {
        return productState;
    }

    public void setProductState(ProductState productState) {
        this.productState = productState;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (name != null ? !name.equals(product.name) : product.name != null) return false;
        if (price != null ? !price.equals(product.price) : product.price != null) return false;
        return productType == product.productType;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (productType != null ? productType.hashCode() : 0);
        return result;
    }
}
