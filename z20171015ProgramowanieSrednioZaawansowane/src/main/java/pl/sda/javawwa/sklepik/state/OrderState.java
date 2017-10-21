package pl.sda.javawwa.sklepik.state;

import pl.sda.javawwa.sklepik.domain.Order;
import pl.sda.javawwa.sklepik.exception.OrderStateException;

public interface OrderState {

    public void confirm(Order order) throws OrderStateException;

    public void pay(Order order) throws OrderStateException;

    public void ship(Order order) throws OrderStateException;


}
