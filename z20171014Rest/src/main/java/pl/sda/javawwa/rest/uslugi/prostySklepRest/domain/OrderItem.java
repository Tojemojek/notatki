package pl.sda.javawwa.rest.uslugi.prostySklepRest.domain;

import java.math.BigDecimal;

public class OrderItem {

    private Produkt product;
    private int quantity;

    public OrderItem(Produkt product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Produkt getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getCost(){
        BigDecimal moneyTmp = product.getCena().multiply(new BigDecimal(quantity));
        return moneyTmp;
    }

}
