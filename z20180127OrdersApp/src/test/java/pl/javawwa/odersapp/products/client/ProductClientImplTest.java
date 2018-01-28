package pl.javawwa.odersapp.products.client;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductClientImplTest {

    @Autowired
    ProductClient productClient;

    @Test
    public void findAll() {
        List<ProductDto> all = productClient.findAll();
        System.out.println(all.size());

        Assert.assertTrue(all.size() > 90);
    }

    @Test
    public void findById() {
        ProductDto productDto = productClient.findById(1);
        Assert.assertNotNull(productDto);
        System.out.println(productDto);
    }
}