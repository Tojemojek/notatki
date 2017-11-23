package pl.sda.javawwa.orders.entieties;

public class OrderItem {

    private Integer orderId;
    private Integer productId;
    private Product product;
    private Integer quantity;

    public OrderItem(Integer orderId, Product product, Integer quantity) {
        this.orderId = orderId;
        this.product = product;
        this.quantity = quantity;
        this.productId = product.getId();
    }

    public OrderItem(Integer orderId, Integer productId, Integer quantity) {
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
    }

    public Integer getOrderId() {
        return orderId;
    }


    public Integer getProductId() {
        return productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "orderId=" + orderId +
                ", productId=" + productId +
                ", product=" + product +
                ", quantity=" + quantity +
                '}';
    }
}
