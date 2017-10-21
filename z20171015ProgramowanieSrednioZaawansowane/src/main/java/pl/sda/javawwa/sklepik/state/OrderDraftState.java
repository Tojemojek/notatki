package pl.sda.javawwa.sklepik.state;

import pl.sda.javawwa.sklepik.domain.Order;
import pl.sda.javawwa.sklepik.exception.OrderStateException;

public class OrderDraftState implements OrderState{

    @Override
    public void confirm(Order order) {
        System.out.println("Confirming your order.");
        order.setState(Order.State.CONFIRMED);
        order.setOrderState(new OrderConfirmedState());
    }

    @Override
    public void pay(Order order) {
        System.out.println("Confirming your order and payment.");
        order.setState(Order.State.PAID);
        order.setOrderState(new OrderPaidState());
    }

    @Override
    public void ship(Order order) throws OrderStateException {
        throw new OrderStateException("Draft order can't be shipped");
    }
}
