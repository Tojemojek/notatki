package pl.sda.javawwa.sklepik.domain;

import pl.sda.javawwa.sklepik.exception.OrderStateException;
import pl.sda.javawwa.sklepik.state.OrderState;
import pl.sda.javawwa.sklepik.strategy.RebateStrategy;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private int orderID;
    //enum
    private State state;
    private List<OrderItem> items;
    private Client client;
    private RebateStrategy rebateStrategy;
    //interface dla state pattern
    private OrderState orderState;

    public enum State {
        DRAFT, PAID, CONFIRMED, DELIVERED
    }

    public Order(int orderID, Client client, State type) {
        this.orderID = orderID;
        this.state = type;
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
        Money tmpCurrentCost = new Money("0.00");

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

    public void confirm() throws OrderStateException{
        orderState.confirm(this);
    }

    public void pay() throws OrderStateException{
        orderState.pay(this);
    }

    public void ship() throws OrderStateException{
        orderState.ship(this);
    }


    public OrderState getOrderState() {
        return orderState;
    }

    public void setOrderState(OrderState orderState) {
        this.orderState = orderState;
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }


}