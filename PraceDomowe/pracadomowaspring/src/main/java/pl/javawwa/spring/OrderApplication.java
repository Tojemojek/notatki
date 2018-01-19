package pl.javawwa.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pl.javawwa.spring.entities.OrderService;
import pl.javawwa.spring.entities.implementations.OrderDaoImpl;
import pl.javawwa.spring.entities.implementations.OrderServiceImpl;

public class OrderApplication {

    public static void main(String[] args) {

        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext(
                        new String[]{"pl/javawwa/spring/beans.xml"});

        OrderDaoImpl orderDao = (OrderDaoImpl) applicationContext.getBean("orderDaoImplBeanXml");
        OrderServiceImpl orderService = (OrderServiceImpl) applicationContext.getBean("orderServiceImplBean");

        System.out.println(orderDao.toString());
        System.out.println(orderService);

    }
}