package pl.sda.wzorce.PersonSingleton;

public class Person {

    private static Person INSTANCE_PERSON;

    private String name;
    private String surname;

    private Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public static Person getInstance() {

        if (INSTANCE_PERSON == null) {
            synchronized (Person.class) {
                if (INSTANCE_PERSON == null) {
                    System.out.println("Tworzenie obiektu bo pierwszego nie ma jeszcze nic");
                    INSTANCE_PERSON = new Person("K", "O");
                }
            }
            return INSTANCE_PERSON;
        }
        return INSTANCE_PERSON;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
