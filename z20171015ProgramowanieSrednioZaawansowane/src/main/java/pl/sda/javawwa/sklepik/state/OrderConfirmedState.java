package pl.sda.javawwa.sklepik.state;

import pl.sda.javawwa.sklepik.domain.Order;
import pl.sda.javawwa.sklepik.exception.OrderStateException;

public class OrderConfirmedState implements OrderState{

    @Override
    public void confirm(Order order) throws OrderStateException {
        throw new OrderStateException("Confirmed order can't be confirmed again");
    }

    @Override
    public void pay(Order order) {
        System.out.println("Confirming your payment.");
        order.setState(Order.State.PAID);
        order.setOrderState(new OrderPaidState());
    }

    @Override
    public void ship(Order order) throws OrderStateException {
        throw new OrderStateException("Confirmed order can't be shipped");
    }
}
