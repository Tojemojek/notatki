package pl.javawwa.odersapp.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.javawwa.odersapp.entities.Customer;
import pl.javawwa.odersapp.entities.CustomerStatus;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

    public Customer findOneByLoginAndTokenAndStatus(String login, String token, CustomerStatus status);

    public Customer findOneByLoginAndPasswordAndStatus(String login, String password, CustomerStatus status);

}
