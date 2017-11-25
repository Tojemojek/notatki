package pl.sda.javawwa.orders.dao;

import org.junit.Test;
import pl.sda.javawwa.orders.entieties.Order;
import pl.sda.javawwa.orders.entieties.OrderStatus;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.*;

public class OrderDaoImplTest {

    @Test
    public void shouldInsertOrder() throws Exception{
        OrderDao orderDao = new OrderDaoImpl();
        Date currentTime = new Date();
        Order order = new Order(2,currentTime,null, OrderStatus.NEW,new BigDecimal("2.20"));

        order.addItem(1,2);
        order.addItem(2,3);

        orderDao.insertOrder(order);

    }

    @Test
    public void shouldFindOrderById() throws Exception{

        OrderDao orderDao = new OrderDaoImpl();
        Order order = orderDao.findById(4);

    }


}