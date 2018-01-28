package pl.javawwa.odersapp.services;

import pl.javawwa.odersapp.dto.CustomerDto;

public interface CustomerService {

    public void registerUser(CustomerDto customerDto);

    public Boolean activateUser(String login, String token);

    public boolean authenticate(String login, String password);

}