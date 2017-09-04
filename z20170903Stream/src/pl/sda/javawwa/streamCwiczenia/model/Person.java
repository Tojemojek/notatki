package pl.sda.javawwa.streamCwiczenia.model;

public class Person {

    private String name;
    private String surname;
    private Integer age;
    private String city;
    private Gender gender;
    private String occupation;
    private Integer salary;


    public Person() {
    }

    public Person(String name, String surname, Integer age, String city, Gender gender, String occupation, Integer salary) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.city = city;
        this.gender = gender;
        this.occupation = occupation;
        this.salary = salary;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                ", gender=" + gender +
                ", occupation='" + occupation + '\'' +
                ", salary=" + salary +
                '}';
    }


}
