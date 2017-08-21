package pl.sda.javawwa.dto;

import java.io.*;

public class Main {

    public static void main(String[] args) {


        SerializableObject asda = new SerializableObject("asd","asdfsa",126);
        System.out.println(asda);


        try (ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream("c:/temp/serializable.dupa"))){

            objOut.writeObject(asda);

        } catch (IOException e) {
            e.printStackTrace();
        }

        SerializableObject asda1 = null;

        try (ObjectInputStream objOut = new ObjectInputStream(new FileInputStream("c:/temp/serializable.dupa"))){

            asda1 = (SerializableObject)objOut.readObject();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        System.out.println(asda1);
    }
}
