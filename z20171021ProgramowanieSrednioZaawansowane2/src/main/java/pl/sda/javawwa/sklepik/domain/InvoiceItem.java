package pl.sda.javawwa.sklepik.domain;

public class InvoiceItem {

    private final double TAX_RATE = 0.23;
    private Product product;
    private int quantity;

    public InvoiceItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Money getNetCost() {
        Money moneyTmp = product.getPrice().multiplyBy(quantity);
        return moneyTmp;
    }

    public Money getGrosCost() {
        Money netCost = getNetCost();
        Money tax = netCost.multiplyBy(TAX_RATE);
        return netCost.add(tax);
    }

}
