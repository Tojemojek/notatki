package pl.sda.javawwa.rest.uslugi.prostySklepRest.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Zamowienie {
    private UUID id;
    private List<OrderItem> listaZakupow;

    public Zamowienie() {
        id = UUID.randomUUID();
        listaZakupow = new ArrayList<>();
    }

    public UUID getId() {
        return id;
    }

    public List<OrderItem> getListaZakupow() {
        return listaZakupow;
    }

    public void addItemToZamowienie(OrderItem orderItem){
        listaZakupow.add(orderItem);
    }

    @Override
    public String toString() {
        return "Zamowienie{" +
                "id=" + id +
                '}';
    }
}
