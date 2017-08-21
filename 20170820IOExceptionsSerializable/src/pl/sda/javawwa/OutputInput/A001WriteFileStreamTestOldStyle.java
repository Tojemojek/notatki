package pl.sda.javawwa.OutputInput;

import java.io.*;

public class A001WriteFileStreamTestOldStyle {

    public static void main(String[] args) {


        try {
            FileOutputStream fas = new FileOutputStream("c:/temp/test.txt");
            OutputStreamWriter writer = new OutputStreamWriter(fas);
            writer.write("Dupa");
            writer.flush();
        } catch (FileNotFoundException e){ //ten błąd z file output stream
            e.printStackTrace();
        } catch (IOException e) { //ten wymusił writer
            e.printStackTrace();
        }


    }

}
