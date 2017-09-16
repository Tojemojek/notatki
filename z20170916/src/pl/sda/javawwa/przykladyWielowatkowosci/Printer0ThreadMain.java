package pl.sda.javawwa.przykladyWielowatkowosci;

public class Printer0ThreadMain {

    public static void main(String[] args) {

        Printer0 printer = new Printer0();

        Printer0Thread t1 = new Printer0Thread(printer, "wątek1");
        Printer0Thread t2 = new Printer0Thread(printer, "wątek2");

        t1.start();
        t2.start();

    }

}
