package pl.sda.javawwa.orders.dao;

import pl.sda.javawwa.orders.entieties.Order;

public interface OrderDao {

    public void insertOrder(Order order);

     public Order findById(Integer id);

}
