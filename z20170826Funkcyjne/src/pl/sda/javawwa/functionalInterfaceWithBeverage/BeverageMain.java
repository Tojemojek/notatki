package pl.sda.javawwa.functionalInterfaceWithBeverage;

import pl.sda.javawwa.model2.Beverage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BeverageMain {

    static List<Beverage> beverages = new ArrayList<>();

    public static void main(String[] args) {

        beverageInit();

        System.out.println("\nWszystkie napoje bezalkoholowe a pojemności od <0,5litra do 1,00litra >");
        beverages.stream()
                .filter(b -> b.getCapacity() >= 0.5 && b.getCapacity() <= 1)
                .filter(b -> b.isSoft())
                .forEach(System.out::println);

        System.out.println("\nNapoje posortowane po cenach rosnąco");
        beverages.stream()
                //metoda na użycie dowolnych liczb przy metodzie
                //sorted ze stringa
                //pamiętać że comparator wymaga żeby wynik był w incie jeśli większe to int >0
                //jeśli mniejsze to int <0
                .sorted((a, b) -> (int) (a.getPrice() * 100 - b.getPrice() * 100))
                .forEach(System.out::println);

        System.out.println("\nNapoje posortowane po cenach malejąco ale za pomocą opakowania do obiektowego Double");
        beverages.stream()
                .sorted((a, b) -> -1 * Double.valueOf(a.getPrice()).compareTo(b.getPrice()))
                .forEach(System.out::println);

    }

    static void beverageInit() {

        beverages.add(new Beverage("Black", 3.0, 0.2, true));
        beverages.add(new Beverage("Pepsi", 4.0, 1.5, true));
        beverages.add(new Beverage("Helena", 1.5, 1.5, true));
        beverages.add(new Beverage("Kwas chlebowy", 4.0, 1.0, true));
        beverages.add(new Beverage("Wyborowa", 18.0, 0.7, false));
        beverages.add(new Beverage("Piwo", 2.2, 0.5, false));
        beverages.add(new Beverage("Samogon", 5.0, 1.25, false));

    }


}
