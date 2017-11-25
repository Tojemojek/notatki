package pl.sda.javawwa.hibernate.dao;

import pl.sda.javawwa.hibernate.entity.Client;
import pl.sda.javawwa.hibernate.entity.Order;

public interface OrderDao {

    public Order findById(Integer id);

    public void save(Order order);


}
