package pl.sda.javawwa.streamCwiczenia.Util;

import pl.sda.javawwa.streamCwiczenia.model.Gender;
import pl.sda.javawwa.streamCwiczenia.model.Person;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class PersonaConverter {

    private static Random randomGenerator = new Random();

    private static Integer generateSalary() {
        return randomGenerator.nextInt(100000);
    }

    private static Integer integerOrNull(String value) {

        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return null;
        }

    }

    public static List<Person> convertFromListArrays(List<String[]> input) {

        int[] indexOrder = new int[]{1, 2, 8, 3, 0, 10};

        return input.stream()
                .filter(line -> integerOrNull(line[8]) != null)
                .map(line -> {
                    String name = line[1].replaceAll("\"","");
                    String surname = line[2].replaceAll("\"","");
                    Integer age = integerOrNull(line[8]);
                    String city = line[3];
                    Gender gender = Gender.getGender(line[0]);
                    String occupation = line[10].replaceAll("\"","");
                    Integer salary = generateSalary();
                    return new Person(name,surname,age,city,gender,occupation,salary);
                }).collect(Collectors.toList());
    }

}
