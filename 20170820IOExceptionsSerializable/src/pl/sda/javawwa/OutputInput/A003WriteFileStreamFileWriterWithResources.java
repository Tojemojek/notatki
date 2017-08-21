package pl.sda.javawwa.OutputInput;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class A003WriteFileStreamFileWriterWithResources {

    public static void main(String[] args) {

        try (FileWriter writer = new FileWriter("c:/temp/test.txt")) {
            writer.write("Dupa");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

