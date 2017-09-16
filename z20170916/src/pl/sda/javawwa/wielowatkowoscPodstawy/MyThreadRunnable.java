package pl.sda.javawwa.wielowatkowoscPodstawy;

public class MyThreadRunnable implements Runnable {

    private String name;

    public MyThreadRunnable(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(name + " " + i);
        }
    }
}
