package pl.sda.javawwa;


import pl.sda.javawwa.sklepik.domain.*;
import pl.sda.javawwa.sklepik.factory.OrderFactory;

import java.math.BigDecimal;

public class OrderApplication {
    public static void main(String[] args) {

        OrderFactory orderFactory = new OrderFactory();

        Client klient = new Client("K","O","tojemoje", Client.ClientType.VIP);

        Order order = orderFactory.createOrder(1, klient);

        System.out.println("\nSprawdzenie czy działa stworzenie klienta i zamówienia");
        System.out.println("Order ID: " + order.getOrderID() + " dla Klienta: "+ order.getClient());

        Product product1 = new Product("Winiacz", new Money("3.20"), Product.ProductType.DRINK);
        Product product2 = new Product("iPhone", new Money("7999.96"), Product.ProductType.ELECTRONICS);
        Product product3 = new Product("Chipsy", new Money("9.32"), Product.ProductType.FOOD);

        order.addProduct(product1,2);
        order.addProduct(product2,1);
        order.addProduct(product3,10);

        System.out.println("\nSprawdzenie czy działa obliczanie kwoty za koszyk");
        Money currentCost = order.getCurrentCost();
        System.out.println("Order ID: " + order.getOrderID() + " dla Klienta: "+ order.getClient() + " ma wartość " + currentCost.getValue());

        Money totalCost = order.getTotalCost();
        System.out.println("\nSprawdzenie czy działa obliczanie rabatu za koszyk - czy total cost jest pomniejszony");

        System.out.println("Order ID: " + order.getOrderID() + " dla Klienta: "+ order.getClient() + " ma wartość " + totalCost.getValue());




    }
}