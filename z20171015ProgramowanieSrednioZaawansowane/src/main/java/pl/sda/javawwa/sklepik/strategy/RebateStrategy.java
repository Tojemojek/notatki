package pl.sda.javawwa.sklepik.strategy;

import pl.sda.javawwa.sklepik.domain.Money;
import pl.sda.javawwa.sklepik.domain.Order;

public interface RebateStrategy {

    Money calculateRebate(Order order);

}
