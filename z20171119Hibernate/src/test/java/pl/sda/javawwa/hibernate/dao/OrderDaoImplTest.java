package pl.sda.javawwa.hibernate.dao;

import org.apache.log4j.Logger;
import org.junit.Test;
import pl.sda.javawwa.hibernate.entity.*;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.*;

public class OrderDaoImplTest {



    private Logger logger = Logger.getLogger(OrderDaoImplTest.class);

    @Test
    public void shouldFindById() throws Exception {
        OrderDao orderDao = new OrderDaoImpl();
        Order order = orderDao.findById(8);
        logger.info(order);

    }

    @Test
    public void shouldFindByIdWithOrderItems() throws Exception {
        OrderDao orderDao = new OrderDaoImpl();
        Order order = orderDao.findById(8);

        if (order.getOrderItems() != null) {
            for (OrderItem item : order.getOrderItems()){
                logger.info(item.getProduct() + " " + item.getQuantity());
            }
        }
    }


    @Test
    public void shouldSaveOrder() throws Exception {

        OrderDao orderDao = new OrderDaoImpl();
        ClientDao clientDao = new ClientDaoImpl();
        ProductDao productDao = new ProductDaoImpl();

        Client client = clientDao.findById(2);

        Order order = new Order(client,new Date(), null, OrderStatus.PAID, new BigDecimal("0.0"));

        Product prod1 = productDao.findById(1);
        Product prod2 = productDao.findById(2);
        Product prod3 = productDao.findById(3);

        order.addItem(prod1, 3);
        order.addItem(prod2, 4);
        order.addItem(prod3, 8);

        orderDao.save(order);

        logger.info(order);
    }
}

//todo zrobić te testy z h2
//https://github.com/Apress/beg-hibernate-4ed

