package pl.sda.javawwa.OutputInput;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class B002FileReader {

    public static void main(String[] args) {

        try (FileReader reader = new FileReader("c:/temp/test.txt")) {

            int charAsInt = reader.read();

            while (charAsInt != -1) {
                System.out.print((char) charAsInt);
                charAsInt = reader.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
