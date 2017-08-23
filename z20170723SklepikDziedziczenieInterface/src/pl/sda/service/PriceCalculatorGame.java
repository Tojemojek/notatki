package pl.sda.service;

import pl.sda.objects.Game;
import pl.sda.objects.Product;

public class PriceCalculatorGame extends AbstractProductService{

    public static final Integer GAME_MARGIN =50;

    @Override
    public Integer calculatePrice(Product product) {
        return product.getBasePrice() + GAME_MARGIN;
    }
}
