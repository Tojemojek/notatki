package pl.sda.javawwa.OutputInput;

import java.io.*;

public class A002WriteFileStreamFileWriter {

    public static void main(String[] args) {

        FileWriter writer = null;

        try {
            writer = new FileWriter("c:/temp/test.txt");
            writer.write("Dupa");

        } catch (FileNotFoundException e) { //ten błąd z file output stream
            e.printStackTrace();
        } catch (IOException e) { //ten wymusił writer
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
