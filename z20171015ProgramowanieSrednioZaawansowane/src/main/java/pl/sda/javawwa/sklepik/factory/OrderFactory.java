package pl.sda.javawwa.sklepik.factory;

import pl.sda.javawwa.sklepik.domain.Client;
import pl.sda.javawwa.sklepik.domain.Order;
import pl.sda.javawwa.sklepik.state.OrderDraftState;
import pl.sda.javawwa.sklepik.strategy.PercentageRebateStrategy;
import pl.sda.javawwa.sklepik.strategy.RebateStrategy;

public class OrderFactory {

    public Order createOrder(int orderId, Client client) {
        Order order = new Order(orderId, client, Order.State.DRAFT);
        order.setOrderState(new OrderDraftState());
        RebateStrategy rebateStrategy = new PercentageRebateStrategy();
        order.setRebateStrategy(rebateStrategy);
        return order;
    }

    public Order createOrder(int orderId, Client client, RebateStrategy rebateStrategy) {
        Order order = new Order(orderId, client, Order.State.DRAFT);
        order.setOrderState(new OrderDraftState());
        order.setRebateStrategy(rebateStrategy);
        return order;
    }

}
