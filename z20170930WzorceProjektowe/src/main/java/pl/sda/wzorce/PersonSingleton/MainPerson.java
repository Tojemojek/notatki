package pl.sda.wzorce.PersonSingleton;

public class MainPerson {

    public static void main(String[] args) {

        System.out.println("Stworzenie pierwszej instancji");
        Person p1 = Person.getInstance();

        System.out.println("Stworzenie drugiej instancji");
        Person p2 = Person.getInstance();

        System.out.println(p1);
        System.out.println(p2);
    }



}
