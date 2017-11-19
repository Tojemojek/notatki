package pl.sda.javawwa.hibernate.dao;

import pl.sda.javawwa.hibernate.entity.Client;

public interface ClientDao {

    public Client findById(Integer id);


}
