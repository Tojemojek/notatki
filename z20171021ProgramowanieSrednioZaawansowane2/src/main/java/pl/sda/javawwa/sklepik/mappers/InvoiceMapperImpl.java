package pl.sda.javawwa.sklepik.mappers;

import pl.sda.javawwa.sklepik.domain.Invoice;
import pl.sda.javawwa.sklepik.domain.InvoiceItem;
import pl.sda.javawwa.sklepik.domain.Order;
import pl.sda.javawwa.sklepik.domain.OrderItem;

public class InvoiceMapperImpl implements InvoiceMapper {

    @Override
    public Invoice map(Order order) {
        Invoice invoice = new Invoice();

        invoice.setOrderId(order.getOrderID());
        invoice.setClient(order.getClient());


        for (OrderItem orderItem : order.getItems()) {

            InvoiceItem invoiceItem = new InvoiceItem(orderItem.getProduct(), orderItem.getQuantity());
            invoice.add(invoiceItem);
        }

        return invoice;
    }
}
