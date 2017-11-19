package pl.sda.javawwa.orders.dao;

import pl.sda.javawwa.orders.entieties.Order;

public interface OrderDao {

    public void insertOrder(Order order);

    //todo praca domowa
    //przy jednym połączeniu
    //wyciągnięcie z tabeli Order i przypisanie do obiektu Order
    //wyciąganie z tabeli OrderItem listy produktów
    //wyciągnięcie też produktów

    public Order findById(Integer id);

}
