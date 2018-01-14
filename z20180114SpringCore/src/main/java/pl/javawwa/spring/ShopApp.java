package pl.javawwa.spring;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ShopApp {

    public static void main(String[] args) {

        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext(
                        new String[]{"pl/javawwa/spring/applicationShopContext.xml"});

        Shop shop = (Shop) applicationContext.getBean("shop");

        System.out.println(shop.getName());

    }
}