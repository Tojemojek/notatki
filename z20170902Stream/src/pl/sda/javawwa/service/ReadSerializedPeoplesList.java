package pl.sda.javawwa.service;

import pl.sda.javawwa.model.Person;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class ReadSerializedPeoplesList {

    public static void readFile(List<Person> people) {
        try (FileInputStream fileIn = new FileInputStream("personList.ser");
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            people.addAll((ArrayList<Person>) in.readObject());
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Klasa nie znaleziona");
            c.printStackTrace();
            return;
        }
    }

}
