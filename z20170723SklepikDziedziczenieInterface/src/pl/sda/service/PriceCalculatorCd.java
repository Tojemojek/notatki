package pl.sda.service;

import pl.sda.objects.Cd;
import pl.sda.objects.Product;

public class PriceCalculatorCd extends AbstractProductService {

    public static final Integer CD_MARGIN =30;

    @Override
    public Integer calculatePrice(Product product) {
        return product.getBasePrice() + CD_MARGIN;
    }


}
