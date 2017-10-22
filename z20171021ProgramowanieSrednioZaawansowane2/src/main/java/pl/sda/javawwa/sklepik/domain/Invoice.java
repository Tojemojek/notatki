package pl.sda.javawwa.sklepik.domain;

import java.util.ArrayList;
import java.util.List;

public class Invoice {

    private int orderId;

    private Client client;

    private List<InvoiceItem> items;

    public void add(InvoiceItem invoiceItem) {
        if (items == null) {
            items = new ArrayList<>();
        }

        items.add(invoiceItem);

    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }


}
