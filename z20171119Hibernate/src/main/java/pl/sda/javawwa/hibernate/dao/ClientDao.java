package pl.sda.javawwa.hibernate.dao;

import pl.sda.javawwa.hibernate.entity.Client;

public interface ClientDao {

    public Client findById(Integer id);

    public void save(Client client);

    public void delete(Integer clientId);

    public void update(Client client);




}
