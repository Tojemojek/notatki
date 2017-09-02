package pl.sda.javawwa.model;

public class Person4 implements Comparable<Person4> {

    private String name;
    private String surname;
    private String pesel;

    public Person4(String name, String surname, String pesel) {
        this.name = name;
        this.surname = surname;
        this.pesel = pesel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }


    @Override
    public int compareTo(Person4 o) {
        if (this.getSurname().compareTo(o.getSurname()) == 0) {
            return this.getName().compareTo(o.getName());
        }
        return this.getSurname().compareTo(o.getSurname());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person4 person4 = (Person4) o;

        if (name != null ? !name.equals(person4.name) : person4.name != null) return false;
        if (surname != null ? !surname.equals(person4.surname) : person4.surname != null) return false;
        return pesel != null ? pesel.equals(person4.pesel) : person4.pesel == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (pesel != null ? pesel.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Person4{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", pesel='" + pesel + '\'' +
                '}';
    }
}
