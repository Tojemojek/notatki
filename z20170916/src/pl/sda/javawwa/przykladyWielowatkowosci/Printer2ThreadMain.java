package pl.sda.javawwa.przykladyWielowatkowosci;

public class Printer2ThreadMain {

    public static void main(String[] args) {

        Printer2 printer = new Printer2();

        Printer2Thread t1 = new Printer2Thread(printer, "wątek1");
        Printer2Thread t2 = new Printer2Thread(printer, "wątek2");
        Printer2Thread t3 = new Printer2Thread(printer, "wątek3");
        Printer2Thread t4 = new Printer2Thread(printer, "wątek4");
        Printer2Thread t5 = new Printer2Thread(printer, "wątek5");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

    }

}
