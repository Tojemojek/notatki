package pl.sda.javawwa.przykladyWielowatkowosci;

public class Printer3Thread extends Thread {

    private Printer3 printer;

    public Printer3Thread(Printer3 printer, String name) {
        super(name);
        this.printer = printer;
    }

    @Override
    public void run() {
        Printer3.print(getName());
        try {
            sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
