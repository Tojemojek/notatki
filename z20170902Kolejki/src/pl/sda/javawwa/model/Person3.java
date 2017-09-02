package pl.sda.javawwa.model;

public class Person3 implements Comparable<Person3> {
    private static final long serialVersionUID = 1L;


    private String name;
    private String surname;
    private JobPosition jobPosition;
    private String addressStreet;
    private Integer buildingNo;

    public Person3(String name, String surname, JobPosition jobPosition, String addressStreet, Integer buildingNo) {
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
    public int compareTo(Person3 o) {
        if (this.addressStreet.compareTo(o.addressStreet) == 0) {
            if (this.buildingNo > o.buildingNo) {
                return 1;
            } else if (this.buildingNo < o.buildingNo) {
                return -1;
            } else return 0;
        } else return this.addressStreet.compareTo(o.addressStreet);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person3 person3 = (Person3) o;

        if (addressStreet != null ? !addressStreet.equals(person3.addressStreet) : person3.addressStreet != null)
            return false;
        return buildingNo != null ? buildingNo.equals(person3.buildingNo) : person3.buildingNo == null;
    }

    @Override
    public int hashCode() {
        int result = addressStreet != null ? addressStreet.hashCode() : 0;
        result = 31 * result + (buildingNo != null ? buildingNo.hashCode() : 0);
        return result;
    }
}