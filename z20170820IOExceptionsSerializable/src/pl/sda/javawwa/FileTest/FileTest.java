package pl.sda.javawwa.FileTest;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.File;

public class FileTest {

    public static void main(String[] args) {
        File f = new File("c:/temp");

        System.out.println("Czy istnieje " + f.exists());
        System.out.println("Czy to plik" + f.isFile());
        System.out.println("Czy jest ścieżką" + f.getPath());


        File g = new File("c:/temp/test/test2/test3");
        g.mkdirs();


        File h = new File("c:/temp/");

        h.listFiles();



    }




}
