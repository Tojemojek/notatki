package pl.sda.javawwa.sklepik.strategy;

import pl.sda.javawwa.sklepik.domain.Money;
import pl.sda.javawwa.sklepik.domain.Order;

public class PercentageRebateStrategy implements RebateStrategy{

    private final float CURRENT_DISCOUNT =0.1f;

    @Override
    public Money calculateRebate(Order order) {
        Money currentCost = order.getCurrentCost();
        Money discountValue = currentCost.multiplyBy(CURRENT_DISCOUNT);
        return discountValue;
    }
}
