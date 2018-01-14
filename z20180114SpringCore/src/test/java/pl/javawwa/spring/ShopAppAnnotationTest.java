package pl.javawwa.spring;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:pl/javawwa/spring/applicationShopContext.xml")
public class ShopAppAnnotationTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void shouldLoadContext() {

        Assert.assertNotNull(applicationContext.getBean("shop"));
        Assert.assertNotNull(applicationContext.getBean("shopBasket1"));

    }


}