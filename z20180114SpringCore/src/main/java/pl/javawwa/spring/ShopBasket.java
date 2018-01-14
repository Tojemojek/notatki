package pl.javawwa.spring;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component(value = "shopBasket1")
public class ShopBasket implements InitializingBean, DisposableBean {

    private int quantity = 0;
    private String message;

    @Override
    public void destroy() throws Exception {
        System.out.println("Bean umiera");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Random random = new Random();
        System.out.println("Quantity before initialize " + quantity);
        quantity = random.nextInt();
        System.out.println("Quantity after initialize " + quantity);
    }
}
