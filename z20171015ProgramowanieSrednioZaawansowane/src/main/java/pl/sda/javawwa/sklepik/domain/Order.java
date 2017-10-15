package pl.sda.javawwa.sklepik.domain;

import pl.sda.javawwa.sklepik.strategy.RebateStrategy;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Order {

    private int orderID;
    private OrderType type;
    private List<OrderItem> items;
    private Client client;
    private RebateStrategy rebateStrategy;


    public enum OrderType {
        DRAFT, PAID, CONFIRMED
    }

    public Order(int orderID, Client client, OrderType type) {
        this.orderID = orderID;
        this.type = type;
        this.client = client;
    }

    public void setRebateStrategy(RebateStrategy rebateStrategy) {
        this.rebateStrategy = rebateStrategy;
    }

    public void addProduct(Product product, int quantity) {

        if (items == null) {
            items = new ArrayList<>();
        }
        //ToDo powinno się sprawdzać czy produkt taki nie jest już włożony do koszyka.
        OrderItem orderItem = new OrderItem(product, quantity);

        items.add(orderItem);
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public int getOrderID() {
        return orderID;
    }

    public Client getClient() {
        return client;
    }

    public Money getCurrentCost() {
        Money tmpCurrentCost = new Money(BigDecimal.ZERO);

        for (OrderItem item : items) {
            tmpCurrentCost = tmpCurrentCost.add(item.getCost());
        }

        return tmpCurrentCost;
    }

    public Money getTotalCost(){
        Money currentCost = getCurrentCost();
        Money rebate = rebateStrategy.calculateRebate(this);
        Money totalCost = currentCost.subtract(rebate);
        return  totalCost;
    }

}