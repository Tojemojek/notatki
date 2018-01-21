package pl.kostrowski.spring.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.kostrowski.spring.asserts.ProductAssert;
import pl.kostrowski.spring.entity.Product;
import pl.kostrowski.spring.entity.ProductType;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductRepositoryTest {

    @Autowired
    ProductRepository productRepository;

    @Test
    public void shoudFindProductById() {

        Product one = productRepository.findOne(1);

        new ProductAssert(one).hasName("Jabko").hasQuantity(10).hasType(ProductType.FOOD);

    }

    @Test
    public void shouldFindAllProducts() {

        List<Product> all = (List<Product>) productRepository.findAll();

        Assert.assertEquals(2, all.size());

    }

    @Test
    public void shouldSaveProduct() {

        Product prod3 = new Product(3, "Ajfon", ProductType.ELECTRONICS, 3);

        productRepository.save(prod3);

        List<Product> all = (List<Product>) productRepository.findAll();

        Assert.assertEquals(3, all.size());
    }

    @Test
    public void shouldFindProductByName() {

        List<Product> ajfon = productRepository.findByName("Ajfon");

        Assert.assertEquals(0, ajfon.size());
    }




}