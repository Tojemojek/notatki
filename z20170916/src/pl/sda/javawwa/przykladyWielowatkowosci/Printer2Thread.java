package pl.sda.javawwa.przykladyWielowatkowosci;

public class Printer2Thread extends Thread {

    private Printer2 printer;

    public Printer2Thread(Printer2 printer, String name) {
        super(name);
        this.printer = printer;
    }

    @Override
    public void run() {
        printer.print(getName());
        try {
            sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
