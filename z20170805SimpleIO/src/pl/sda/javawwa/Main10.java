package pl.sda.javawwa;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main10 {

    public static void main(String[] args) {


        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new FileInputStream("somefile.txt");
            out = new FileOutputStream("someFile2.txt");

            int s;

            while ((s = in.read()) != -1) {
                out.write(s);
            }

        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            try {
                if (in != null) {
                    in.close();
                }
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }
}
