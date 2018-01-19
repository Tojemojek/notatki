package pl.javawwa.spring.entities.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.javawwa.spring.entities.Order;
import pl.javawwa.spring.entities.OrderService;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

@Component(value = "orderServiceImplBean")
public class OrderServiceImpl implements OrderService {


    private OrderDaoImpl orderDao;

    @Autowired
    public OrderServiceImpl(OrderDaoImpl orderDao) {
        this.orderDao = orderDao;
    }

    @Override
    public List<Order> getAllOrders() {
        return orderDao.getAllOrders();
    }

    @PostConstruct
    public void initIt() throws Exception {
        System.out.println("Bean OrderServiceDaoImpl został utworzony");
    }

    @PreDestroy
    public void cleanUp() throws Exception {
        System.out.println("Bean OrderServiceDaoImpl został zniszczony");
    }

}
