package pl.sda.javawwa.sklepik.domain;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.sda.javawwa.sklepik.builder.ClientBuilder;
import pl.sda.javawwa.sklepik.builder.ProductBuilder;
import pl.sda.javawwa.sklepik.exception.OrderStateException;
import pl.sda.javawwa.sklepik.factory.OrderFactory;
import pl.sda.javawwa.sklepik.state.OrderConfirmedState;
import pl.sda.javawwa.sklepik.strategy.FoodRebateStrategy;
import pl.sda.javawwa.sklepik.strategy.RebateStrategy;
import pl.sda.javawwa.sklepik.strategy.VipRebateStrategy;

import java.util.List;

import static org.junit.Assert.fail;

public class OrderTest {

    //wszystkie system.out.println są całkowicie zbędne
    //to jest tylko dla mnie w celu edukacyjnym

    private Order createOrderForRegularClientWithBuilders(RebateStrategy rebateStrategy) {

        Client klient = new ClientBuilder()
                .firstName("Krz")
                .secondName("Ostr")
                .type(Client.ClientType.REGULAR)
                .build();

        Order order = new OrderFactory().createOrder(1, klient, new FoodRebateStrategy());

        Product product1 = new ProductBuilder()
                .name("Winiacz")
                .price(new Money("3.20"))
                .productType(Product.ProductType.DRINK)
                .build();

        Product product2 = new ProductBuilder()
                .name("Chipsy")
                .price(new Money("9.32"))
                .productType(Product.ProductType.FOOD)
                .build();

        Product product3 = new ProductBuilder()
                .name("Masło")
                .price(new Money("10.15"))
                .productType(Product.ProductType.FOOD)
                .build();

        //When
        order.addProduct(product1, 5);
        order.addProduct(product2, 2);
        order.addProduct(product3, 3);


        return order;
    }


    private Order createOrderForRegularClient() {
        //GIVEN
        OrderFactory orderFactory = new OrderFactory();
        Client klient = new Client("K", "O", "tojemoje", Client.ClientType.REGULAR);
        Order order = orderFactory.createOrder(1, klient);
        Product product1 = new Product("Winiacz", new Money("3.20"), Product.ProductType.DRINK);
        Product product2 = new Product("Chipsy", new Money("9.32"), Product.ProductType.FOOD);

        //When
        order.addProduct(product1, 5);
        order.addProduct(product2, 2);

        return order;
    }

    private Order createOrderForVipClient() {
        //GIVEN
        OrderFactory orderFactory = new OrderFactory();
        Client klient = new Client("K", "O", "tojemoje", Client.ClientType.VIP);
        Order order = orderFactory.createOrder(1, klient, new VipRebateStrategy());
        Product product1 = new Product("Winiacz", new Money("3.20"), Product.ProductType.DRINK);
        Product product2 = new Product("Chipsy", new Money("9.32"), Product.ProductType.FOOD);

        //When
        order.addProduct(product1, 5);
        order.addProduct(product2, 2);

        return order;
    }


    @Before
    public void initialize() {

    }

    @Test
    public void shouldAddThreeOrderItems() throws Exception {

        Order order = createOrderForRegularClient();

        //Then
        List<OrderItem> items = order.getItems();

        Product expectedProduct1 = new Product("Chipsy", new Money("9.32"), Product.ProductType.FOOD);
        Product expectedProduct2 = new Product("Chipsdfy", new Money("9.32"), Product.ProductType.FOOD);

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

        Order order = createOrderForRegularClient();

        //When
        Money calculatedValue = order.getCurrentCost();

        Double expectedValue = (5 * 3.20 + 2 * 9.32);

        Money expectedValueMoney = new Money(expectedValue.toString());

        System.out.println("Ile oczekuje: " + expectedValueMoney.getValue());
        System.out.println("Ile jest: " + calculatedValue.getValue());

        //Then
        Assert.assertTrue("Current cost should be same", expectedValueMoney.equals(calculatedValue));

    }

