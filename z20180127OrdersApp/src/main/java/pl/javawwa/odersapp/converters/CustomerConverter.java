package pl.javawwa.odersapp.converters;

import pl.javawwa.odersapp.dto.CustomerDto;
import pl.javawwa.odersapp.entities.Customer;

public interface CustomerConverter {

    public Customer convert(CustomerDto customerDto);
    public CustomerDto convert(Customer customer);

}
