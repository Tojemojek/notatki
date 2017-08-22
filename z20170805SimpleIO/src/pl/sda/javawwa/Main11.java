package pl.sda.javawwa;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main11 {

    public static void main(String[] args) {


        //try with resources
        //działa tylko dla klas które implementują metodę closable
        //to rozwiązuje automatycznie sprawę zamykania strumieni danych
        //try zamyka je za nas samo
        try (
                FileInputStream in = new FileInputStream("somefile.txt");
                FileOutputStream out = new FileOutputStream("someFile2.txt");
        ) {

            int s;
            while ((s = in.read()) != -1) {
                out.write(s);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}