    @Test
    public void isCurrentRabateInPercentCorrect() throws Exception {

        Order order = createOrderForRegularClient();

        //When

        Money calculatedValue = order.getTotalCost();

        Double expectedValue = (5 * 3.20 + 2 * 9.32) - (5 * 3.20 + 2 * 9.32) * 0.1;

        Money expectedValueMoney = new Money(expectedValue.toString());

        System.out.println("Ile oczekuje: " + expectedValueMoney.getValue());
        System.out.println("Ile jest: " + calculatedValue.getValue());


        //Then
        Assert.assertTrue("Current cost should be same", expectedValueMoney.equals(calculatedValue));

    }

    @Test
    public void isCurrentRabateForVipCorrect() throws Exception {

        Order order = createOrderForVipClient();

        //When

        Money calculatedValue = order.getTotalCost();

        Double expectedValue = (5 * 3.20 + 2 * 9.32) - 1;

        Money expectedValueMoney = new Money(expectedValue.toString());

        System.out.println("Ile oczekuje: " + expectedValueMoney.getValue());
        System.out.println("Ile jest: " + calculatedValue.getValue());

        //Then
        Assert.assertTrue("Current cost should be same", expectedValueMoney.equals(calculatedValue));

    }

    @Test
    public void isCurrentRabateForFoodCorrect() throws Exception {

        Order order = createOrderForRegularClientWithBuilders(new FoodRebateStrategy());

        //When

        Money calculatedValue = order.getTotalCost();

        Money expectedValuePart1 = new Money("3.20").multiplyBy(5);
        Money expectedValuePart2 = new Money("9.32").multiplyBy(2);
        Money expectedValuePart3 = new Money("10.15").multiplyBy(3);

        Money discount2 = expectedValuePart2.multiplyBy(0.15);
        Money discount3 = expectedValuePart3.multiplyBy(0.15);

        Money expectedValueMoney = expectedValuePart1
                .add(expectedValuePart2)
                .add(expectedValuePart3)
                .subtract(discount2)
                .subtract(discount3);

        System.out.println("Ile oczekuje: " + expectedValueMoney.getValue());
        System.out.println("Ile jest: " + calculatedValue.getValue());

        //Then
        Assert.assertTrue("Current cost should be same", expectedValueMoney.equals(calculatedValue));

    }


    @Test
    public void shouldConfirmOrderInDraftState() throws OrderStateException {

        Order order = createOrderForRegularClientWithBuilders(new FoodRebateStrategy());

        order.confirm();

        Assert.assertEquals(order.getState(), Order.State.CONFIRMED);
        Assert.assertTrue(order.getOrderState() instanceof OrderConfirmedState);

    }

    @Test(expected = OrderStateException.class)
    public void shouldConfirmOrderInConfirmedState() throws OrderStateException {

        Order order = createOrderForRegularClientWithBuilders(new FoodRebateStrategy());

        order.confirm();

        order.confirm();

    }

    @Test
    public void shouldConfirmOrderInConfirmedState2() {

        Order order = createOrderForRegularClientWithBuilders(new FoodRebateStrategy());

        try {
            order.confirm();
        } catch (OrderStateException e) {
            e.printStackTrace();
        }

        try {
            order.confirm();
            fail("Exception should be thrown");
        } catch (Exception e) {
            Assert.assertTrue(e instanceof OrderStateException);
            Assert.assertTrue(e.getMessage().equals("Confirmed order can't be confirmed again"));

        }

    }

    @Test(expected = OrderStateException.class)
    public void shouldShipOrderInDraftState() throws OrderStateException {

        Order order = createOrderForRegularClientWithBuilders(new FoodRebateStrategy());

        order.ship();
    }

    @Test
    public void shouldPayForConfirmed() throws OrderStateException {

        Order order = createOrderForRegularClientWithBuilders(new FoodRebateStrategy());

        order.confirm();

        order.pay();

        Assert.assertTrue(order.getState().equals(Order.State.PAID));

    }
}