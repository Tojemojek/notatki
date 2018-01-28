package pl.javawwa.odersapp.converters;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.javawwa.odersapp.dto.CustomerDto;
import pl.javawwa.odersapp.entities.Customer;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerConverterImplTest {

    @Autowired
    private CustomerConverter converter;

    @Test
    public void convert() {

            CustomerDto customerDto =
                    new CustomerDto(null,"K","O","cos@mailinator.com","coskolwiek","testPassword",null);

        Customer converted = converter.convert(customerDto);

        System.out.println(customerDto);
        System.out.println(converted);

        Assert.assertEquals("fed3b61b26081849378080b34e693d2e",converted.getPassword());

    }

}