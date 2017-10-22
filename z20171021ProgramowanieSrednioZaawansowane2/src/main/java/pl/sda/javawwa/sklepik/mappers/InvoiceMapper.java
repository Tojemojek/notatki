package pl.sda.javawwa.sklepik.mappers;

import pl.sda.javawwa.sklepik.domain.Invoice;
import pl.sda.javawwa.sklepik.domain.Order;

public interface InvoiceMapper {

    public Invoice map(Order order);

}
