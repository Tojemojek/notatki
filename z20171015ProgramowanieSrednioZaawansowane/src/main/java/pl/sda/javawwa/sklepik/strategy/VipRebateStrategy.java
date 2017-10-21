package pl.sda.javawwa.sklepik.strategy;

import pl.sda.javawwa.sklepik.domain.Client;
import pl.sda.javawwa.sklepik.domain.Money;
import pl.sda.javawwa.sklepik.domain.Order;

public class VipRebateStrategy implements RebateStrategy {

    @Override
    public Money calculateRebate(Order order) {
        Client tmpClient = order.getClient();
        Client.ClientType clientTypeTmp = tmpClient.getType();

        Money minimumOrderCost = new Money("10.00");
        Money rebate = new Money("0.00");

        Money currentCostTmp = order.getCurrentCost();

        if (clientTypeTmp.equals(Client.ClientType.VIP) && (currentCostTmp.compareTo(minimumOrderCost) > 0)) {
            rebate = new Money("1.00");
        }
        return rebate;

    }


}
