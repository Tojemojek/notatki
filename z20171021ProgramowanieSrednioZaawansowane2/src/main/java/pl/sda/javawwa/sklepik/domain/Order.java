package pl.sda.javawwa.sklepik.domain;

import pl.sda.javawwa.sklepik.exception.OrderStateException;
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

    public Money getTotalCost() {
        Money currentCost = getCurrentCost();
        Money rebate = rebateStrategy.calculateRebate(this);
        Money totalCost = currentCost.subtract(rebate);
        return totalCost;
    }


    public void confirm() throws OrderStateException {
        if (this.state.equals(State.DRAFT)) {
            System.out.println("Zatwierdzam...");
            this.state = State.CONFIRMED;
        } else if (this.state.equals(State.CONFIRMED)) {
            throw new OrderStateException("Confirmed order can't be confirmed again");
        }

    }

    public void pay() throws OrderStateException {
        if (this.state.equals(State.DRAFT) || this.state.equals(State.CONFIRMED)) {
            System.out.println("Płacę...");
            this.state = State.PAID;
        } else if (this.state.equals(State.PAID)) {
            throw new OrderStateException("Paid order can't be paid again.");
        }
    }

    public void ship() throws OrderStateException {
        if (this.state.equals(State.DRAFT) || this.state.equals(State.CONFIRMED)) {
            throw new OrderStateException("Draft or confirmed orders cant be shipped.");
        } else if (this.state.equals(State.PAID)) {
            System.out.println("Dostarczam...");
            this.state = State.DELIVERED;
        } else if (this.state.equals(State.DELIVERED)) {
            throw new OrderStateException("Order already delivered");
        }
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }


}