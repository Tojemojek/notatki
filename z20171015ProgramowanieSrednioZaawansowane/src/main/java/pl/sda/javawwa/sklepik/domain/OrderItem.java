package pl.sda.javawwa.sklepik.domain;

class OrderItem {

    private Product product;
    private int quantity;

    public OrderItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public Money getCost(){
        Money moneyTmp = product.getPrice().multiplyBy(quantity);
        return moneyTmp;
    }

}
