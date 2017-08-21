package pl.sda.javawwa.OutputInput;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class B001BufferedReader {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new FileReader("c:/temp/test.txt"))) {


            String line;

            while ((line = reader.readLine()) != null){
            System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

