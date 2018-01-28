package pl.javawwa.odersapp.converters;


import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;
import pl.javawwa.odersapp.entities.Customer;
import pl.javawwa.odersapp.dto.CustomerDto;

import java.util.UUID;

@Component
public class CustomerConverterImpl implements CustomerConverter {


    @Override
    public Customer convert(CustomerDto customerDto) {

        Customer result = new Customer();
        result.setId(customerDto.getId());
        result.setFirstName(customerDto.getFirstName());
        result.setSurname(customerDto.getSurname());
        result.setEmail(customerDto.getEmail());
        result.setLogin(customerDto.getLogin());
        result.setPassword(DigestUtils.md5Hex(customerDto.getPassword()));
        result.setToken(UUID.randomUUID().toString());

        return result;
    }

    @Override
    public CustomerDto convert(Customer customer) {
        return null;
    }
}
