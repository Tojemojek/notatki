package pl.sda.javawwa.Object;

public class Person {

    private String name;
    private String surname;
    private String job;

    public Person(String name, String surname, String job) {
        this.name = name;
        this.surname = surname;
        this.job = job;
    }

    @Override
    public String toString() {
        return name + '\t' + surname + '\t' + job;
    }
}
