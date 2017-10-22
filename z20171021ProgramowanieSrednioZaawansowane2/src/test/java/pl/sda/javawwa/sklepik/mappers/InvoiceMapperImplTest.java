package pl.sda.javawwa.sklepik.mappers;

import org.junit.Assert;
import org.junit.Test;
import pl.sda.javawwa.sklepik.builder.ClientBuilder;
import pl.sda.javawwa.sklepik.builder.ProductBuilder;
import pl.sda.javawwa.sklepik.domain.*;
import pl.sda.javawwa.sklepik.factory.OrderFactory;
import pl.sda.javawwa.sklepik.strategy.FoodRebateStrategy;
import pl.sda.javawwa.sklepik.strategy.PercentageRebateStrategy;
import pl.sda.javawwa.sklepik.strategy.RebateStrategy;

public class InvoiceMapperImplTest {

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

    @Test
    public void shouldMapOrderToInvoice() {
        Order order = createOrderForRegularClientWithBuilders(new PercentageRebateStrategy());

        InvoiceMapper invoiceMapper = new InvoiceMapperImpl();

        Invoice invoice = invoiceMapper.map(order);

        Assert.assertEquals("Powinny być takie same nr zamówienia",
                 1,invoice.getOrderId());
    }

    @Test
    public void shouldMapOrderToInvoiceAdd3Items() {
        Order order = createOrderForRegularClientWithBuilders(new PercentageRebateStrategy());
        int realSize = order.getItems().size();


        Assert.assertEquals("Powinny być takie same ilości pozycji zamówienia",
                3,realSize);
    }

}