package pl.javawwa.spring.asserts;

import org.junit.Assert;
import pl.javawwa.spring.entity.Product;
import pl.javawwa.spring.entity.ProductType;

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
