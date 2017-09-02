package pl.sda.javawwa.model;

public class Person2 implements Comparable<Person2> {
    private static final long serialVersionUID = 1L;

    private String name;
    private String surname;
    private JobPosition jobPosition;
    private String addressStreet;
    private Integer buildingNo;

    public Person2(String name, String surname, JobPosition jobPosition, String addressStreet, Integer buildingNo) {
        this.name = name;
        this.surname = surname;
        this.jobPosition = jobPosition;
        this.addressStreet = addressStreet;
        this.buildingNo = buildingNo;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", jobPosition=" + jobPosition +
                ", addressStreet='" + addressStreet + '\'' +
                ", buildingNo=" + buildingNo +
                '}';
    }

    @Override
    public int compareTo(Person2 o) {
        if (this.addressStreet.compareTo(o.addressStreet) == 0) {
            if (this.buildingNo > o.buildingNo) {
                return 1;
            } else if (this.buildingNo < o.buildingNo) {
                return -1;
            } else return 0;
        } else return this.addressStreet.compareTo(o.addressStreet);

    }
}