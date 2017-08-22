package pl.sda.javawwa;

import java.io.*;

public class Main02 {

    public static void main(String[] args) {


        FileReader inputStream = null;
        FileWriter outputStream = null;

        try {
            inputStream = new FileReader("somefile.txt");
            outputStream = new FileWriter("someFile2.txt");

            int c;

            while ((c = inputStream.read()) != -1) {
                outputStream.write(c);
            }

        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
