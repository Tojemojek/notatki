package pl.sda.javawwa;

import java.io.IOException;

public class Main30 {


    public static void main(String[] args) {
        int ch;
        System.out.println("Enter some text ");

        try {
            while ((ch = System.in.read()) != '\n')
                System.out.print((char) ch);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}