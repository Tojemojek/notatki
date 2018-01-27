package pl.javawwa.spring.converters;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.javawwa.spring.dto.ProductDto;
import pl.javawwa.spring.entity.Product;
import pl.javawwa.spring.entity.ProductType;

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