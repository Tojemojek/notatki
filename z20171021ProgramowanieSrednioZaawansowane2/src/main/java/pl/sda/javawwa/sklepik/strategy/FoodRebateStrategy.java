package pl.sda.javawwa.sklepik.strategy;

import pl.sda.javawwa.sklepik.domain.Money;
import pl.sda.javawwa.sklepik.domain.Order;
import pl.sda.javawwa.sklepik.domain.OrderItem;
import pl.sda.javawwa.sklepik.domain.Product;

public class FoodRebateStrategy implements RebateStrategy {

    private final double REBATE_FOR_FOOD = 0.15d;

    @Override
    public Money calculateRebate(Order order) {

        Money rebate = new Money("0.00");

        for (OrderItem item : order.getItems()) {

            Product product = item.getProduct();

            if (product.getProductType().equals(Product.ProductType.FOOD)) {

                Money cost = item.getCost();
                Money rebateForSingleItem = cost.multiplyBy(REBATE_FOR_FOOD);

                rebate = rebate.add(rebateForSingleItem);
            }

        }

        return rebate;
    }
}