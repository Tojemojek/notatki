package pl.sda.javawwa.GenerycznyStos;

import pl.sda.javawwa.GenerycznyStos.GenerycznyStos;
import pl.sda.javawwa.User;

import java.io.*;

public class GenerycznyStosMain {

    public static void main(String[] args) {

        GenerycznyStos<String> stos1 = new GenerycznyStos<>();


        stos1.push("Duupa1");
        stos1.push("Duupa2");
        stos1.push("Duupa3");
        stos1.push("Duupa4");

        stos1.peek();

        stos1.pop();

        stos1.isEmpty();


        stos1.isEmpty();
















        User user1 = new User("Imie1", "Nazwisko");
        User userread = null;

        try (
                FileOutputStream fileOutputStream = new FileOutputStream("serializowanyObiekt");
        ObjectOutputStream out = new ObjectOutputStream(fileOutputStream);
        ) {
            out.writeObject(user1);

        } catch (IOException e) {
            e.printStackTrace();
        }



        try (
                FileInputStream fileInputStream = new FileInputStream("serializowanyObiekt");
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        ) {
            userread = (User) objectInputStream.readObject();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }


        System.out.println("Obiekt wczytany");
        if (userread!= null) {
            System.out.println(userread.getName());
            System.out.println(userread.getLastName());
        }



    }
}







