package pl.sda.javawwa.orders.dao;

import pl.sda.javawwa.orders.entieties.Client;

public interface ClientDao {

    public Client findById(Integer id);

    public void insert(Client client);

    public void update(Client client);

    public void delete(Integer clientID);

}
