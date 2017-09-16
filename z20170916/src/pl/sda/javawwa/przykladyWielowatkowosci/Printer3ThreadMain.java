package pl.sda.javawwa.przykladyWielowatkowosci;

public class Printer3ThreadMain {

    public static void main(String[] args) {

        Printer3 printer = new Printer3();

        Printer3Thread t1 = new Printer3Thread(printer, "wątek1");
        Printer3Thread t2 = new Printer3Thread(printer, "wątek2");
        Printer3Thread t3 = new Printer3Thread(printer, "wątek3");
        Printer3Thread t4 = new Printer3Thread(printer, "wątek4");
        Printer3Thread t5 = new Printer3Thread(printer, "wątek5");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

    }

}
