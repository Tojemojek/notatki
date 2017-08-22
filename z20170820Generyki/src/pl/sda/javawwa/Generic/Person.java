package pl.sda.javawwa.Generic;

public class Person implements Namable {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
