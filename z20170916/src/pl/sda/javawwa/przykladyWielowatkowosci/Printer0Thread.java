package pl.sda.javawwa.przykladyWielowatkowosci;

public class Printer0Thread extends Thread {

    private Printer0 printer;

    public Printer0Thread(Printer0 printer, String name) {
        super(name);
        this.printer = printer;
    }

    @Override
    public void run() {
        printer.print(getName());
    }
}
