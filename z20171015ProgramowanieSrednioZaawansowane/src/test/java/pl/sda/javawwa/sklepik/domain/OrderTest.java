package pl.sda.javawwa.sklepik.domain;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.sda.javawwa.sklepik.factory.OrderFactory;

import java.math.BigDecimal;
import java.util.List;

public class OrderTest {

    @Before
    public void initialize() {

    }

    @Test
    public void shouldAddThreeOrderItems() throws Exception {

        //GIVEN
        OrderFactory orderFactory = new OrderFactory();
        Client klient = new Client("K", "O", "tojemoje", Client.ClientType.VIP);
        Order order = orderFactory.createOrder(1, klient);
        Product product1 = new Product("Winiacz", new Money(BigDecimal.valueOf(3.20)), Product.ProductType.DRINK);
        Product product2 = new Product("Chipsy", new Money(BigDecimal.valueOf(9.32)), Product.ProductType.FOOD);


        //When
        order.addProduct(product1, 5);
        order.addProduct(product2, 2);

        //Then
        List<OrderItem> items = order.getItems();

        Product expectedProduct1 = new Product("Chipsy", new Money(BigDecimal.valueOf(9.32)), Product.ProductType.FOOD);
        Product expectedProduct2 = new Product("Chipsdfy", new Money(BigDecimal.valueOf(9.32)), Product.ProductType.FOOD);

        boolean conditionShouldBeTrue = false;
        boolean conditionShouldBeFalse = false;

        for (OrderItem item : items) {
            if (item.getProduct().equals(expectedProduct1)) {
                conditionShouldBeTrue = true;
            }
        }

        for (OrderItem item : items) {
            if (item.getProduct().equals(expectedProduct2)) {
                conditionShouldBeFalse = true;
            }
        }

        Assert.assertTrue(conditionShouldBeTrue);
        Assert.assertFalse(conditionShouldBeFalse);

    }

    @Test
    public void isCurrentCostCorrect() throws Exception {

        //GIVEN
        OrderFactory orderFactory = new OrderFactory();
        Client klient = new Client("K", "O", "tojemoje", Client.ClientType.VIP);
        Order order = orderFactory.createOrder(1, klient);
        Product product1 = new Product("Winiacz", new Money(BigDecimal.valueOf(3.20)), Product.ProductType.DRINK);
        Product product2 = new Product("Chipsy", new Money(BigDecimal.valueOf(9.32)), Product.ProductType.FOOD);
        order.addProduct(product1, 5);
        order.addProduct(product2, 3);

        //When
        Money calculatedValue = order.getCurrentCost();

        Double expectedValue = 5 * 3.20 + 3 * 9.32;

        Money expectedValueMoney = new Money(expectedValue);

        //Then
        Assert.assertTrue("Current cost should be same", expectedValueMoney.equals(calculatedValue));

    }

    @Test
    public void isCurrentRabateCorrect() throws Exception {

        //GIVEN
        OrderFactory orderFactory = new OrderFactory();
        Client klient = new Client("K", "O", "tojemoje", Client.ClientType.VIP);
        Order order = orderFactory.createOrder(1, klient);

        Product product1 = new Product("Winiacz", new Money(BigDecimal.valueOf(3.20)), Product.ProductType.DRINK);
        Product product2 = new Product("Chipsy", new Money(BigDecimal.valueOf(9.32)), Product.ProductType.FOOD);

        order.addProduct(product1, 5);
        order.addProduct(product2, 3);


        //When

        Money calculatedValue = order.getTotalCost();

        Double expectedValue = (5 * 3.20 + 3 * 9.32) - (5 * 3.20 + 3 * 9.32) * 0.1;

        Money expectedValueMoney = new Money(expectedValue);

        System.out.println("Ile oczekuje: " + expectedValueMoney.getValue());
        System.out.println("Ile jest: " + calculatedValue.getValue());


        //Then
        Assert.assertTrue("Current cost should be same", expectedValueMoney.equals(calculatedValue));

    }


}