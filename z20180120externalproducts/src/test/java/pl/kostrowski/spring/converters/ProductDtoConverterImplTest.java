package pl.kostrowski.spring.converters;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.kostrowski.spring.dto.ProductDto;
import pl.kostrowski.spring.entity.Product;
import pl.kostrowski.spring.entity.ProductType;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductDtoConverterImplTest {

    @Autowired
    private ProductDtoConverter productDtoConverter;

    @Test
    public void shopuldConvertProductDroProperly() {

        Product prod1 = new Product(6 ,"Jabol", ProductType.DRINK, 3);

        ProductDto converted = productDtoConverter.convert(prod1);

        //todo stworzyć obiekt Assert Equals dla tego obiektu



    }
}