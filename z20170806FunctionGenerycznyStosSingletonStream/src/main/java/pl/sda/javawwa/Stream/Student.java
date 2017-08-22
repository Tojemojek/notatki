package pl.sda.javawwa.Stream;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    private String name;
    private String lastName;
    private Integer age;
    private List<Integer> scores = new ArrayList<>();


    public Student(String name, String lastName, Integer age, List<Integer> scores) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.scores = scores;
    }

    public static Student of(String name, String lastName, Integer age, List<Integer> scores) {
        return new Student (name, lastName, age,scores);

    }

    public Integer getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public List<Integer> getScores() {
        return scores;
    }
}
