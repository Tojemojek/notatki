package pl.javawwa.spring.entities.implementations;

import pl.javawwa.spring.entities.Order;
import pl.javawwa.spring.entities.OrderDao;

import java.util.LinkedList;
import java.util.List;

public class OrderDaoImpl implements OrderDao {

    List<Order> orders = new LinkedList<>();

    {
        orders.add(new Order(1));
        orders.add(new Order(2));
        orders.add(new Order(3));
        orders.add(new Order(5));
    }

    public OrderDaoImpl() {
    }

    public OrderDaoImpl(List<Order> orders) {
        this.orders = orders;
    }


    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public List<Order> getAllOrders() {
        return orders;
    }

    @Override
    public String toString() {
        return "OrderDaoImpl{" +
                "orders=" + orders +
                '}';
    }


    public void initIt() throws Exception {
        System.out.println("Bean OrderDaoImpl został utworzony");
    }

    public void cleanUp() throws Exception {
        System.out.println("Bean OrderDaoImpl został zniszczony");
    }

}
