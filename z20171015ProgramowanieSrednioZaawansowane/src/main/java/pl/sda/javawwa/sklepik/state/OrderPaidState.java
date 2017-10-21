package pl.sda.javawwa.sklepik.state;

import pl.sda.javawwa.sklepik.domain.Order;
import pl.sda.javawwa.sklepik.exception.OrderStateException;

public class OrderPaidState implements OrderState{

    @Override
    public void confirm(Order order) throws OrderStateException {
        throw new OrderStateException("Paid order can't be confirmed");
    }

    @Override
    public void pay(Order order)throws OrderStateException {
        throw new OrderStateException("Paid order can't be paid again.");
    }

    @Override
    public void ship(Order order){
        System.out.println("Shipping your order.");
        order.setState(Order.State.DELIVERED);
    }
}
