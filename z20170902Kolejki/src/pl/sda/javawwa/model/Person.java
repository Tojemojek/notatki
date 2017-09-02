package pl.sda.javawwa.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class Person implements Comparable<Person> {
    private static final long serialVersionUID = 1L;

    private String name;
    private String surname;
    private JobPosition jobPosition;

    public static long getSerialVersionUID() {
        return serialVersionUID;
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

    public JobPosition getJobPosition() {
        return jobPosition;
    }

    public void setJobPosition(JobPosition jobPosition) {
        this.jobPosition = jobPosition;
    }

    public Person(String name, String surname, JobPosition jobPosition) {
        this.name = name;
        this.surname = surname;
        this.jobPosition = jobPosition;

    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", jobPosition=" + jobPosition +
                '}';
    }

    @Override
    public int compareTo(Person o) {
        // to jest to samo
        // return o.jobPosition.getPriority() -this.jobPosition.getPriority();

        if (this.jobPosition.getPriority() > o.jobPosition.getPriority()) {
            return -1;
        } else if (this.jobPosition.getPriority() < o.jobPosition.getPriority()) {
            return 1;
        } else return 0;




    }
}