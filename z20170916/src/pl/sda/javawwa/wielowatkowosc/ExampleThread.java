package pl.sda.javawwa.wielowatkowosc;

public class ExampleThread {
    public static void main(String[] args) {
//
//        Thread.activeCount()
//        Thread.currentThread()

        System.out.println("Przed zaśnięciem");

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Po zaśnięciu");

    }


}
