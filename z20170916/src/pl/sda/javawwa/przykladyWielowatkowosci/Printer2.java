package pl.sda.javawwa.przykladyWielowatkowosci;

public class Printer2 {

    public void print(String s) {

        System.out.println("Poza blokiem synchronizowanym " + s);

        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                System.out.println(i + " " + s);
            }
        }
    }
}
