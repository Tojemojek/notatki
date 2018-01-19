package pl.javawwa.spring;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.javawwa.spring.entities.implementations.OrderDaoImpl;
import pl.javawwa.spring.entities.implementations.OrderServiceImpl;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:pl/javawwa/spring/beans.xml")

public class OrderApplicationTests {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void shouldLoadContext() {

        Assert.assertNotNull(applicationContext.getBean("orderDaoImplBeanXml"));
        Assert.assertNotNull(applicationContext.getBean("orderServiceImplBean"));
    }

    @Test
    public void shouldTestListLenght() {

        OrderDaoImpl orderDao = (OrderDaoImpl) applicationContext.getBean("orderDaoImplBeanXml");
        OrderServiceImpl orderService = (OrderServiceImpl) applicationContext.getBean("orderServiceImplBean");

        Assert.assertEquals(4,orderDao.getAllOrders().size());
        Assert.assertEquals(4,orderService.getAllOrders().size());

    }


}
