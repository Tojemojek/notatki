package pl.kostrowski.spring.asserts;

import org.junit.Assert;
import pl.kostrowski.spring.entity.Product;
import pl.kostrowski.spring.entity.ProductType;

public class ProductAssert {

    private Product product;

    public ProductAssert(Product product) {
        this.product = product;
    }

    public ProductAssert hasName(String name) {
        Assert.assertEquals(product.getName(), name);
        return this;
    }

    public ProductAssert hasQuantity(Integer quantity) {
        Assert.assertEquals(product.getQuantity(), quantity);
        return this;
    }

    public ProductAssert hasType(ProductType productType) {
        Assert.assertEquals(product.getProductType(), productType);
        return this;
    }

}
