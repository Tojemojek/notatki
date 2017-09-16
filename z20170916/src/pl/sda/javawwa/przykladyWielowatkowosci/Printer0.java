package pl.sda.javawwa.przykladyWielowatkowosci;

public class Printer0 {

    public synchronized void print(String s) {
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " " + s);
        }
    }
}
