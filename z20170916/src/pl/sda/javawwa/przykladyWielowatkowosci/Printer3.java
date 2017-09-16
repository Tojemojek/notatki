package pl.sda.javawwa.przykladyWielowatkowosci;

public class Printer3 {

    public static void print(String s) {

        System.out.println("Poza blokiem synchronizowanym " + s);

        synchronized (Printer3.class) {
            for (int i = 0; i < 10; i++) {
                System.out.println(i + " " + s);
            }
        }
    }
}
